package com.zdl.code.service;

import com.sun.jna.Structure;
import com.zdl.code.api.*;
import com.zdl.code.exception.StructException;
import com.zdl.code.jna.SDKConst;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.jna.SPStructure;
import com.zdl.code.server.QueryConditionMng;
import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.StructUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.ws.rs.core.HttpHeaders;
import java.util.function.BiFunction;

import static com.zdl.code.jna.SDKErrorCode.ERR_COMMON_SUCCEED;
import static com.zdl.code.jna.SDKErrorCode.ERR_JSON_TO_STRUCT;

/**
 * Created by ZDLegend on 2016/11/25.
 * <p>
 * 通用资源统一入口
 * （主要负责统一的鉴权，入参数据的检查、处理及查询条件的检查、转换等工作）
 */
public final class CommonService {

    private static Logger logger = Logger.getLogger(CommonService.class.getName());

    private CommonService() {
        //to do nothing
    }

    public static <IN extends Structure, OUT extends Structure> JSONObject common(CommonAPI<IN, OUT> sdkApi, JSONObject data, HttpHeaders headers, IN info) {
        int ret = executeSdk(sdkApi::execute, data, headers, info);
        if (ERR_COMMON_SUCCEED != ret) {
            logger.error("修改失败，" + ResponseInfoMng.getErrmsg(ret) + "！返回错误码：" + ret);
            return ResponseInfoMng.errorRsp(ret, "修改失败");
        }
        return ResponseInfoMng.correctRsp(StructUtils.Struct2Json(sdkApi.getOut()));
    }

    /**
     * 添加资源
     */
    public static <R extends Structure> JSONObject addRes(CreateAPI<R> cAPI, JSONObject data, HttpHeaders headers, R info) {
        return up(cAPI::create, data, headers, info);
    }

    /**
     * 修改资源
     */
    public static <R extends Structure> JSONObject modify(UpdateAPI<R> uAPI, JSONObject data, HttpHeaders headers, R info) {
        return up(uAPI::update, data, headers, info);
    }

    private static <R extends Structure> JSONObject up(BiFunction<HttpHeaders, R, Integer> sdkApi, JSONObject data, HttpHeaders headers, R info) {
        int ret = executeSdk(sdkApi, data, headers, info);
        if (ERR_COMMON_SUCCEED != ret) {
            logger.error("修改失败，" + ResponseInfoMng.getErrmsg(ret) + "！返回错误码：" + ret);
            return ResponseInfoMng.errorRsp(ret, "修改失败");
        }
        return ResponseInfoMng.correctRsp(StructUtils.Struct2Json(info));
    }

    private static <R extends Structure> int executeSdk(BiFunction<HttpHeaders, R, Integer> sdkApi, JSONObject data, HttpHeaders headers, R info) {

        try {
            StructUtils.Json2Struct(data, info);
        } catch (StructException e) {
            return ERR_JSON_TO_STRUCT;
        }

        return sdkApi.apply(headers, info);
    }

    /**
     * 按条件查询资源列表
     */
    public static <R extends Structure> JSONObject query(QueryAPI<R> qAPI, String con, HttpHeaders headers, R r, SDKConst.QUERY_CON_TYPE type) {

        String name = r.getClass().getName();
        logger.info("接口：" + name + "调用查询，查询条件为" + con);

        Structure Condition;
        switch (type) {
            case COM_CON:
                Condition = new SDKStructure.COMMON_QUERY_CONDITION_S();
                break;
            case ZDL_CON:
                Condition = new SPStructure.SPS_COMMON_QUERY_CONDITION_S();
                break;
            default:
                return ResponseInfoMng.errorRsp(1, "无效的查询条件类型");
        }

        SDKStructure.QUERY_PAGE_INFO_S pstQueryPageInfo = new SDKStructure.QUERY_PAGE_INFO_S();
        SDKStructure.RSP_PAGE_INFO_S pstRspPageInfo = new SDKStructure.RSP_PAGE_INFO_S();

        /* 解析JSON中的查询条件 */
        int ret = QueryConditionMng.buildCondition(Condition, pstQueryPageInfo, con, type);
        if (ERR_COMMON_SUCCEED != ret) {
            logger.error(name + ":查询条件错误!");
            return ResponseInfoMng.errorRsp(ret, "查询条件错误：详情请查看服务端日志信息");
        }

        R[] Results = (R[]) r.toArray(pstQueryPageInfo.ulPageRowNum);

        /* 调用C库函数开始查询 */
        ret = qAPI.query(headers, Condition, pstQueryPageInfo, pstRspPageInfo, Results);
        if (ERR_COMMON_SUCCEED != ret) {
            logger.error(name + ":查询信息列表失败，" + ResponseInfoMng.getErrmsg(ret) + "！返回错误码：" + ret);
            return ResponseInfoMng.errorRsp(ret, "查询信息列表失败");
        }

        /* 将查询结果转换成JSON数据返回给客户端 */
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < pstRspPageInfo.ulRowNum; i++) {
            JSONObject resp = StructUtils.Struct2Json(Results[i]);
            jsonArray.add(i, resp);
        }

        JSONObject RspPageInfo = new JSONObject();
        RspPageInfo.put("RowNum", pstRspPageInfo.ulRowNum);
        RspPageInfo.put("TotalRowNum", pstRspPageInfo.ulTotalRowNum);

        JSONObject object = new JSONObject();
        object.put("RspPageInfo", RspPageInfo);
        object.put("InfoList", jsonArray);

        return ResponseInfoMng.correctRsp(object);
    }

    /**
     * 按ID删除资源
     */
    public static JSONObject delete(DeleteAPI dAPI, String code, HttpHeaders headers) {

        String name = dAPI.getClass().getName();

        if (null == code || code.isEmpty()) {
            logger.error(name + ":无效入参");
            return ResponseInfoMng.errorRsp(1, "无效入参");
        }

        int ret = dAPI.delete(headers, code);
        if (ERR_COMMON_SUCCEED != ret) {
            logger.error(name + ":手动删除信息失败，" + ResponseInfoMng.getErrmsg(ret) + "！返回错误码：" + ret);
            return ResponseInfoMng.errorRsp(ret, "手动删除信息失败");
        }

        return ResponseInfoMng.correctRsp();
    }
}
