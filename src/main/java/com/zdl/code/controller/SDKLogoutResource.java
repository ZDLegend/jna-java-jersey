package com.zdl.code.controller;

import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.UserManager;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * Created by z02464 on 2016/11/23.
 * <p>
 * 登出
 */

@Path("/logout")
@Produces("application/json;charset=UTF-8")
public class SDKLogoutResource {

    private static Logger logger = Logger.getLogger(SDKLogoutResource.class.getName());

    /**
     * 用户退出系统
     */
    @POST
    public JSONObject UserLogout(@Context HttpHeaders headers) {

        String access_token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0);
        if (!UserManager.getInstance().checkAccessToken(access_token)) {
            logger.error("无效用户");
            return ResponseInfoMng.errorRsp(1, "无效用户");
        } else {
            UserManager.getInstance().eraseAccessToken(access_token);
            return ResponseInfoMng.correctRsp();
        }

    }
}
