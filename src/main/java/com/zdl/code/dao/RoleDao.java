package com.zdl.code.dao;

import com.zdl.code.api.CreateAPI;
import com.zdl.code.jna.ComStructure;
import com.zdl.code.jna.SDKFunction;
import com.zdl.code.server.SDKHandler;
import com.zdl.code.server.StringUtils;
import net.sf.json.JSONArray;

import javax.ws.rs.core.HttpHeaders;

import static com.zdl.code.jna.SDKConst.ZDL_MAX_USER_ROLES_NUM;
import static com.zdl.code.jna.SDKConst.ZDL_RES_CODE_LEN;
import static com.zdl.code.jna.SDKErrorCode.ERR_COMMON_SUCCEED;
import static com.zdl.code.jna.SDKErrorCode.ERR_ROLE_NUM_OUT_FOUND;

/**
 * Created by ZDLegend on 2016/12/12.
 */
public class RoleDao implements CreateAPI<ComStructure.ROLE_INFO> {

    private static SDKFunction SDK = SDKFunction.INSTANCE;

    private byte[] aszRoleCode = new byte[ZDL_MAX_USER_ROLES_NUM * ZDL_RES_CODE_LEN];

    public int init(JSONArray list, int RoleCount) {
        int i = list.size() > RoleCount ? RoleCount : list.size();
        if (i > ZDL_MAX_USER_ROLES_NUM) {
            return ERR_ROLE_NUM_OUT_FOUND;
        }

        StringUtils.byte2Copy(aszRoleCode, list, i, ZDL_RES_CODE_LEN);
        return ERR_COMMON_SUCCEED;
    }

    @Override
    public int create(HttpHeaders headers, ComStructure.ROLE_INFO data) {
        return SDK.ZDL_AssignRoleForUser(SDKHandler.UserLoginIDInfo, data.szUserCode, aszRoleCode, data.ulRoleCount);
    }
}
