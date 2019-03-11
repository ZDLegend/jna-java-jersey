package com.zdl.code.dao;

import com.sun.jna.Structure;
import com.zdl.code.api.CreateAPI;
import com.zdl.code.api.DeleteAPI;
import com.zdl.code.api.QueryAPI;
import com.zdl.code.jna.ComStructure;
import com.zdl.code.jna.SDKFunction;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.SDKHandler;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/12/13.
 */
public class StatementDao implements CreateAPI<ComStructure.STATEMENT_INFO>,
        QueryAPI<SDKStructure.STATEMENT_DISPOSITION_INFO_S>,
        DeleteAPI {

    private static SDKFunction SDK = SDKFunction.INSTANCE;

    @Override
    public int delete(HttpHeaders headers, String id) {
        return SDK.ZDL_DelStatementDisposition(SDKHandler.getUserLoginIDInfo(headers), id);
    }

    @Override
    public int create(HttpHeaders headers, ComStructure.STATEMENT_INFO data) {
        return SDK.ZDL_AddStatementDisposition(SDKHandler.getUserLoginIDInfo(headers),
                data.pstDispositionInfo,
                data.pstMapAreaDisposeResInfo
        );
    }

    @Override
    public int query(HttpHeaders headers,
                     Structure Condition,
                     SDKStructure.QUERY_PAGE_INFO_S QueryPageInfo,
                     SDKStructure.RSP_PAGE_INFO_S RspPageInfo,
                     SDKStructure.STATEMENT_DISPOSITION_INFO_S[] Info) {
        return SDK.ZDL_QueryStatementDispositionList(
                SDKHandler.getUserLoginIDInfo(headers),
                (SDKStructure.COMMON_QUERY_CONDITION_S) Condition,
                QueryPageInfo,
                RspPageInfo,
                Info);
    }
}
