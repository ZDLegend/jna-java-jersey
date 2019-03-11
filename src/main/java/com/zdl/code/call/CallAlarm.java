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

    private boolean OpenFaceAlarm = false;
    private boolean OpenNapAlarm = false;
    private ConcurrentHashMap<String, String> FaceData = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> NapData = new ConcurrentHashMap<>();

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
        return OpenFaceAlarm;
    }

    public boolean isOpenNapAlarm() {
        return OpenNapAlarm;
    }

    public void openFaceAlarm(String name, String data) {
        if (!OpenFaceAlarm) OpenFaceAlarm = true;
        FaceData.put(name, data);
    }

    public void openNapAlarm(String name, String data) {
        if (!OpenNapAlarm) OpenNapAlarm = true;
        NapData.put(name, data);
    }

    public void closeFaceAlarm(String name) {
        FaceData.remove(name);
        if (FaceData.size() == 0) OpenFaceAlarm = false;
    }

    public void closeNapAlarm(String name) {
        NapData.remove(name);
        if (NapData.size() == 0) OpenNapAlarm = false;
    }

    @Override
    public void invoke(int ulCmdID, Pointer pParam) {

        if (!OpenFaceAlarm && !OpenNapAlarm) return;

        switch (ulCmdID) {
            case SDKConst.NOTIFYTO_FACE_ALARM_INFO:

                SPStructure.SPS_FACE_ALARM_S faceAlarmS = new SPStructure.SPS_FACE_ALARM_S();

                //JNA封装的指针对象
                Pointer facePointer = faceAlarmS.getPointer();
                facePointer.write(0, pParam.getByteArray(0, faceAlarmS.size()), 0, faceAlarmS.size());
                faceAlarmS.read();

                String facedata = StructUtils.Struct2Json(faceAlarmS).toString();
                FaceData.forEachValue(Long.MAX_VALUE, (s1) -> HttpUtils.sendAlarm(s1, facedata));

                break;

            case SDKConst.NOTIFYTO_FACE_SNAP_INFO:

                SPStructure.SPS_FACESNAP_INFO_S facesnapInfoS = new SPStructure.SPS_FACESNAP_INFO_S();
                Pointer snapPointer = facesnapInfoS.getPointer();
                snapPointer.write(0, pParam.getByteArray(0, facesnapInfoS.size()), 0, facesnapInfoS.size());
                facesnapInfoS.read();

                String snapdata = StructUtils.Struct2Json(facesnapInfoS).toString();
                NapData.forEachValue(Long.MAX_VALUE, (s1) -> HttpUtils.sendAlarm(s1, snapdata));
                break;
            default:
                break;
        }
    }
}
