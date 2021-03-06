package com.zdl.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.SDKHandler;
import com.zdl.code.server.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static com.zdl.code.jna.SDKErrorCode.ERR_COMMON_SUCCEED;
import static com.zdl.code.server.StringUtils.getBASE64;
import static com.zdl.code.server.StringUtils.md5Util;

/**
 * Created by ZDLegend on 2016/10/19.
 * <p>
 * 用户登录资源
 * 登录过程需要调用两次登录接口才能完成
 * 第一次调用登录接口,不携带任何数据以获取登录access-code（验证码）和登录加密参数（当前
 * 固定为MD5），通过access-code一起加密相关登录参数进行第二次登录以获取后续可
 * 以使用的access-token（令牌），该令牌包含在后续客户端请求数据的http头的AUTHORIZATION
 * 域中，每次调用接口时检查该头来达到鉴权目的
 */

@Path("/login")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public class SDKLoginResource {

    private static Logger logger = LoggerFactory.getLogger(SDKLoginResource.class);

    @POST
    public JSONObject userLogin(JSONObject jsonObject) {

        JSONObject resp = new JSONObject();

        /* 第一次调用登录接口时不携带任何数据 */
        if (null == jsonObject) {
            String accessCode = UserManager.getInstance().createAccessCode();
            resp.put("access_code", accessCode);
            resp.put("encryption", "md5");
            return resp;
        }

        /* 第二次调用登录接口 */
        else {
            logger.info("第二次调用登陆接口入参{}", jsonObject);

            if (!jsonObject.containsKey("username") ||
                    !jsonObject.containsKey("access_code") ||
                    !jsonObject.containsKey("login_signature")) {

                return ResponseInfoMng.errorRsp(1, "登录验证信息错误");
            }

            String user = jsonObject.getString("username");
            String username = getBASE64(user);

            String accessCode = jsonObject.getString("access_code");
            String loginSignature = jsonObject.getString("login_signature");

            if (!UserManager.getInstance().checkAccessCode(accessCode)) {
                logger.error("验证access_code失败");
                return ResponseInfoMng.errorRsp(1, "验证access_code失败");
            }

            SDKStructure.USER_INFO_PASSWORD_S pstPassword = new SDKStructure.USER_INFO_PASSWORD_S();
            int ret = SDKHandler.getPasswd(user, pstPassword);
            if (ERR_COMMON_SUCCEED != ret) {
                logger.error("获取密码失败，{}！返回错误码：{}", ResponseInfoMng.getErrmsg(ret), ret);
                return ResponseInfoMng.errorRsp(ret, "获取密码失败");
            }

            String password = new String(pstPassword.szPassword).trim();
            if (loginSignature.equals(md5Util(username + accessCode + password))) {
                String accessToken = UserManager.getInstance().createAccessToken(accessCode, pstPassword.stUserInfo);
                resp.put("access_token", accessToken);
                logger.info("登录成功");
                return resp;
            } else {
                logger.error("密码错误，登录失败");
                return ResponseInfoMng.errorRsp(1, "密码错误，登录失败");
            }
        }
    }
}
