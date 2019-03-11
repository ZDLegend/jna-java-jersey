package com.zdl.code.dao;

import com.zdl.code.api.CreateAPI;
import com.zdl.code.api.DeleteAPI;
import com.zdl.code.api.UpdateAPI;
import com.zdl.code.jna.ComStructure;
import com.zdl.code.jna.SDKFunction;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.SDKHandler;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/11/24.
 */
public class UserDao implements CreateAPI<ComStructure.USER_INFO>,
        UpdateAPI<SDKStructure.USER_MODIFY_PASSWORD_S>, DeleteAPI {

    private static SDKFunction SDK = SDKFunction.INSTANCE;

    @Override
    public int create(HttpHeaders headers, ComStructure.USER_INFO data) {
        return SDK.ZDL_AddUser(SDKHandler.getUserLoginIDInfo(headers), data.szOrgCode, data.pstUserPasswordInfo);
    }

    @Override
    public int update(HttpHeaders headers, SDKStructure.USER_MODIFY_PASSWORD_S data) {
        return SDK.ZDL_ModifyUserPassword(SDKHandler.getUserLoginIDInfo(headers), data);
    }

    @Override
    public int delete(HttpHeaders headers, String id) {
        return SDK.ZDL_DelUser(SDKHandler.getUserLoginIDInfo(headers), id);
    }
}
