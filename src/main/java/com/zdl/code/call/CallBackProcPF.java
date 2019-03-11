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

    private boolean OpenAlarm = false;
    private ConcurrentHashMap<String, String> datas = new ConcurrentHashMap<>();
    private static CallBackProcPF instance = new CallBackProcPF();

    private CallBackProcPF() {

    }

    public static CallBackProcPF getInstance() {
        return instance;
    }

    public boolean isOpenAlarm() {
        return OpenAlarm;
    }

    public void openAlarm() {
        OpenAlarm = true;
    }

    public void openAlarm(String name, String data) {
        if (!OpenAlarm) OpenAlarm = true;
        datas.put(name, data);
    }

    public void closeAlarm() {
        OpenAlarm = false;
    }

    public void closeAlarm(String name) {
        datas.remove(name);
        if (datas.size() == 0) OpenAlarm = false;
    }

    @Override
    public void invoke(SDKStructure.EVENT_RECORD_V2_S pstEventRecord) {

        if (!OpenAlarm) return;

        System.out.println("告警消息");

        String strData = StructUtils
                .filterStruct(new ComStructure.EVENT_RECORD_FILT(), pstEventRecord)
                .Struct2Json()
                .toString();

        datas.forEachValue(Long.MAX_VALUE, (s1) -> HttpUtils.sendAlarm(s1, strData));
    }
}
