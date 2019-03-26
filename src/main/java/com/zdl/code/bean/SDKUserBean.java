package com.zdl.code.bean;

import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.StringUtils;
import com.zdl.code.server.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * SDK用户生命周期封装
 * <p>
 * Created by ZDLegend on 2016/7/25.
 * <p>
 * 每次登录成功后，使用该类生成一个Access-Token控制块，保
 * 留时间暂定48小时，如果期间该用户ID被调用，保留时间更新
 * 为48小时，超过时间清除控制块Access-Token 的使用
 * <p>
 * Access-Code 在用户第二次调用登陆接口成功后删除，若用户
 * 没有使用该ID调用登陆接口或第二次调用失败，该ID保留5分钟
 */
public class SDKUserBean {

    private static Logger logger = LoggerFactory.getLogger(SDKUserBean.class);

    /**
     * 用户建立时间
     */
    private Date buildtime = new Date();

    /**
     * 用户更新时间
     */
    private Date updateime = new Date();

    /**
     * 用户对应的编码ID，用户调用restful接口的唯一标识符
     */
    private String uuid;

    /**
     * 用户信息结构体，包含了用户名，用户编码等
     */
    private SDKStructure.USER_INFO_S UserInfo = new SDKStructure.USER_INFO_S();

    /**
     * 用户登录信息结构体，调用每个C库接口的时候使用
     */
    private SDKStructure.USER_LOGIN_ID_INFO_S UserLoginIDInfo = new SDKStructure.USER_LOGIN_ID_INFO_S();

    /**
     * 用户编码类型（token和code）
     */
    private String type;

    /**
     * 用户计时器任务
     */
    private TimerTask timerTask;

    /**
     * 用户全局计时器
     */
    private static Timer timer = new Timer();

    /**
     * 每使用一次该用户ID，刷新一次用户更新时间
     */
    public void updateTime() {
        updateime = new Date();
    }

    /**
     * 根据用户ID类型初始化TimerTask
     */
    public void initTimer() {

        switch (type) {
            case "token":

                /** acess_token 48小时未使用则删除 */
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        logger.info("access_token:" + uuid + "超时删除");
                        UserManager.getInstance().removeAccessToken(getUuid());
                    }
                };
                timer.schedule(timerTask, UserManager.MAX_TIME_TOKEN_KEEP);
                break;
            case "code":

                /** acess_code 5分钟没有被第二次登陆接口调用则删除 */
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        logger.info("access_code:" + uuid + "超时删除");
                        UserManager.getInstance().removeAccessCode(getUuid());
                    }
                };
                timer.schedule(timerTask, UserManager.MAX_TIME_CODE_KEEP);
                break;
            default:
                logger.error("非法的用户类型");
                break;
        }
    }

    /**
     * 用户token ID 每被使用一次，就对该ID重新开始计时
     */
    public void updateTimer() {
        timerTask.cancel();
        initTimer();
    }

    /**
     * 第二次调用登陆接口验证access_code成功时，升级用户为token类型
     */
    public void updateUser(String access_token, SDKStructure.USER_INFO_S userInfo) {
        setType("token");
        setUserInfo(userInfo);
        setUserLoginIDInfo();
        setUuid(access_token);
        updateTime();
        cancelTask();
        initTimer();
    }

    /**
     * 关闭该计时任务
     */
    public void cancelTask() {
        timerTask.cancel();
    }

    /**
     * 建立一个新的带有计时功能的用户
     *
     * @param type code（用户第一次调用登陆接口时返回ID类型）
     *             token（用户第二次调用登陆接口返回ID类型）
     * @param uuid 用户调用登陆接口时返回的的ID
     */
    public SDKUserBean(String type, String uuid) {

        if (!type.equals("token") && !type.equals("code")) {
            logger.error("非法的用户类型");
            return;
        }

        this.type = type;
        this.uuid = uuid;
        initTimer();
    }

    /**
     * 建立一个新的不带有计时功能的用户
     */
    public SDKUserBean() {

    }

    public Date getBuildtime() {
        return buildtime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        if (!type.equals("token") && !type.equals("code")) {
            logger.error("非法的用户类型");
            return;
        }

        this.type = type;
    }

    public SDKStructure.USER_INFO_S getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(SDKStructure.USER_INFO_S userInfo) {

        this.UserInfo = userInfo;
    }

    public SDKStructure.USER_LOGIN_ID_INFO_S getUserLoginIDInfo() {
        return UserLoginIDInfo;
    }

    public void setUserLoginIDInfo() {

        StringUtils.ArrayCopy(this.UserLoginIDInfo.szUserCode, UserInfo.szUserCode);
        StringUtils.setSdkBytes(this.UserLoginIDInfo.szUserLoginCode, "IMOS_INSIDE_V5_INNER");
    }

    public String toString() {
        String usercode = StringUtils.bytesToString(this.UserLoginIDInfo.szUserCode);
        return "usercode = " + usercode + ", buildtime = " + buildtime + ", updateime = "
                + updateime + ", access_" + type + " = " + uuid;
    }
}
