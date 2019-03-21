package com.zdl.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdl.code.dao.RecordFileURLDao;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.service.CommonService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * 获取录像文件的URL信息
 * <p>
 * Created by ZDLegend on 2019/3/16.
 */
@Path("record-file-url")
@Produces("application/json;charset=UTF-8")
public class RecordFileURLResource {

    @POST
    public JSONObject getRecordFileURL(JSONObject data, @Context HttpHeaders headers) {
        return CommonService.common(new RecordFileURLDao(), data, headers, new SDKStructure.GET_URL_INFO_S());
    }
}
