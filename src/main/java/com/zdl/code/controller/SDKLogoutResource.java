package com.zdl.code.controller;

import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.UserManager;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/11/23.
 * <p>
 * 登出
 */

@Path("/logout")
@Produces("application/json;charset=UTF-8")
public class SDKLogoutResource {
    /**
     * 用户退出系统
     */
    @POST
    public JSONObject UserLogout(@Context HttpHeaders headers) {
        String access_token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0);
        UserManager.getInstance().eraseAccessToken(access_token);
        return ResponseInfoMng.correctRsp();
    }
}
