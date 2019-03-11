package com.zdl.code.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

import static com.zdl.code.jna.SDKConst.*;

public interface SDKStructure {

    /**
     * @struct tagUserLoginIDInfo
     * @brief 用户登录ID信息结构
     * @attention
     */
    class USER_LOGIN_ID_INFO_S extends Structure {
        public byte[] szUserCode = new byte[SDKConst.ZDL_USER_CODE_LEN];
        public byte[] szUserLoginCode = new byte[ZDL_RES_CODE_LEN];
        public byte[] szUserIpAddress = new byte[SDKConst.ZDL_IPADDR_LEN];

        public USER_LOGIN_ID_INFO_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szUserCode", "szUserLoginCode", "szUserIpAddress");
        }
    }

    /**
     * @struct tagUserPasswordInfo
     * @brief 用户信息(包含用户登录密码)
     * @attention
     */
    class USER_INFO_PASSWORD_S extends Structure {
        public SDKStructure.USER_INFO_S stUserInfo = new SDKStructure.USER_INFO_S();
        public byte[] szPassword = new byte[SDKConst.ZDL_PASSWD_ENCRYPT_LEN];

        public USER_INFO_PASSWORD_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("stUserInfo", "szPassword");
        }
    }

    /**
     * @struct tagUserInfo
     * @brief 用户信息
     * @attention
     */
    class USER_INFO_S extends Structure {
        public byte[] szUserCode = new byte[SDKConst.ZDL_USER_CODE_LEN];
        public byte[] szUserName = new byte[SDKConst.ZDL_NAME_LEN];
        public byte[] szUserFullName = new byte[SDKConst.ZDL_NAME_LEN];
        public byte[] szOrgName = new byte[SDKConst.ZDL_NAME_LEN];
        public byte[] szTelePhone = new byte[SDKConst.ZDL_PHONE_LEN];
        public byte[] szMobilePhone = new byte[SDKConst.ZDL_MOBILE_LEN];
        public byte[] szFax = new byte[SDKConst.ZDL_PHONE_LEN];
        public byte[] szEmail = new byte[SDKConst.ZDL_MAIL_LEN];
        public int ulPasswdPermanetFlag;
        public byte[] szPasswdValidDate = new byte[ZDL_TIME_LEN];
        public int ulPasswdValidDays;
        public int ulPasswdValidFlag;
        public int ulUserLockFlag;
        public int ulUserType;
        public byte[] szUserDes = new byte[SDKConst.ZDL_DESC_LEN];
        public byte[] szReserve = new byte[96];

        public USER_INFO_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szUserCode", "szUserName", "szUserFullName", "szOrgName", "szTelePhone", "szMobilePhone",
                    "szFax", "szEmail", "ulPasswdPermanetFlag", "szPasswdValidDate", "ulPasswdValidDays",
                    "ulPasswdValidFlag", "ulUserLockFlag", "ulUserType", "szUserDes", "szReserve");
        }
    }

    /**
     * @struct tagCommonQueryCondition
     * @brief 通用查询条件
     * @attention
     */
    class COMMON_QUERY_CONDITION_S extends Structure {
        public int ulItemNum;
        public SDKStructure.QUERY_CONDITION_ITEM_S[] astQueryConditionList;

        public COMMON_QUERY_CONDITION_S() {
            astQueryConditionList = (SDKStructure.QUERY_CONDITION_ITEM_S[]) (new SDKStructure.QUERY_CONDITION_ITEM_S()).toArray(SDKConst.ZDL_QUERY_ITEM_MAX_NUM);
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulItemNum", "astQueryConditionList");
        }
    }

    /**
     * @struct tagQueryConditionItem
     * @brief 查询条件项
     * @attention
     */
    class QUERY_CONDITION_ITEM_S extends Structure {
        public int ulQueryType;
        public int ulLogicFlag;
        public byte[] szQueryData = new byte[SDKConst.ZDL_QUERY_DATA_MAX_LEN];

        public QUERY_CONDITION_ITEM_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulQueryType", "ulLogicFlag", "szQueryData");
        }
    }

    /**
     * @struct tagUserModifyPassword
     * @brief 用户密码信息
     * @attention
     */
    class USER_MODIFY_PASSWORD_S extends Structure {
        public byte[] szUserName = new byte[SDKConst.ZDL_NAME_LEN];
        public byte[] szOldPassword = new byte[SDKConst.ZDL_PASSWD_ENCRYPT_LEN];
        public byte[] szNewPassword = new byte[SDKConst.ZDL_PASSWD_ENCRYPT_LEN];

        public USER_MODIFY_PASSWORD_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szUserName", "szOldPassword", "szNewPassword");
        }
    }

    /**
     * @struct tagResInfo
     * @brief 资源信息
     * @attention 无
     */
    class RES_INFO_S extends Structure {
        public byte[] szResIdCode = new byte[SDKConst.ZDL_CODE_LEN];
        public byte[] szResCode = new byte[SDKConst.ZDL_CODE_LEN];
        public byte[] szResName = new byte[SDKConst.ZDL_NAME_LEN];
        public int ulResType;
        public int ulResSubType;
        public byte[] szOrgCode = new byte[SDKConst.ZDL_CODE_LEN];
        public byte[] szOrgName = new byte[SDKConst.ZDL_NAME_LEN];

        public RES_INFO_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szResIdCode", "szResCode", "szResName", "ulResType", "ulResSubType", "szOrgCode", "szOrgName");
        }
    }

    /**
     * @struct tagNestQueryCondition
     * @brief 嵌套查询条件
     * @attention
     */
    class NEST_QUERY_CONDITION_S extends Structure {
        public int ulQueryType;
        public int ulLogicFlag;
        public int ulQueryDataNum;
        public byte[] aszQueryDataList = new byte[SDKConst.ZDL_QUERY_ITEM_MAX_NUM2 * SDKConst.ZDL_QUERY_DATA_MAX_LEN];

        public NEST_QUERY_CONDITION_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulQueryType", "ulLogicFlag", "ulQueryDataNum", "aszQueryDataList");
        }
    }

    /**
     * @struct tagQueryPageInfo
     * @brief 分页请求信息
     * @brief 待查询数据的每条数据项对应一个序号。序号从1开始，连续增加。
     * - 查询到的结果以页的形式返回，每次查询只能返回一页。页包含的行数由ulPageRowNum设定，范围为1~200。
     * - 每次查询，可设置从待查询数据中特定序号（ulPageFirstRowNumber）开始
     * @attention
     */
    class QUERY_PAGE_INFO_S extends Structure {
        public int ulPageRowNum;
        public int ulPageFirstRowNumber;
        public int bQueryCount;

        public QUERY_PAGE_INFO_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulPageRowNum", "ulPageFirstRowNumber", "bQueryCount");
        }
    }

    /**
     * @struct tagRspPageInfo
     * @brief 分页响应信息
     * @attention
     */
    class RSP_PAGE_INFO_S extends Structure {
        public int ulRowNum;
        public int ulTotalRowNum;

        public RSP_PAGE_INFO_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulRowNum", "ulTotalRowNum");
        }
    }

    class MAP_AREA_DISPOSE_RES_INFO_S extends Structure {
        public int ulDisposeResNum;
        public SDKStructure.RES_INFO_S[] astDisposeResList;

        public MAP_AREA_DISPOSE_RES_INFO_S() {
            astDisposeResList = (SDKStructure.RES_INFO_S[]) (new SDKStructure.RES_INFO_S()).toArray(SDKConst.ZDL_MAP_AREA_DISPOSE_RES_MAX_NUM);
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("ulDisposeResNum", "astDisposeResList");
        }
    }

    /**
     * @struct tagEventRecord
     * @brief 告警记录信息
     * @attention
     */
    class EVENT_RECORD_V2_S extends Structure {
        /**
         * 告警编码
         */
        public byte[] szEventRecordCode = new byte[ZDL_RES_CODE_LEN];

        /**
         * 告警类型, 取值为#AlARM_TYPE_E
         */
        public int ulEventType;

        /**
         * 设备编码
         */
        public byte[] szDeviceCode = new byte[ZDL_DEVICE_CODE_LEN];

        /**
         * 设备名称
         */
        public byte[] szDeviceName = new byte[ZDL_NAME_LEN];

        /**
         * 父设备名称
         */
        public byte[] szParentDevName = new byte[ZDL_NAME_LEN];

        /**
         * 告警名称
         */
        public byte[] szActiveName = new byte[ZDL_NAME_LEN];

        /**
         * 告警级别, 取值为#ALARM_SEVERITY_LEVEL_E
         */
        public int ulEventSecurity;

        /**
         * 告警触发时间
         */
        public byte[] szEventTime = new byte[ZDL_TIME_LEN];

        /**
         * 告警状态, 取值为#ALARM_STATUS_E
         */
        public int ulAlarmStatus;

        /**
         * 事件级别名称
         */
        public byte[] szSecurityName = new byte[ZDL_NAME_LEN];

        /**
         * 事件级别显示颜色
         */
        public byte[] szSecurityColor = new byte[ZDL_STRING_LEN_14];

        /**
         * 告警核警时间
         */
        public byte[] szCheckTime = new byte[ZDL_TIME_LEN];

        /**
         * 告警核警用户
         */
        public byte[] szCheckUser = new byte[ZDL_NAME_LEN];

        /**
         * 告警确认时间
         */
        public byte[] szAckTime = new byte[ZDL_TIME_LEN];

        /**
         * 告警确认用户
         */
        public byte[] szAckUser = new byte[ZDL_NAME_LEN];

        /**
         * 参数名值对
         */
        public byte[] szKeyValue = new byte[ZDL_STRING_LEN_128];

        /**
         * 告警描述信息
         */
        public byte[] szEventDesc = new byte[ZDL_DESC_LEN];

        /**
         * 告警确认描述
         */
        public byte[] szAckSuggestion = new byte[ZDL_DESC_LEN];

        /**
         * 是否误报
         */
        public int ulIsMisinform;

        public int ulIsPlanAlarm;

        public int ulIsOncePlanAlarm;

        /**
         * 是否有需要手工处理任务
         */
        public int ulIsManualTask;

        /**
         * 保留字段
         */
        public byte[] szReserve = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szEventRecordCode", "ulEventType", "szDeviceCode", "szDeviceName",
                    "szParentDevName", "szActiveName", "ulEventSecurity", "szEventTime", "ulAlarmStatus",
                    "szSecurityName", "szSecurityColor", "szCheckTime", "szCheckUser", "szAckTime",
                    "szAckUser", "szKeyValue", "szEventDesc", "szAckSuggestion", "ulIsMisinform", "ulIsPlanAlarm",
                    "ulIsOncePlanAlarm", "ulIsManualTask", "szReserve");
        }
    }

    public static class STATEMENT_DISPOSITION_INFO_S extends Structure {
        public byte[] szDispositionCode = new byte[ZDL_CODE_LEN];
        public int ulInterType;
        public int bFuzzyMatch;
        public byte[] szLicensePlate = new byte[ZDL_CODE_LEN];
        public byte[] szLicensePlateColor = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public byte[] szLicensePlateType = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public byte[] szVehicleLogo = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public byte[] szVehicleFiguration = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public byte[] szVehicleType = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public int ulVehicleColorDepth;
        public byte[] szVehicleColor = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public byte[] szDispositionDept = new byte[ZDL_CODE_LEN];
        public byte[] szDispositionUser = new byte[ZDL_CODE_LEN];
        public int ulPriority;
        public int ulOpenFlag;
        public byte[] szDispositionType = new byte[SDKConst.ZDL_DICTIONARY_KEY_LEN];
        public byte[] szDispositionImage = new byte[SDKConst.ZDL_FILE_PATH_LEN];
        public byte[] szAddTime = new byte[ZDL_TIME_LEN];
        public byte[] szBeginTime = new byte[ZDL_TIME_LEN];
        public byte[] szEndTime = new byte[ZDL_TIME_LEN];
        public int ulStatus;
        public int ulExtStatus;
        public byte[] szCaseDesc = new byte[SDKConst.ZDL_DESC_LEN];
        public byte[] szActionDesc = new byte[SDKConst.ZDL_DESC_LEN];
        public byte[] szSmsMobile = new byte[SDKConst.ZDL_SMS_LEN_3072];
        public byte[] szDomainCode = new byte[ZDL_CODE_LEN];
        public int ulDisposePlanStatus;
        public byte[] szReserve = new byte[140];
        /* Statement名称，可不填 */
        public byte[] szDispositionName = new byte[ZDL_NAME_LEN];

        public STATEMENT_DISPOSITION_INFO_S() {

        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("szDispositionCode", "ulInterType", "bFuzzyMatch",
                    "szLicensePlate", "szLicensePlateColor", "szLicensePlateType", "szVehicleLogo",
                    "szVehicleFiguration", "szVehicleType", "ulVehicleColorDepth", "szVehicleColor",
                    "szDispositionDept", "szDispositionUser", "ulPriority", "ulOpenFlag",
                    "szDispositionType", "szDispositionImage", "szAddTime", "szBeginTime",
                    "szEndTime", "ulStatus", "ulExtStatus", "szCaseDesc", "szActionDesc",
                    "szSmsMobile", "szDomainCode", "ulDisposePlanStatus", "szReserve",
                    "stUndoInfo", "szAuditRemark", "szDispositionName");
        }
    }
}
