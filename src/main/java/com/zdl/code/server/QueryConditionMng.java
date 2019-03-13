package com.zdl.code.server;

import com.sun.jna.Structure;
import com.zdl.code.jna.SDKConst;
import com.zdl.code.jna.SDKErrorCode;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.jna.SPStructure;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * Created by ZDLegend on 2016/8/27.
 * <p>
 * 解析JSON格式的查询条件字符串
 */
public class QueryConditionMng {

    private static Logger logger = Logger.getLogger(QueryConditionMng.class.getName());

    public static void createSPSQueryItem(String QueryColumn, int LogicFlag, String QueryData, SPStructure.SPS_QUERY_CONDITION_ITEM_S c) {
        c.ulLogicFlag = LogicFlag;
        StringUtils.setSdkBytes(c.szQueryColumn, QueryColumn);
        StringUtils.setSdkBytes(c.szQueryData, QueryData);
    }

    public static void createSDKQueryItem(int QueryType, int LogicFlag, String QueryData, SDKStructure.QUERY_CONDITION_ITEM_S c) {
        c.ulQueryType = QueryType;
        c.ulLogicFlag = LogicFlag;
        StringUtils.setSdkBytes(c.szQueryData, QueryData);

    }

    public static int buildCondition(Structure QueryCondition,
                                     SDKStructure.QUERY_PAGE_INFO_S pstQueryPageInfo, String cond, SDKConst.QUERY_CON_TYPE type) {

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
        JSONObject rep = JSONObject.fromObject(cond);

        JSONArray condition;

        if (!rep.containsKey("PageRowNum") || !rep.containsKey("QueryCount") || !rep.containsKey("PageFirstRowNumber")) {
            return SDKErrorCode.ERR_JSON_LACK_FIELD;
        }

        int PageRowNum = rep.getInt("PageRowNum");
        if (PageRowNum < 0 || PageRowNum > SDKConst.ZDL_PAGE_QUERY_ROW_MAX_NUM) {
            logger.error("分页查询中每页的最大条目数不能超过" + SDKConst.ZDL_PAGE_QUERY_ROW_MAX_NUM);
            return SDKErrorCode.ERR_QUERY_MAX_NUM;
        }

        if (rep.containsKey("ItemNum") && rep.containsKey("condition")) {
            if (null == QueryCondition) {
                logger.error("无效入参");
                return SDKErrorCode.ERR_INVALID_INPUT;
            }

            int ItemNum = rep.getInt("ItemNum");
            if (ItemNum < 0 || ItemNum > SDKConst.ZDL_QUERY_ITEM_MAX_NUM) {
                logger.error("查询条件最大条目数不能超过" + SDKConst.ZDL_PAGE_QUERY_ROW_MAX_NUM);
                return SDKErrorCode.ERR_QUERY_MAX_NUM;
            }

            condition = rep.getJSONArray("condition");
            int condLen = condition.size();

            switch (type) {

                case COM_CON:
                    SDKStructure.COMMON_QUERY_CONDITION_S pstQueryCondition = (SDKStructure.COMMON_QUERY_CONDITION_S) QueryCondition;
                    pstQueryCondition.ulItemNum = ItemNum;
                    if (ItemNum > condLen) {
                        return 50010;
                    }

                    for (int i = 0; i < ItemNum; i++) {
                        JSONObject con = condition.getJSONObject(i);
                        if (null == con.get("QueryData")) {
                            continue;
                        }

                        createSDKQueryItem(con.getInt("QueryType"),
                                con.getInt("LogicFlag"),
                                con.getString("QueryData"),
                                pstQueryCondition.astQueryConditionList[i]);
                    }
                    break;
                case ZDL_CON:
                    SPStructure.SPS_COMMON_QUERY_CONDITION_S pstSPSQueryCondition = (SPStructure.SPS_COMMON_QUERY_CONDITION_S) QueryCondition;
                    pstSPSQueryCondition.ulItemNum = ItemNum;
                    if (ItemNum > condLen) {
                        return 50010;
                    }

                    for (int i = 0; i < ItemNum; i++) {
                        JSONObject con = condition.getJSONObject(i);
                        if (null == con.get("QueryData")) {
                            continue;
                        }

                        createSPSQueryItem(con.getString("QueryColumn"),
                                con.getInt("LogicFlag"),
                                con.getString("QueryData"),
                                pstSPSQueryCondition.astQueryConditionList[i]);
                    }
                    break;
                default:
                    logger.error("错误的查询类型");
            }
        }

        pstQueryPageInfo.bQueryCount = rep.getInt("QueryCount");
        pstQueryPageInfo.ulPageFirstRowNumber = rep.getInt("PageFirstRowNumber");
        pstQueryPageInfo.ulPageRowNum = PageRowNum;

        return SDKErrorCode.ERR_COMMON_SUCCEED;
    }
}
