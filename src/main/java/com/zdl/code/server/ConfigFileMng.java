package com.zdl.code.server;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by ZDLegend on 2016/8/30.
 */
public class ConfigFileMng {

    private static String ServerIp;

    private static String imagePath;

    private static String password;

    private static ConfigFileMng instance = new ConfigFileMng();

    private ConfigFileMng() {

        String url = this.getClass().getResource("../../sdk.json").getPath();
        String path = StringUtils.spaceString(url);
        JSONObject cfg = FileManager.file2Json(path);

        ServerIp = cfg.getString("ServerIP");
        password = cfg.getString("ConnectCode");
    }

    public static ConfigFileMng getInstance() {
        return instance;
    }

    public static String getServerIp() {
        return ServerIp;
    }

    public static void setServerIp(String serverIp) {
        ServerIp = serverIp;
    }

    public static String getImagePath() {
        return imagePath;
    }

    public static void setImagePath(String imagePath) {
        ConfigFileMng.imagePath = imagePath;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConfigFileMng.password = password;
    }

    public String toString() {
        return "\nServerIP:" + ServerIp + "\nImagePath:" + imagePath;
    }
}
