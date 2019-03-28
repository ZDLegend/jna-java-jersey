package com.zdl.code.dao;

import com.zdl.code.api.CommonAPI;
import com.zdl.code.jna.SDKFunction;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.SDKHandler;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2019/3/16.
 */
public class RecordFileURLDao implements CommonAPI<SDKStructure.GET_URL_INFO_S, SDKStructure.URL_INFO_S> {


    private SDKStructure.URL_INFO_S pstSDKURLInfo = new SDKStructure.URL_INFO_S();

    @Override
    public int execute(HttpHeaders headers, SDKStructure.GET_URL_INFO_S data) {
        return SDKFunction.INSTANCE.ZDL_GetRecordFileURL(SDKHandler.userLoginIDInfo, data, pstSDKURLInfo);
    }

    @Override
    public SDKStructure.URL_INFO_S getOut() {
        return pstSDKURLInfo;
    }
}
