package com.zdl.code.controller;

import com.zdl.code.dao.StatementDao;
import com.zdl.code.jna.ComStructure;
import com.zdl.code.jna.SDKConst;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.service.CommonService;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * Created by z02464 on 2016/12/13.
 * <p>
 * Statement 资源增删查
 */

@Path("statement")
@Produces("application/json;charset=UTF-8")
public class StatementResource {

    @POST
    public JSONObject add(JSONObject data, @Context HttpHeaders headers) {
        return CommonService.addRes(new StatementDao(), data, headers, new ComStructure.STATEMENT_INFO());
    }

    @DELETE
    @Path("{id}")
    public JSONObject delete(@PathParam("id") String id, @Context HttpHeaders headers) {
        return CommonService.delete(new StatementDao(), id, headers);
    }

    @GET
    public JSONObject query(@QueryParam("condition") String cond,
                            @Context HttpHeaders headers) {
        return CommonService.query(new StatementDao(), cond,
                headers, new SDKStructure.STATEMENT_DISPOSITION_INFO_S(), SDKConst.QUERY_CON_TYPE.COM_CON);
    }
}
