package com.zdl.code.controller;

import com.zdl.code.call.CallAlarm;
import com.zdl.code.call.CallBackProcPF;
import com.zdl.code.server.ResponseInfoMng;
import com.zdl.code.server.SDKHandler;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

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

    @POST
    @Path("/open")
    @Produces("application/json")
    public JSONObject open(@Context HttpHeaders headers, JSONObject data) {

        String username = SDKHandler.getUsername(headers);

        if (data.containsKey("data")) {

            /* 订阅指定的告警，type不填则默认订阅所有告警 */
            if (data.containsKey("type")) {
                int type = data.getInt("type");
                switch (type) {
                    case COM_ALARM:
                        ins.openAlarm(username, data.getString("data"));
                        break;
                    case FACE_GUARD:
                        fins.openFaceAlarm(username, data.getString("data"));
                        break;
                    case FACE_SNAP:
                        fins.openNapAlarm(username, data.getString("data"));
                        break;
                    default:
                        logger.error("订阅告警类型错误");
                        return ResponseInfoMng.errorRsp(50012, "订阅告警失败");
                }
            } else {
                logger.info("JSON中没有type，默认订阅所有告警");
                ins.openAlarm(username, data.getString("data"));
                fins.openFaceAlarm(username, data.getString("data"));
                fins.openNapAlarm(username, data.getString("data"));
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

        String username = SDKHandler.getUsername(headers);

        if (ins.isOpenAlarm()) ins.closeAlarm(username);
        if (fins.isOpenFaceAlarm()) fins.closeFaceAlarm(username);
        if (fins.isOpenNapAlarm()) fins.closeNapAlarm(username);

        return ResponseInfoMng.correctRsp();
    }

    @DELETE
    @Path("/close/{type}")
    @Produces("application/json")
    public JSONObject close(@PathParam("type") int type, @Context HttpHeaders headers) {

        String username = SDKHandler.getUsername(headers);

        switch (type) {
            case COM_ALARM:
                if (!ins.isOpenAlarm()) return ResponseInfoMng.errorRsp(1, "未订阅任何通用告警");
                ins.closeAlarm(username);
                break;
            case FACE_GUARD:
                if (!fins.isOpenFaceAlarm()) return ResponseInfoMng.errorRsp(1, "未订阅任何人脸告警");
                fins.closeFaceAlarm(username);
                break;
            case FACE_SNAP:
                if (!fins.isOpenNapAlarm()) return ResponseInfoMng.errorRsp(1, "未订阅任何人脸告警");
                fins.closeNapAlarm(username);
                break;
            default:
                logger.error("订阅告警类型错误");
                return ResponseInfoMng.errorRsp(50012, "订阅告警失败");
        }

        return ResponseInfoMng.correctRsp();
    }
}
