package com.zdl.code.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.Structure;
import com.zdl.code.jna.SDKConst;
import com.zdl.code.jna.SDKErrorCode;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.jna.SPStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZDLegend on 2016/8/27.
 * <p>
 * 解析JSON格式的查询条件字符串
 */
public final class QueryConditionMng {

    private static Logger logger = LoggerFactory.getLogger(QueryConditionMng.class);

    private QueryConditionMng() {
    }

    private static void createSPSQueryItem(String queryColumn, int logicFlag, String queryData, SPStructure.SPS_QUERY_CONDITION_ITEM_S c) {
        c.ulLogicFlag = logicFlag;
        StringUtils.setSdkBytes(c.szQueryColumn, queryColumn);
        StringUtils.setSdkBytes(c.szQueryData, queryData);
    }

    private static void createSDKQueryItem(int queryType, int logicFlag, String queryData, SDKStructure.QUERY_CONDITION_ITEM_S c) {
        c.ulQueryType = queryType;
        c.ulLogicFlag = logicFlag;
        StringUtils.setSdkBytes(c.szQueryData, queryData);

    }

    public static int buildCondition(Structure queryCondition,
                                     SDKStructure.QUERY_PAGE_INFO_S pstQueryPageInfo,
                                     String cond,
                                     SDKConst.QUERY_CON_TYPE type) {

        /* 验证JSON字符串入参并建立建立JSON格式数据 */
        if (null == pstQueryPageInfo) {
            logger.error("无效入参");
            return SDKErrorCode.ERR_INVALID_INPUT;
        }

        /* 如果查询条件字符串为空，则配置默认数据 */
        if (null == cond || cond.isEmpty()) {
            pstQueryPageInfo.bQueryCount = 0;
            pstQueryPageInfo.ulPageFirstRowNumber = 0;
            pstQueryPageInfo.ulPageRowNum = 10;
            return SDKErrorCode.ERR_COMMON_SUCCEED;
        }
        JSONObject rep = JSONObject.parseObject(cond);

        JSONArray condition;

        if (!rep.containsKey("PageRowNum") || !rep.containsKey("QueryCount") || !rep.containsKey("PageFirstRowNumber")) {
            return SDKErrorCode.ERR_JSON_LACK_FIELD;
        }

        int pageRowNum = rep.getInteger("PageRowNum");
        if (pageRowNum < 0 || pageRowNum > SDKConst.ZDL_PAGE_QUERY_ROW_MAX_NUM) {
            logger.error("分页查询中每页的最大条目数不能超过{}", SDKConst.ZDL_PAGE_QUERY_ROW_MAX_NUM);
            return SDKErrorCode.ERR_QUERY_MAX_NUM;
        }

        if (rep.containsKey("ItemNum") && rep.containsKey("condition")) {
            if (null == queryCondition) {
                logger.error("无效入参");
                return SDKErrorCode.ERR_INVALID_INPUT;
            }

            int itemNum = rep.getInteger("ItemNum");
            if (itemNum < 0 || itemNum > SDKConst.ZDL_QUERY_ITEM_MAX_NUM) {
                logger.error("查询条件最大条目数不能超过{}", SDKConst.ZDL_PAGE_QUERY_ROW_MAX_NUM);
                return SDKErrorCode.ERR_QUERY_MAX_NUM;
            }

            condition = rep.getJSONArray("condition");
            int condLen = condition.size();

            switch (type) {

                case COM_CON:
                    SDKStructure.COMMON_QUERY_CONDITION_S pstQueryCondition = (SDKStructure.COMMON_QUERY_CONDITION_S) queryCondition;
                    pstQueryCondition.ulItemNum = itemNum;
                    if (itemNum > condLen) {
                        return 50010;
                    }

                    for (int i = 0; i < itemNum; i++) {
                        JSONObject con = condition.getJSONObject(i);
                        if (null == con.get("QueryData")) {
                            continue;
                        }

                        createSDKQueryItem(con.getInteger("QueryType"),
                                con.getInteger("LogicFlag"),
                                con.getString("QueryData"),
                                pstQueryCondition.astQueryConditionList[i]);
                    }
                    break;
                case ZDL_CON:
                    SPStructure.SPS_COMMON_QUERY_CONDITION_S pstSPSQueryCondition = (SPStructure.SPS_COMMON_QUERY_CONDITION_S) queryCondition;
                    pstSPSQueryCondition.ulItemNum = itemNum;
                    if (itemNum > condLen) {
                        return 50010;
                    }

                    for (int i = 0; i < itemNum; i++) {
                        JSONObject con = condition.getJSONObject(i);
                        if (null == con.get("QueryData")) {
                            continue;
                        }

                        createSPSQueryItem(con.getString("QueryColumn"),
                                con.getInteger("LogicFlag"),
                                con.getString("QueryData"),
                                pstSPSQueryCondition.astQueryConditionList[i]);
                    }
                    break;
                default:
                    logger.error("错误的查询类型");
            }
        }

        pstQueryPageInfo.bQueryCount = rep.getInteger("QueryCount");
        pstQueryPageInfo.ulPageFirstRowNumber = rep.getInteger("PageFirstRowNumber");
        pstQueryPageInfo.ulPageRowNum = pageRowNum;

        return SDKErrorCode.ERR_COMMON_SUCCEED;
    }
}
