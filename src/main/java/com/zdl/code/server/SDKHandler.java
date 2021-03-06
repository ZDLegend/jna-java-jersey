package com.zdl.code.server;

import com.alibaba.fastjson.JSONObject;
import com.zdl.code.call.CallAlarm;
import com.zdl.code.call.CallBackProcPF;
import com.zdl.code.exception.SDKException;
import com.zdl.code.jna.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by ZDLegend on 2016/8/1.
 */
@Configuration
public class SDKHandler {

    /**
     * restful接口连接的SDK服务器IP地址
     */
    private static String serverIp;

    private static String loginCode;

    private static String userCode;

    /**
     * 加载各类SDK库文件（DLL/SO）
     */
    private static final SDKFunction ZDL_SDK = SDKFunction.INSTANCE;
    private static final SPSFunction SPS_SDK = SPSFunction.INSTANCE;

    public static final SDKStructure.USER_LOGIN_ID_INFO_S userLoginIDInfo = new SDKStructure.USER_LOGIN_ID_INFO_S();

    private static Logger logger = LoggerFactory.getLogger(SDKHandler.class);

    /**
     * 初始化sdk
     */
    @PostConstruct
    public void init() {

        StringUtils.arrayCopy(userLoginIDInfo.szUserLoginCode, loginCode.getBytes());
        StringUtils.arrayCopy(userLoginIDInfo.szUserCode, userCode.getBytes());

        int ret = SPS_SDK.IMOS_SPS_init();
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            logger.error("初始化SPS失败,{}返回错误码:{}", ResponseInfoMng.getErrmsg(ret), ret);
            throw new SDKException("初始化SPS失败,返回错误码:" + ret);
        } else {
            logger.info("SPS初始化成功");
        }

        ret = ZDL_SDK.ZDL_InitRestful(serverIp, CallBackProcPF.getInstance(), CallAlarm.getInstance());
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            logger.error("初始化SDK失败,{}返回错误码:{}", ResponseInfoMng.getErrmsg(ret), ret);
            throw new SDKException("初始化SDK失败,返回错误码:" + ret);
        } else {
            logger.info("SDK初始化成功");
        }
    }

    /**
     * 根据用户名获取SDK 密码
     */
    public static int getPasswd(String username,
                                SDKStructure.USER_INFO_PASSWORD_S pstPassword) {

        SDKStructure.COMMON_QUERY_CONDITION_S pstQueryCondition = new SDKStructure.COMMON_QUERY_CONDITION_S();

        pstQueryCondition.ulItemNum = 1;
        StringUtils.arrayCopy(pstQueryCondition.astQueryConditionList[0].szQueryData, username.getBytes(StandardCharsets.UTF_8));
        pstQueryCondition.astQueryConditionList[0].ulQueryType = SDKConst.QUERY_TYPE_E.USER_NAME_TYPE;
        pstQueryCondition.astQueryConditionList[0].ulLogicFlag = SDKConst.LOGIC_FLAG_E.EQUAL_FLAG;
        int ret = ZDL_SDK.ZDL_QueryUserInfoByCondition(userLoginIDInfo, pstQueryCondition, pstPassword);
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            /* 如果通过用户名获取密码失败则根据用户编码再查一遍 */
            pstQueryCondition.astQueryConditionList[0].ulQueryType = SDKConst.QUERY_TYPE_E.USER_CODE_TYPE;
            ret = ZDL_SDK.ZDL_QueryUserInfoByCondition(userLoginIDInfo, pstQueryCondition, pstPassword);
        }

        return ret;
    }

    /**
     * 设置用户权限
     */
    public static JSONObject setUserRole(HttpHeaders headers, JSONObject data) {

        String userCode = data.getJSONObject("UserPasswordInfo")
                .getJSONObject("UserInfo")
                .getString("UserCode");

        int roleCount = 1;

        byte[] usercode = new byte[SDKConst.ZDL_USER_CODE_LEN];
        byte[] rolecode = new byte[SDKConst.ZDL_MAX_USER_ROLES_NUM * SDKConst.ZDL_RES_CODE_LEN];
        StringUtils.setSdkBytes(usercode, userCode);
        StringUtils.setSdkBytes(rolecode, "1");

        int ret = ZDL_SDK.ZDL_AssignRoleForUser(getUserLoginIDInfo(headers), usercode, rolecode, roleCount);
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            logger.error("为用户赋予角色,{}返回错误码:{}", ResponseInfoMng.getErrmsg(ret), ret);
            return ResponseInfoMng.errorRsp(ret, "为用户赋予角色");
        }
        return ResponseInfoMng.correctRsp();
    }

    /**
     * 根据http头AUTHORIZATION域中的access_token值获取用户信息中的用户信息结构体
     */
    public static SDKStructure.USER_LOGIN_ID_INFO_S getUserLoginIDInfo(HttpHeaders headers) {
        String accessToken = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0);
        return UserManager.getInstance().getUserInfo(accessToken).getUserLoginIDInfo();
    }

    /**
     * 根据http头AUTHORIZATION域中的access_token值获取用户信息中的用户名
     */
    public static String getUsername(HttpHeaders headers) {
        String accessToken = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0);
        SDKStructure.USER_INFO_S userInfoS = UserManager.getInstance().getUserInfo(accessToken).getUserInfo();
        if (userInfoS.szUserName.length == 0) {
            return Arrays.toString(userInfoS.szUserCode).trim();
        }

        return Arrays.toString(userInfoS.szUserName).trim();
    }

    @Value("sdk.server.config.ip")
    public String getServerIP() {
        return serverIp;
    }

    @Value("sdk.server.config.login-code")
    public String getLoginCode() {
        return loginCode;
    }

    @Value("sdk.server.config.user-code")
    public String getUserCode() {
        return userCode;
    }
}
