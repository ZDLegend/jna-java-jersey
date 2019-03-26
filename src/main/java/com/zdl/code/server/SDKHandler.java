package com.zdl.code.server;

import com.alibaba.fastjson.JSONObject;
import com.zdl.code.call.CallAlarm;
import com.zdl.code.call.CallBackProcPF;
import com.zdl.code.jna.*;
import org.apache.log4j.Logger;

import javax.ws.rs.core.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by ZDLegend on 2016/8/1.
 */
public class SDKHandler {

    /**
     * restful接口连接的SDK服务器IP地址
     */
    private static String serverIP;

    /**
     * 加载各类SDK库文件（DLL/SO）
     */
    private static SDKFunction ZDL_SDK = null;
    private static SPSFunction SPS_SDK = null;

    public static SDKStructure.USER_LOGIN_ID_INFO_S UserLoginIDInfo = new SDKStructure.USER_LOGIN_ID_INFO_S();

    private static Logger logger = Logger.getLogger(SDKHandler.class.getName());

    static {
        StringUtils.ArrayCopy(UserLoginIDInfo.szUserLoginCode, "IS_INSIDE_V5_INNER".getBytes());
        StringUtils.ArrayCopy(UserLoginIDInfo.szUserCode, "0000".getBytes());
    }

    public SDKHandler() {
        try {
            ZDL_SDK = SDKFunction.INSTANCE;
            SPS_SDK = SPSFunction.INSTANCE;
        } catch (Exception e) {
            logger.error(e.toString());
        }

        serverIP = ConfigFileMng.getServerIp();
    }

    /**
     * 初始化sdk
     */
    public void init() {

        int ret = SPS_SDK.IMOS_SPS_init();
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            logger.error("初始化SPS失败," + ResponseInfoMng.getErrmsg(ret) + "返回错误码:" + ret);
            throw new RuntimeException("初始化SPS失败,返回错误码:" + ret);
        } else {
            logger.info("SPS初始化成功");
        }

        ret = ZDL_SDK.ZDL_InitRestful(serverIP, CallBackProcPF.getInstance(), CallAlarm.getInstance());
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            logger.error("初始化SDK失败," + ResponseInfoMng.getErrmsg(ret) + "返回错误码:" + ret);
            throw new RuntimeException("初始化SDK失败,返回错误码:" + ret);
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
        StringUtils.ArrayCopy(pstQueryCondition.astQueryConditionList[0].szQueryData, username.getBytes(StandardCharsets.UTF_8));
        pstQueryCondition.astQueryConditionList[0].ulQueryType = SDKConst.QUERY_TYPE_E.USER_NAME_TYPE;
        pstQueryCondition.astQueryConditionList[0].ulLogicFlag = SDKConst.LOGIC_FLAG_E.EQUAL_FLAG;
        int ret = ZDL_SDK.ZDL_QueryUserInfoByCondition(UserLoginIDInfo, pstQueryCondition, pstPassword);
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            /* 如果通过用户名获取密码失败则根据用户编码再查一遍 */
            pstQueryCondition.astQueryConditionList[0].ulQueryType = SDKConst.QUERY_TYPE_E.USER_CODE_TYPE;
            ret = ZDL_SDK.ZDL_QueryUserInfoByCondition(UserLoginIDInfo, pstQueryCondition, pstPassword);
        }

        return ret;
    }

    /**
     * 设置用户权限
     */
    public static JSONObject setUserRole(HttpHeaders headers, JSONObject data) {

        String UserCode = data.getJSONObject("UserPasswordInfo")
                .getJSONObject("UserInfo")
                .getString("UserCode");

        int RoleCount = 1;

        byte[] usercode = new byte[SDKConst.ZDL_USER_CODE_LEN];
        byte[] rolecode = new byte[SDKConst.ZDL_MAX_USER_ROLES_NUM * SDKConst.ZDL_RES_CODE_LEN];
        StringUtils.setSdkBytes(usercode, UserCode);
        StringUtils.setSdkBytes(rolecode, "1");

        int ret = ZDL_SDK.ZDL_AssignRoleForUser(getUserLoginIDInfo(headers), usercode, rolecode, RoleCount);
        if (SDKErrorCode.ERR_COMMON_SUCCEED != ret) {
            logger.error("为用户赋予角色，" + ResponseInfoMng.getErrmsg(ret) + "！返回错误码：" + ret);
            return ResponseInfoMng.errorRsp(ret, "为用户赋予角色");
        }
        return ResponseInfoMng.correctRsp();
    }

    /**
     * 根据http头AUTHORIZATION域中的access_token值获取用户信息中的用户信息结构体
     */
    public static SDKStructure.USER_LOGIN_ID_INFO_S getUserLoginIDInfo(HttpHeaders headers) {
        String access_token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0);
        return UserManager.getInstance().getUserInfo(access_token).getUserLoginIDInfo();
    }

    /**
     * 根据http头AUTHORIZATION域中的access_token值获取用户信息中的用户名
     */
    public static String getUsername(HttpHeaders headers) {
        String access_token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0);
        SDKStructure.USER_INFO_S userInfoS = UserManager.getInstance().getUserInfo(access_token).getUserInfo();
        if (userInfoS.szUserName.length == 0) {
            return Arrays.toString(userInfoS.szUserCode).trim();
        }

        return Arrays.toString(userInfoS.szUserName).trim();
    }
}
