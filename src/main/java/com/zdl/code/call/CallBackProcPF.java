package com.zdl.code.call;

import com.zdl.code.jna.ComStructure;
import com.zdl.code.jna.SDKFunction;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.HttpUtils;
import com.zdl.code.server.StructUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 告警回调函数
 * Created by ZDLegend on 2016/12/21.
 */
public class CallBackProcPF implements SDKFunction.CALL_BACK_ALARM_PROC_PF {

    private boolean openAlarm = false;
    private ConcurrentHashMap<String, String> data = new ConcurrentHashMap<>();
    private static CallBackProcPF instance = new CallBackProcPF();

    private CallBackProcPF() {

    }

    public static CallBackProcPF getInstance() {
        return instance;
    }

    public boolean isOpenAlarm() {
        return openAlarm;
    }

    public void openAlarm() {
        openAlarm = true;
    }

    public void openAlarm(String name, String data) {
        if (!openAlarm) openAlarm = true;
        this.data.put(name, data);
    }

    public void closeAlarm() {
        openAlarm = false;
    }

    public void closeAlarm(String name) {
        data.remove(name);
        if (data.size() == 0) openAlarm = false;
    }

    @Override
    public void invoke(SDKStructure.EVENT_RECORD_V2_S pstEventRecord) {

        if (!openAlarm) return;

        String strData = StructUtils
                .filterStruct(new ComStructure.EVENT_RECORD_FILT(), pstEventRecord)
                .struct2Json()
                .toString();

        data.forEachValue(Long.MAX_VALUE, s1 -> HttpUtils.sendAlarm(s1, strData));
    }
}
