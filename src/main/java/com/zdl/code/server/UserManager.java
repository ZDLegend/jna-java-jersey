package com.zdl.code.server;

import com.zdl.code.bean.SDKUserBean;
import com.zdl.code.jna.SDKStructure;

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
    private static final int RANDOM_STRING_LENGTH = 20;

    /**
     * access_token保留最长时间（48小时）
     */
    public static final long MAX_TIME_TOKEN_KEEP = 48 * 60 * 60 * 1000L;

    /**
     * access_code保留最长时间（5分钟）
     */
    public static final long MAX_TIME_CODE_KEEP = 5 * 60 * 1000L;

    /**
     * access_code管理
     */
    private Map<String, SDKUserBean> accessCodeMng = new ConcurrentHashMap<>();

    /**
     * access_token管理
     */
    private Map<String, SDKUserBean> accessTokenMng = new ConcurrentHashMap<>();

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
        String accessCode = StringUtils.getRandomString(RANDOM_STRING_LENGTH);

        if (checkAccessCode(accessCode)) {
            return createAccessCode();
        } else {
            SDKUserBean user = new SDKUserBean("code", accessCode);
            accessCodeMng.put(accessCode, user);
            return accessCode;
        }
    }

    public SDKUserBean getAccessCode(String accessCode) {
        return accessCodeMng.get(accessCode);
    }

    public boolean checkAccessCode(String accessCode) {

        boolean ret;

        ret = accessCodeMng.containsKey(accessCode);

        if (ret) {
            SDKUserBean userId = getAccessCode(accessCode);
            if (null == userId) {
                eraseAccessToken(accessCode);
                return false;
            } else {
                return true;
            }
        }

        return ret;
    }

    public void eraseAccessCode(String accessCode) {
        accessCodeMng.get(accessCode).cancelTask();
        accessCodeMng.remove(accessCode);
    }

    public void removeAccessCode(String accessCode) {
        accessCodeMng.remove(accessCode);
    }

    /**
     * Access_Token操作
     */
    public String createAccessToken(String accessCode, SDKStructure.USER_INFO_S userInfo) {

        String accessToken = StringUtils.getRandomString(RANDOM_STRING_LENGTH);

        while (checkAccessToken(accessToken)) {
            accessToken = StringUtils.getRandomString(RANDOM_STRING_LENGTH);
        }

        SDKUserBean user = getAccessCode(accessCode);
        user.updateUser(accessToken, userInfo);
        accessTokenMng.put(accessToken, user);
        eraseAccessCode(accessCode);

        return accessToken;

    }

    public SDKUserBean getUserInfo(String accessToken) {
        return accessTokenMng.get(accessToken);
    }

    public void updateUserInfo(String accessToken) {
        SDKUserBean userBean = accessTokenMng.get(accessToken);
        userBean.updateTime();
        userBean.updateTimer();
    }

    public boolean checkAccessToken(String accessToken) {

        boolean ret = accessTokenMng.containsKey(accessToken);

        if (ret) {
            SDKUserBean userId = getUserInfo(accessToken);
            if (null == userId) {
                eraseAccessToken(accessToken);
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public void eraseAccessToken(String accessToken) {
        accessTokenMng.get(accessToken).cancelTask();
        accessTokenMng.remove(accessToken);
    }

    public void removeAccessToken(String accessToken) {
        accessTokenMng.remove(accessToken);
    }
}
