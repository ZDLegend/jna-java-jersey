package com.zdl.code.server;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by ZDLegend on 2016/8/16.
 * <p>
 * 关于返回给客户端响应信息操作的函数写在这里
 */
public class ResponseInfoMng {

    private static JSONObject errCode;

    private static final String ERROR_CODE = "errcode";
    private static final String ERROR_MSG = "errmsg";

    static {
        String url = ResponseInfoMng.class.getResource("../../error.json").getPath();
        String path = StringUtils.spaceString(url);
        errCode = FileManager.file2Json(path);
    }

    private ResponseInfoMng() {

    }

    /**
     * 根据错误编码获取错误信息
     */
    public static String getErrmsg(int ret) {

        String msg;
        try {
            msg = errCode.getString(Integer.toString(ret));
        } catch (JSONException e) {
            return "errCode.cfg中没有该错误信息";
        }

        return msg;
    }

    /**
     * 错误响应信息
     */
    public static JSONObject errorRsp(int ret, String msg) {

        JSONObject resp = getRsp();
        String errmsg = getErrmsg(ret);
        errmsg = msg + ":" + errmsg;

        resp.put(ERROR_CODE, ret);
        resp.put(ERROR_MSG, errmsg);
        return resp;
    }

    /**
     * 正确响应信息
     */
    public static JSONObject correctRsp() {
        JSONObject resp = getRsp();
        resp.put(ERROR_CODE, 0);
        resp.put(ERROR_MSG, "OK");
        return resp;
    }

    /**
     * 带有结果数据的响应信息
     */
    public static JSONObject correctRsp(Object msg) {
        JSONObject resp = getRsp();
        resp.put(ERROR_CODE, 0);
        resp.put(ERROR_MSG, "OK");
        resp.put("result", msg);
        return resp;
    }

    private static JSONObject getRsp() {
        return new JSONObject();
    }

}
