package com.zdl.code.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * 根据需要自己二次封装的结构体
 * <p>
 * Created by ZDLegend on 2016/12/13.
 */
public interface ComStructure {

    class ROLE_INFO extends Structure {

        public byte[] szUserCode = new byte[SDKConst.ZDL_USER_CODE_LEN];
        public byte[] aszRoleCode = new byte[SDKConst.ZDL_MAX_USER_ROLES_NUM * SDKConst.ZDL_RES_CODE_LEN];
        public int ulRoleCount;

        public ROLE_INFO() {
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szUserCode", "aszRoleCode", "ulRoleCount");
        }

    }

    class USER_INFO extends Structure {

        public byte[] szOrgCode = new byte[SDKConst.ZDL_DOMAIN_CODE_LEN];
        public SDKStructure.USER_INFO_PASSWORD_S pstUserPasswordInfo = new SDKStructure.USER_INFO_PASSWORD_S();

        public USER_INFO() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szOrgCode", "pstUserPasswordInfo");
        }
    }

    class STATEMENT_INFO extends Structure {

        public SDKStructure.STATEMENT_DISPOSITION_INFO_S pstDispositionInfo =
                new SDKStructure.STATEMENT_DISPOSITION_INFO_S();
        public SDKStructure.MAP_AREA_DISPOSE_RES_INFO_S pstMapAreaDisposeResInfo =
                new SDKStructure.MAP_AREA_DISPOSE_RES_INFO_S();

        public STATEMENT_INFO() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("pstDispositionInfo", "pstMapAreaDisposeResInfo", "pstDisposePlanInfo");
        }
    }


    /**
     * @struct tagEventRecord
     * @brief 告警记录信息(增强版)
     * @attention
     */
    class EVENT_RECORD_FILT extends Structure {
        /**
         * 告警类型, 取值为#AlARM_TYPE_E
         */
        public int ulEventType;

        /**
         * 设备编码
         */
        public byte[] szDeviceCode = new byte[SDKConst.ZDL_DEVICE_CODE_LEN];

        /**
         * 设备名称
         */
        public byte[] szDeviceName = new byte[SDKConst.ZDL_NAME_LEN];

        /**
         * 父设备名称
         */
        public byte[] szParentDevName = new byte[SDKConst.ZDL_NAME_LEN];

        /**
         * 告警名称
         */
        public byte[] szActiveName = new byte[SDKConst.ZDL_NAME_LEN];

        /**
         * 告警级别, 取值为#ALARM_SEVERITY_LEVEL_E
         */
        public int ulEventSecurity;

        /**
         * 告警触发时间
         */
        public byte[] szEventTime = new byte[SDKConst.ZDL_TIME_LEN];

        /**
         * 告警状态, 取值为#ALARM_STATUS_E
         */
        public int ulAlarmStatus;

        /**
         * 事件级别名称
         */
        public byte[] szSecurityName = new byte[SDKConst.ZDL_NAME_LEN];

        /**
         * 事件级别显示颜色
         */
        public byte[] szSecurityColor = new byte[SDKConst.ZDL_STRING_LEN_14];

        /**
         * 告警确认时间
         */
        public byte[] szAckTime = new byte[SDKConst.ZDL_TIME_LEN];

        /**
         * 告警确认用户
         */
        public byte[] szAckUser = new byte[SDKConst.ZDL_NAME_LEN];

        /**
         * 参数名值对
         */
        public byte[] szKeyValue = new byte[SDKConst.ZDL_STRING_LEN_128];

        /**
         * 告警描述信息
         */
        public byte[] szEventDesc = new byte[SDKConst.ZDL_DESC_LEN];

        /**
         * 告警确认描述
         */
        public byte[] szAckSuggestion = new byte[SDKConst.ZDL_DESC_LEN];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulEventType", "szDeviceCode", "szDeviceName", "szParentDevName",
                    "szActiveName", "ulEventSecurity", "szEventTime", "ulAlarmStatus", "szSecurityName",
                    "szSecurityColor", "szAckTime", "szAckUser", "szKeyValue", "szEventDesc", "szAckSuggestion");
        }
    }
}
