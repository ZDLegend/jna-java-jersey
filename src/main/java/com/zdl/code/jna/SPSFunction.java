package com.zdl.code.jna;

import com.sun.jna.*;

/**
 * Created by z02464 on 2016/11/21.
 */

public interface SPSFunction extends Library {

    SPSFunction INSTANCE = (SPSFunction) Native.loadLibrary(Platform.isWindows() ? "sps_sdk" : "sps_sdk",
            SPSFunction.class);

    interface SPS_CALL_BACK_ALARM_PROC_PF extends Callback {
        void invoke(int ulCmdID, Pointer pParam);
    }

    int IMOS_SPS_init();
}
