package com.zdl.code.bean;

/**
 * SDK初始化bean
 * <p>
 * Created by ZDLegend on 2016/7/9.
 */
public class SDKInitBean {
    /**
     * 服务器地址
     */
    private String ServerIP;

    /**
     * 服务器端口
     */
    private int ServerPort;

    /**
     * 用户密码
     */
    private String Password;

    /**
     * 本地IP
     */
    private static final String szClientIp = "N/A";


    public String getServerIP() {
        return ServerIP;
    }

    public void setServerIP(String szServerAdd) {
        this.ServerIP = szServerAdd;
    }

    public int getServerPort() {
        return ServerPort;
    }

    public void setServerPort(int ulServerPort) {
        this.ServerPort = ulServerPort;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public SDKInitBean(String IP, int Port, String password) {
        ServerIP = IP;
        ServerPort = Port;
        Password = password;
    }
}
