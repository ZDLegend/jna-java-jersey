package com.zdl.code.server;

import com.zdl.code.bean.SDKUserBean;
import com.zdl.code.jna.SDKStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZDLegend on 2016/8/10.
 * <p>
 * 用户管理类，验证码令牌管理
 * access_token（令牌）和access_code（验证码）作用详见IMPLoginResource类
 */
public class UserManager {

    /**
     * 随机字符串长度
     */
    public static final int RANDOM_STRING_LENGTH = 20;

    /**
     * access_token保留最长时间（48小时）
     */
    public static final long MAX_TIME_TOKEN_KEEP = 48 * 60 * 60 * 1000;

    /**
     * access_code保留最长时间（5分钟）
     */
    public static final long MAX_TIME_CODE_KEEP = 5 * 60 * 1000;

    /**
     * access_code管理
     */
    private Map<String, SDKUserBean> AccessCodeMng = new ConcurrentHashMap<>();

    /**
     * access_token管理
     */
    private Map<String, SDKUserBean> AccessTokenMng = new ConcurrentHashMap<>();

    private static UserManager instance = new UserManager();

    private UserManager() {

    }

    public static UserManager getInstance() {
        return instance;
    }

    /**
     * Access_Code操作
     */
    public String createAccessCode() {
        String access_code = StringUtils.getRandomString(RANDOM_STRING_LENGTH);

        if (checkAccessCode(access_code)) {
            return createAccessCode();
        } else {
            SDKUserBean user = new SDKUserBean("code", access_code);
            AccessCodeMng.put(access_code, user);
            return access_code;
        }
    }

    public SDKUserBean getAccessCode(String access_code) {
        return AccessCodeMng.get(access_code);
    }

    public boolean checkAccessCode(String access_code) {

        boolean ret;

        ret = AccessCodeMng.containsKey(access_code);

        if (ret) {
            SDKUserBean userId = getAccessCode(access_code);
            if (null == userId) {
                eraseAccessToken(access_code);
                return false;
            } else {
                return true;
            }
        }

        return ret;
    }

    public void eraseAccessCode(String access_code) {
        AccessCodeMng.get(access_code).cancelTask();
        AccessCodeMng.remove(access_code);
    }

    public void removeAccessCode(String access_code) {
        AccessCodeMng.remove(access_code);
    }

    /**
     * Access_Token操作
     */
    public String createAccessToken(String access_code, SDKStructure.USER_INFO_S userInfo) {

        String access_token = StringUtils.getRandomString(RANDOM_STRING_LENGTH);

        while (checkAccessToken(access_token)) {
            access_token = StringUtils.getRandomString(RANDOM_STRING_LENGTH);
        }

        SDKUserBean user = getAccessCode(access_code);
        user.updateUser(access_token, userInfo);
        AccessTokenMng.put(access_token, user);
        eraseAccessCode(access_code);

        return access_token;

    }

    public SDKUserBean getUserInfo(String access_token) {
        return AccessTokenMng.get(access_token);
    }

    public void updateUserInfo(String access_token) {
        SDKUserBean UserInfo = AccessTokenMng.get(access_token);
        UserInfo.updateTime();
        UserInfo.updateTimer();
    }

    public boolean checkAccessToken(String access_token) {

        boolean ret;

        ret = AccessTokenMng.containsKey(access_token);

        if (ret) {
            SDKUserBean userId = getUserInfo(access_token);
            if (null == userId) {
                eraseAccessToken(access_token);
                return false;
            } else {
                return true;
            }
        }

        return ret;
    }

    public void eraseAccessToken(String access_token) {
        AccessTokenMng.get(access_token).cancelTask();
        AccessTokenMng.remove(access_token);
    }

    public void removeAccessToken(String access_token) {
        AccessTokenMng.remove(access_token);
    }
}
