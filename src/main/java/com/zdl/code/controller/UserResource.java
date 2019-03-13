package com.zdl.code.controller;

import com.zdl.code.dao.RoleDao;
import com.zdl.code.dao.UserDao;
import com.zdl.code.jna.ComStructure;
import com.zdl.code.jna.SDKStructure;
import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.SDKHandler;
import com.zdl.code.service.CommonService;
import net.sf.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import static com.zdl.code.jna.SDKErrorCode.ERR_COMMON_SUCCEED;

/**
 * Created by z02464 on 2016/11/24.
 * <p>
 * SDK用户管理
 */
@Path("/user")
@Produces("application/json;charset=UTF-8")
public class UserResource {

    @POST
    public JSONObject add(JSONObject data, @Context HttpHeaders headers) {

        if (!data.containsKey("UserInfo") || !data.containsKey("Role")) {
            return ResponseInfoMng.errorRsp(50002, "新增用户失败");
        }

        JSONObject _data = data.getJSONObject("UserInfo");
        boolean bRole = data.getBoolean("Role");

        JSONObject object = CommonService.addRes(new UserDao(), _data, headers, new ComStructure.USER_INFO());
        if (object.getInt("errcode") != 0 || !bRole) {
            return object;
        }

        return SDKHandler.setUserRole(headers, _data);
    }

    @PUT
    public JSONObject update(JSONObject data, @Context HttpHeaders headers) {
        return CommonService.modify(new UserDao(), data, headers, new SDKStructure.USER_MODIFY_PASSWORD_S());
    }

    @DELETE
    @Path("{id}")
    public JSONObject delete(@PathParam("id") String id, @Context HttpHeaders headers) {
        return CommonService.delete(new UserDao(), id, headers);
    }

    @POST
    @Path("role")
    public JSONObject addRole(JSONObject data, @Context HttpHeaders headers) {

        if (!data.containsKey("RoleCode") || !data.containsKey("RoleCount")) {
            return ResponseInfoMng.errorRsp(50002, "添加角色失败");
        }

        RoleDao rb = new RoleDao();
        int ret = rb.init(data.getJSONArray("RoleCode"), data.getInt("RoleCount"));
        if (ret != ERR_COMMON_SUCCEED) return ResponseInfoMng.errorRsp(ret, "设置用户权限啊失败");

        return CommonService.addRes(rb, data, headers, new ComStructure.ROLE_INFO());
    }
}
