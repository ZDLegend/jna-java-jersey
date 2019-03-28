package com.zdl.code.call;

import com.sun.jna.Pointer;
import com.zdl.code.jna.SDKConst;
import com.zdl.code.jna.SPSFunction;
import com.zdl.code.jna.SPStructure;
import com.zdl.code.server.HttpUtils;
import com.zdl.code.server.StructUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * JNA 订阅回调，通过观察这模式发送订阅信息
 * <p>
 * Created by ZDLegend on 2017/1/14.
 */

public class CallAlarm implements SPSFunction.SPS_CALL_BACK_ALARM_PROC_PF {

    private boolean openFaceAlarm = false;
    private boolean openNapAlarm = false;
    private ConcurrentHashMap<String, String> faceData = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> napData = new ConcurrentHashMap<>();

    /**
     * 单例模式防止回调类被GC回收
     */
    private static CallAlarm instance = new CallAlarm();

    private CallAlarm() {

    }

    public static CallAlarm getInstance() {
        return instance;
    }

    public boolean isOpenFaceAlarm() {
        return openFaceAlarm;
    }

    public boolean isOpenNapAlarm() {
        return openNapAlarm;
    }

    public void openFaceAlarm(String name, String data) {
        if (!openFaceAlarm) openFaceAlarm = true;
        faceData.put(name, data);
    }

    public void openNapAlarm(String name, String data) {
        if (!openNapAlarm) openNapAlarm = true;
        napData.put(name, data);
    }

    public void closeFaceAlarm(String name) {
        faceData.remove(name);
        if (faceData.size() == 0) openFaceAlarm = false;
    }

    public void closeNapAlarm(String name) {
        napData.remove(name);
        if (napData.size() == 0) openNapAlarm = false;
    }

    @Override
    public void invoke(int ulCmdID, Pointer pParam) {

        if (!openFaceAlarm && !openNapAlarm) return;

        switch (ulCmdID) {
            case SDKConst.NOTIFYTO_FACE_ALARM_INFO:

                SPStructure.SPS_FACE_ALARM_S faceAlarmS = new SPStructure.SPS_FACE_ALARM_S();

                //JNA封装的指针对象
                Pointer facePointer = faceAlarmS.getPointer();
                facePointer.write(0, pParam.getByteArray(0, faceAlarmS.size()), 0, faceAlarmS.size());
                faceAlarmS.read();

                String facedata = StructUtils.struct2Json(faceAlarmS).toString();
                faceData.forEachValue(Long.MAX_VALUE, s1 -> HttpUtils.sendAlarm(s1, facedata));

                break;

            case SDKConst.NOTIFYTO_FACE_SNAP_INFO:

                SPStructure.SPS_FACESNAP_INFO_S facesnapInfoS = new SPStructure.SPS_FACESNAP_INFO_S();
                Pointer snapPointer = facesnapInfoS.getPointer();
                snapPointer.write(0, pParam.getByteArray(0, facesnapInfoS.size()), 0, facesnapInfoS.size());
                facesnapInfoS.read();

                String snapdata = StructUtils.struct2Json(facesnapInfoS).toString();
                napData.forEachValue(Long.MAX_VALUE, s1 -> HttpUtils.sendAlarm(s1, snapdata));
                break;
            default:
                break;
        }
    }
}
