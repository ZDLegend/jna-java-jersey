package com.zdl.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdl.code.call.CallAlarm;
import com.zdl.code.call.CallBackProcPF;
import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.SDKHandler;
import org.apache.log4j.Logger;
import org.springframework.data.util.Pair;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.zdl.code.jna.SDKConst.*;
import static com.zdl.code.jna.SDKErrorCode.ERR_JSON_LACK_FIELD;

/**
 * Created by ZDLegend on 2016/12/21.
 * <p>
 * 订阅告警
 */

@Path("/alarm")
public class SubAlarmResource {

    private static Logger logger = Logger.getLogger(SubAlarmResource.class);

    private static CallBackProcPF ins = CallBackProcPF.getInstance();
    private static CallAlarm fins = CallAlarm.getInstance();

    private static final Map<Integer, Pair<BiConsumer<String, String>, Consumer<String>>> callMethodMap = new HashMap<>();

    static {
        callMethodMap.put(COM_ALARM, Pair.of((user, data) -> ins.openAlarm(user, data), user -> ins.closeAlarm(user)));
        callMethodMap.put(FACE_GUARD, Pair.of((user, data) -> fins.openFaceAlarm(user, data), user -> fins.closeFaceAlarm(user)));
        callMethodMap.put(FACE_SNAP, Pair.of((user, data) -> fins.openNapAlarm(user, data), user -> fins.closeNapAlarm(user)));
    }

    @POST
    @Path("/open")
    @Produces("application/json")
    public JSONObject open(@Context HttpHeaders headers, JSONObject data) {

        String username = SDKHandler.getUsername(headers);

        if (data.containsKey("data")) {

            /* 订阅指定的告警，type不填则默认订阅所有告警 */
            if (data.containsKey("type")) {
                int type = data.getInteger("type");
                if (callMethodMap.containsKey(type)) {
                    callMethodMap.get(type).getFirst().accept(username, data.getString("data"));
                } else {
                    logger.error("订阅告警类型错误:" + type);
                    return ResponseInfoMng.errorRsp(50012, "订阅告警失败");
                }
            } else {
                logger.info("JSON中没有type，默认订阅所有告警");
                callMethodMap.forEach((i, bi) -> bi.getFirst().accept(username, data.getString("data")));
            }

            return ResponseInfoMng.correctRsp();
        } else {
            logger.error("缺少data字段");
        }
        return ResponseInfoMng.errorRsp(ERR_JSON_LACK_FIELD, "订阅告警失败");
    }

    /**
     * 关闭该用户订阅的所有告警
     */
    @DELETE
    @Path("/close")
    @Produces("application/json")
    public JSONObject closeAll(@Context HttpHeaders headers) {
        callMethodMap.forEach((i, bi) -> bi.getSecond().accept(SDKHandler.getUsername(headers)));
        return ResponseInfoMng.correctRsp();
    }

    @DELETE
    @Path("/close/{type}")
    @Produces("application/json")
    public JSONObject close(@PathParam("type") int type, @Context HttpHeaders headers) {

        String username = SDKHandler.getUsername(headers);

        if (callMethodMap.containsKey(type)) {
            callMethodMap.get(type).getSecond().accept(username);
        } else {
            logger.error("订阅告警类型错误:" + type);
            return ResponseInfoMng.errorRsp(50012, "订阅告警失败");
        }

        return ResponseInfoMng.correctRsp();
    }
}
