package com.zdl.code.controller;

import com.zdl.code.server.ResponseInfoMng;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Created by z02464 on 2016/7/28.
 */

@Path("/gethello")
public class HellowResource {

    public static Logger logger = Logger.getLogger(HellowResource.class.getName());

    @GET
    @Produces("application/json;charset=UTF-8")
    public JSONObject getHello() {
        return ResponseInfoMng.errorRsp(380, "REST已开启");
    }

    @PUT
    @Produces("application/json;charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject R(JSONObject object) {

        System.out.println("POST:" + object);

        return object;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public JSONObject Test(@Context HttpHeaders headers, JSONObject resq) {
        System.out.println("POST:" + resq);
        return resq;
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    public JSONObject Delete(@Context HttpHeaders headers, JSONObject resq) {
        System.out.println("DELETE:" + resq);
        return resq;
    }
}
