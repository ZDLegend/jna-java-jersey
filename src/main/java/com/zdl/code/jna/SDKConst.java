package com.zdl.code.jna;

/**
 * Created by user on 2016/7/9.
 */

public interface SDKConst {

    int
            BOOL_TRUE = 1,
            BOOL_FALSE = 0;

    int
            /*@brief 通用14位字符串 */
            ZDL_STRING_LEN_14 = 14,

    /*@brief 通用16位字符串 */
    ZDL_STRING_LEN_16 = 16,

    /*@brief 通用32位字符串 */
    ZDL_STRING_LEN_32 = 32,

    /*@brief 通用64位字符串 */
    ZDL_STRING_LEN_64 = 64,

    /*@brief 通用128位字符串 */
    ZDL_STRING_LEN_128 = 128,

    /*@brief 通用256位字符串 */
    ZDL_STRING_LEN_256 = 256,

    /*@brief 通用512位字符串 */
    ZDL_STRING_LEN_512 = 512,

    /*@brief 通用1024位字符串 */
    ZDL_STRING_LEN_1024 = 1024,

    /*@brief 通用2048位字符串 */
    ZDL_STRING_LEN_2048 = 2048;

    public static final int
            ZDL_PROCID_VMSERVER = 0x1,
            ZDL_PROCID_ISCSERVER = 0x1,
            ZDL_PROCID_SDKSERVER = 0x2,
            ZDL_PROCID_MCSERVER = 0x3,
            ZDL_PROCID_MPSERVER = 0x4,
            ZDL_PROCID_MSSERVER = 0x4,
            ZDL_PROCID_DMSERVER = 0x4,
            ZDL_PROCID_VXSERVER = 0x4,
            ZDL_PROCID_SGSERVER = 0x5,
            ZDL_PROCID_BMSERVER = 0x6,
            ZDL_PROCID_BWSERVER = 0x7,
            ZDL_PROCID_NDSERVER = 0x8,
            ZDL_PROCID_IMPSERVER = 0x9,
            ZDL_PROCID_UNPSERVER = 0xA,
            ZDL_PROCID_TMSSERVER = 0xB,
            ZDL_PROCID_TMSCOMBINE = 0xC,
            ZDL_PROCID_TMSWS = 0xD,
            ZDL_PROCID_TMSRECORD = 0xE,
            ZDL_PROCID_TSSERVER = 0xF,
            ZDL_PROCID_DRSERVER = 0x10,
            ZDL_PROCID_MDSERVER = 0x11,
            ZDL_PROCID_TMSNDSERVER = 0x12,
            ZDL_PROCID_UVWSSERVER = 0x13,
            ZDL_PROCID_MAPMSERVER = 0x14,
            ZDL_PROCID_SDKCLIENT = 0x64,
            ZDL_PROCID_MW_CTRL = 0x65,
            ZDL_PROCID_MW_STOR_MCP = 0x66,
            ZDL_PROCID_MW_PTZ = 0x67,
            ZDL_PROCID_MW_SNMP = 0x68,
            ZDL_PROCID_MW_ALM = 0x69,
            ZDL_PROCID_MW_CAPI = 0x6A,
            ZDL_PROCID_MW_SDK = 0x6B,
            ZDL_PROCID_DT = 0x101,
            ZDL_PROCID_WATCHDOG = 0x102,
            ZDL_AUTHORITY_MAX_NUM = 128,
            ZDL_AUTHORITY_MAX_NUM_EX = 1024,
            ZDL_AUTHORITY_MAX_FIELD_COUNT = 32,
            ZDL_SYS_PARAM_LEN = 128,
            ZDL_CODE_LEN = 48,
            ZDL_NAME_LEN = 64,
            ZDL_URL_LEN = 512,
            ZDL_RES_CODE_LEN = ZDL_CODE_LEN,
            ZDL_DEVICE_CODE_LEN = ZDL_CODE_LEN,
            ZDL_USER_CODE_LEN = ZDL_CODE_LEN,
            ZDL_DOMAIN_CODE_LEN = ZDL_CODE_LEN,
            ZDL_DOMAIN_NAME_LEN = ZDL_NAME_LEN,
            ZDL_AUTH_CODE_LEN = ZDL_CODE_LEN,
            ZDL_UAID_LEN = 64,
            ZDL_UA_CODE_LEN = ZDL_UAID_LEN,
            ZDL_RECORD_LABEL_LEN = 256,
            ZDL_SSN_ID_LEN = ZDL_STRING_LEN_32,
            ZDL_MP_ABILITY_LEN = ZDL_STRING_LEN_256,
            ZDL_DECODERTAG_LEN = ZDL_STRING_LEN_32,
            ZDL_SG_HEAD_CODE_LEN = 2,
            ZDL_MODULE_NAME_LEN = 64,
            ZDL_MAC_ADDR_LEN = 20,
            ZDL_IPADDR_LEN = 64,
            ZDL_IPADDR_TYPE_INVALID = (0xFFFFFFFF),
            ZDL_IPADDR_TYPE_MAC = 0,
            ZDL_IPADDR_TYPE_IPV4 = 1,
            ZDL_IPADDR_TYPE_IPV6 = 2,
            ZDL_IPADDR_TYPE_DOMAINNAME = 16,
            ZDL_PASSWD_LEN = 16,
            ZDL_PASSWD_ENCRYPT_LEN = 64,
            ZDL_TIME_LEN = 32,
            ZDL_SIMPLE_TIME_LEN = 12,
            ZDL_SIMPLE_DATE_LEN = 12,
            ZDL_DESC_LEN = (128 * 3),
            ZDL_PHONE_LEN = 32,
            ZDL_MOBILE_LEN = 32,
            ZDL_SMS_LEN_3072 = 3072,
            ZDL_MAIL_LEN = 64,
            ZDL_MAIL_CODE_LEN = 8,
            ZDL_CONTACT_ADDRESS_LEN = 64,
            ZDL_PRODUCTNAME_LEN = 32,
            ZDL_VERSION_INFO_LEN = 64,
            ZDL_NEW_VERSION_INFO_LEN = 256,
            ZDL_FILE_NAME_LEN = 64,
            ZDL_FILE_NAME_LEN_V2 = 256,
            ZDL_ERR_CODE_LEN = 11,
            ZDL_XML_KEY_LEN = 64,
            ZDL_FILE_PATH_LEN = 256,
            ZDL_FILE_PATH_WITHOUT_FILENAME_LEN = 128,
            ZDL_MEASUREMENT_LEN = 16,
            ZDL_DICTIONARY_KEY_LEN = 8,
            ZDL_COORDINATE_LEN = 32,
            ZDL_RES_PATH_LEN = 1024,
            ZDL_XP_LAYOUT_DESC_LEN = 256,
            ZDL_RESERVED_LEN = 64,
            ZDL_SN_LEN = 24,
            ZDL_RES_TREE_LEVEL = 26,
            ZDL_DEV_STATUS_ONLINE = 1,
            ZDL_DEV_STATUS_OFFLINE = 2,
            ZDL_DEV_STATUS_NORMAL = 3,
            ZDL_DEV_STATUS_FAULT = 4,
            ZDL_DEV_UNABLE = 0,
            ZDL_DEV_ENABLE = 1,
            ZDL_Radix_2 = 2,
            ZDL_Radix_8 = 8,
            ZDL_Radix_10 = 10,
            ZDL_Radix_16 = 16,
            ZDL_ID_STRING_LEN = 24,
            ZDL_BAK_CASE_LEN = 128,
            ZDL_CASE_DESC_LEN = (1024 * 3),
            ZDL_NOTE_LEN = (256 * 3),
            ZDL_VEHICLE_TRACK_PLACE_MAX_NUM = 16,
            ZDL_VEHICLE_TRACK_COLLISION_RES_MAX_NUM = 200,
            ZDL_VEHICLE_FIRST_APPEAR_RES_MAX_NUM = 200,
            ZDL_VEHICLE_PERIL_TIME_RES_MAX_NUM = 200,
            ZDL_VEHICLE_FREQUENT_NIGHT_OUT_RES_MAX_NUM = 200,
            ZDL_VEHICLE_NOCTURNAL_RES_MAX_NUM = 200,
            ZDL_VEHICLE_ONLY_INTO_CITY_RES_MAX_NUM = 200,
            ZDL_VEHICLE_OPERATION_ANALYSE_RES_MAX_NUM = 200,
            ZDL_MAP_AREA_DISPOSE_RES_MAX_NUM = 200,
            ZDL_TMS_MULTI_FORWARD_RES_MAX_NUM = 200,
            ZDL_TOLLGATE_GROUP_RES_MAX_NUM = 200,
            ZDL_TOLLGATE_INVALID_AVERAGE_SPEED = (0XFFFE),
            ZDL_SECS_PER_MINUTE = 60,
            ZDL_SUN = 0,
            ZDL_MON = 1,
            ZDL_TUE = 2,
            ZDL_WED = 3,
            ZDL_THU = 4,
            ZDL_FRI = 5,
            ZDL_SAT = 6,
            ZDL_JAN = 0,
            ZDL_FEB = 1,
            ZDL_MAR = 2,
            ZDL_APR = 3,
            ZDL_MAY = 4,
            ZDL_JUN = 5,
            ZDL_JUL = 6,
            ZDL_AUG = 7,
            ZDL_SEP = 8,
            ZDL_OCT = 9,
            ZDL_NOV = 10,
            ZDL_DEC = 11,
            ZDL_SG_ID_LEN = (ZDL_DEVICE_CODE_LEN + 6),
            ZDL_STREAM_MAXNUM = 2,
            ZDL_STREAM_MAXNUM_II = 3,
            ZDL_AREA_MAXNUM = 12,
            ZDL_MASK_AREA_MAXNUM = 4,
            ZDL_MASK_AREA_MAXNUM_VIII = 8,
            ZDL_DETECT_AREA_MAXNUM = 4,
            ZDL_OSD_NAME_MAXNUM = 1,
            ZDL_OSD_NAME_MAXNUM_II = 2,
            ZDL_OSD_NAME_MAXNUM_I = 1,
            ZDL_OSD_NAME_MAXNUM_IV = 4,
            ZDL_OSD_NAME_MAXNUM_VIII = 8,
            ZDL_OSD_NAME_MAX = 9,
            ZDL_OSD_TIME_MAX = 1,
            ZDL_INTERVAL_DEFAULT_VALUE = 0,
            ZDL_MS_MAX_NUM_PER_CHANNEL = 1,
            ZDL_MAX_TIME_SLICE_NUM = 4,
            ZDL_MAX_TIME_SLICE_NUM_V2 = 16,
            ZDL_WEEK_DAYS = 7,
            ZDL_EXCP_DAYS = 16,
            ZDL_SRV_CODE_REGISTER = 1001,
            ZDL_SRV_CODE_CONFIG = 1002,
            ZDL_SRV_CODE_FILE = 1003,
            ZDL_SRV_CODE_CHECK = 1004,
            ZDL_SRV_CODE_MONITOR = 2001,
            ZDL_SRV_CODE_VOICE_TALKBACK = 2011,
            ZDL_SRV_CODE_VOICE_BROADCAST = 2012,
            ZDL_SRV_CODE_MON_TALKBACK = 2013,
            ZDL_SRV_CODE_MON_BROADCAST = 2014,
            ZDL_SRV_CODE_REC_QUERY = 3001,
            ZDL_SRV_CODE_REC_DOWNLOAD = 3002,
            ZDL_SRV_CODE_REC_VOD = 3003,
            ZDL_SRV_CODE_REC_BACKUP = 3004,
            ZDL_SRV_CODE_VODWALL = 3005,
            ZDL_SRV_CODE_REC_URL = 3006,
            ZDL_SRV_CODE_REC_QUERY_PUSH = 3007,
            ZDL_SRV_CODE_LOCK_RECORD = 3008,
            ZDL_SRV_CODE_DEVICE_REC_QUERY = 3009,
            ZDL_SRV_CODE_DIR_STROE = 4001,
            ZDL_SRV_CODE_STR_STORE = 4002,
            ZDL_SRV_CODE_TP_STORE = 4003,
            ZDL_SRV_CODE_REFRESH_STORE_IDX = 4004,
            ZDL_SRV_CODE_GET_INITIATOR = 4010,
            ZDL_SRV_CODE_CENT_STORE_RES_CFG = 4011,
            ZDL_SRV_CODE_CENT_STORE_PLAN_CFG = 4012,
            ZDL_SRV_CODE_CENT_ALARM_STORE_CFG = 4013,
            ZDL_SRV_CODE_CENT_TRIGGER_ALARM_STORE = 4020,
            ZDL_SRV_CODE_CENT_TRIGGER_MANUAL_STORE = 4021,
            ZDL_SRV_CODE_PTZ = 5001,
            ZDL_SRV_CODE_SWITCH = 5002,
            ZDL_SRV_CODE_PRESETLIST_QUERY = 5003,
            ZDL_SRV_CODE_PTZ_LOCK_UNLOCK = 5004,
            ZDL_SRV_CODE_PTZ_UNLOCK_NOTIFY = 5005,
            ZDL_SRV_CODE_TRANS_CHANNEL = 6001,
            ZDL_SRV_CODE_TRANS_DATA = 6002,
            ZDL_SRV_CODE_ALARM = 7001,
            ZDL_SRV_CODE_ALARM_CTRL = 7002,
            ZDL_SRV_CODE_ALARM_QUERY = 7003,
            ZDL_SRV_CODE_CAM_INFO_QUERY = 7004,
            ZDL_SRV_CODE_DEV_INFO_QUERY = 7005,
            ZDL_SRV_CODE_DEV_INFO_RES = 7006,
            ZDL_SRV_CODE_DEV_STATIC_QUERY = 7007,
            ZDL_SRV_CODE_DEV_STATIC_RES = 7008,
            ZDL_SRV_CODE_DEVICE_SHARE = 8001,
            ZDL_SRV_CODE_LAYOUT_RES_SHARE = 8002,
            ZDL_SRV_CODE_RESOURCE_QUERY = 8100,
            ZDL_SRV_CODE_SUB_CATALOG = 8101,
            ZDL_SRV_CODE_SET_DATETIME = 8101,
            ZDL_SRV_CODE_SET_VIDEOCODE = 8102,
            ZDL_SRV_CODE_SET_RESOURCE = 8103,
            ZDL_SRV_CODE_SET_PRESET = 8104,
            ZDL_SRV_CODE_SET_OSD = 8105,
            ZDL_SRV_CODE_SET_VIDEOHIDE = 8106,
            ZDL_SRV_CODE_SET_COVERALARM = 8107,
            ZDL_SRV_CODE_SET_MOTIONALARM = 8108,
            ZDL_SRV_CODE_QUERY_DATETIME = 8151,
            ZDL_SRV_CODE_QUERY_VIDEOCODE = 8152,
            ZDL_SRV_CODE_QUERY_RESOURCE = 8153,
            ZDL_SRV_CODE_QUERY_PRESET = 8154,
            ZDL_SRV_CODE_QUERY_OSD = 8155,
            ZDL_SRV_CODE_QUERY_VIDEOMASK = 8156,
            ZDL_SRV_CODE_QUERY_COVERDETECT = 8157,
            ZDL_SRV_CODE_QUERY_MOTIONDETECT = 8158,
            ZDL_SRV_CODE_3DCONTROLCAMERA = 8159,
            ZDL_SRV_CODE_SUBSCRIBE = 9001,
            ZDL_SRV_CODE_DOMAIN_DATASYN = 9002,
            ZDL_SRV_CODE_QUERY_RES = 9003,
            ZDL_SRV_CODE_TEL_REBOOT = 9600,
            ZDL_SRV_CODE_SETGUARD = 9601,
            ZDL_SRV_CODE_RESETGUARD = 9602,
            ZDL_SRV_CODE_ALARM_RESET = 9603,
            ZDL_SRV_CODE_TG_DISPOSE = 9701,
            ZDL_LICENSE_AUTHORITY_CODE_LENGTH = (32 + 4),
            ZDL_VIDEO_AREA_TYPE_MASK = 0,
            ZDL_VIDEO_AREA_TYPE_COVER_DETECT = 1,
            ZDL_VIDEO_AREA_TYPE_MOTION_DETECT = 2,
            ZDL_VOUT_CHANNEL_MAXNUM = 4,
            ZDL_VOUT_CHANNEL_DEFAULT_NUM = 1,
            ZDL_MAX_CMD_PARAM_LEN = 512,
            ZDL_MAX_CMD_PARAM_NUM = 6,
            ZDL_DEVICE_TYPE_NUM = 14,
            ZDL_NTP_SYNC_STATUS_LEN = 32,
            ZDL_MIN_THIRD_MANUFACTURERID = 1,
            ZDL_MAX_THIRD_MANUFACTURER_ID = 60000,
            ZDL_MIN_THIRD_DEV_TYPE_ID = 20000,
            ZDL_MAX_THIRD_DEV_TYPE_ID = 40000,
            ZDL_MIN_THIRD_EVT_TYPE_ID = 20000,
            ZDL_MAX_THIRD_EVT_TYPE_ID = 40000,
            ZDL_NO_EXIST_EVENT_TYPE_ID = 0,
            ZDL_DEVICE_TYPE_ALL = 65535,
            ZDL_MAX_THIRD_MANUFACTURER_ID_ALL = 65535,
            ZDL_MAX_THIRD_DEV_TYPE_ID_ALL = 50000,
            ZDL_MAX_THIRD_EVT_TYPE_ID_ALL = 50000,
            ZDL_SUBSC_ITEM_MAX_NUM = 8,
            ZDL_MAX_VEHICLE_IMG_NUM = 4,
            ZDL_MAX_VEHICLE_IMG_NUM_EX = 4,
            ZDL_MAX_LICENSE_PLATE_NUM = 2,
            ZDL_MAX_CAMERA_LANE_NUM = 8,
            ZDL_MAX_LANE_DIRECTION_NUM = 200,
            ZDL_DEFAULT_LANE_DIRECTION_NUM = 2,
            ZDL_MAX_VEHICLE_TYPE_NUM = 5,
            ZDL_MAX_TOLLGATE_PHOTO_STOR_SLICE_NUM = 16,
            ZDL_MAX_TOLLGATE_PHOTO_LIFT_CYCLE_NUM = 16,
            ZDL_DATE_TIME_FORMAT_LEN = (19),
            ZDL_QUERY_ITEM_MAX_NUM2 = 200,
            ZDL_MAX_PLAN_PARAM_LEN = 128,
            ZDL_SECOND_IN_MIN = 60,
            ZDL_SECOND_IN_HOUR = 3600,
            ZDL_ALARM_SEND_USER_MAXNUM = 256,
            ZDL_ALARM_SEND_THD_SYS_MAXNUM = 256,
            ZDL_ALARM_SEND_SRC_MAXNUM = 2000,
            ZDL_ALARM_SEND_RULE_MAXNUM = 3000,
            ZDL_BEHAVIOR_RULE_MAX = 8,
            ZDL_COORDINATE_STR_LEN_16 = 16,
            ZDL_COORDINATE_STR_LEN_56 = 56,
            ZDL_RES_GROUP_EXT_LEN = 1024,
            ZDL_WEBGIS_LAYER_NAME_LEN = 256,
            ZDL_MON_NETWORK_ADAPT_ENABLE_DEFAULT = 2,
            ZDL_STORE_NETWORK_ADAPT_ENABLE_DEFAULT = 2,
            ZDL_NETWORK_ADAPT_MODE_DEFAULT = 0,
            ZDL_NETWORK_ADAPT_COUNT_DEFAULT = 30,
            ZDL_MAX_WINDOW_NUMBER = 256,
            ZDL_CAM_MAX_NUM = 16,
            ZDL_CAM_SHARE_RESERVED_LEN = 32,
            ZDL_SPLIT_SCREEN_SWITCH_CLOSE = 0,
            ZDL_MAX_LOGIN_ADDRESS_NUM = (20),
            ZDL_MAX_BINDING_ADDRESS_NUM = (50),
            ZDL_POLYGON_GEO_LEN = 1024,
            ZDL_POINT_GEO_LEN = 128,
            ZDL_ALL_DESC_LEN = 8,
            ZDL_VFA_LEN = 4,
            ZDL_IPC_CAM_INFO_REVERSED_LEN = 512,
            ZDL_REC_TIME_TOLERANCE_DIFF = 1,
            ZDL_NETWORK_CARD_NAME_LEN_FOR_ECR = 16,
            ZDL_NETWORK_CARD_PHY_MAXNUM_FOR_ECR = 16,
            ZDL_NETWORK_CARD_IP_ADDR_MAXNUM_FOR_ECR = 4,
            ZDL_VERSION_LENTH = 64,
            ZDL_IPADDR_LENTH = 40,
            ZDL_PLACE_NAME_LEN = 256,
            ZDL_TOLLGATE_SPECIAL_LEN = 4,
            ZDL_TOLLGATE_SPECIAL_NAME_LEN = 68,
            ZDL_TOLLGATE_SPECIAL_ID_LEN = 20,
            ZDL_TOLLGATE_CODE_LEN = 36,
            ZDL_MAX_VEHICLE_IMG_NUM_FOR_ECR = 6,
            ZDL_MAX_VEHICLE_IMG_NAME_LEN = 260,
            ZDL_IPC_SERIAL_PORT_MAX_NUM = 5,
            ZDL_XML_EXPAND_DESC_LEN = ZDL_STRING_LEN_32,
            ZDL_IPC_OSD_MAXNUM = 8,
            ZDL_IPC_OSD_BLOCK_MAXNUM = 8,
            ZDL_IPC_OSD_BLOCK_MAXNUM_III = 3,
            ZDL_IPC_MAX_ROI_NUM = 4,
            ZDL_ONVIF_PROFILE_MAX = 8,
            ZDL_ONVIF_STREAM_MAX = 2,
            ZDL_LOW_TEMPERATURE_ALARM_MAX = 49,
            ZDL_HIGH_TEMPERATURE_ALARM_MIN = 50,
            ZDL_HIGH_TEMPERATURE_ALARM_MAX = 104,
            ZDL_INVALID_DOMAIN_LEVEL = (0xFFFF);

    public static final int
            ZDL_OPTION_BUFFER_LEN_MIN = 1,
            ZDL_OPTION_BUFFER_LEN_MAX = 64,
            ZDL_MONITOR_MAXNUM_PER_WALL = 256,
            ZDL_SPLIT_MAXNUM_PER_WALL = (17 * ZDL_MONITOR_MAXNUM_PER_WALL),
            ZDL_ALARM_STORE_ACTION_MAXNUM = 16,
            ZDL_ALARM_VOCTALK_ACTION_MAXNUM = 16,
            ZDL_ALARM_CENTER_STORE_ACTION_MAXNUM = 16,
            ZDL_ALARM_PRESET_ACTION_MAXNUM = 16,
            ZDL_ALARM_SCREENLIVE_ACTION_MAXNUM = 16,
            ZDL_ALARM_MONITORLIVE_ACTION_MAXNUM = 16,
            ZDL_ALARM_GIS_ACTION_MAXNUM = 16,
            ZDL_ALARM_SWITCHOUT_ACTION_MAXNUM = 16,
            ZDL_ALARM_BACKUP_ACTION_MAXNUM = 16,
            ZDL_ALARM_ACTION_RECEIVER_MAXNUM = 300,
            ZDL_ALARM_BUZZER_ACTION_MAXNUM = 1,
            ZDL_TRANSPARENT_SERIAL_NUM = 2,
            ZDL_SWITCH_CAM_MAXNUM = 32,
            ZDL_SWITCH_CAM_MAXNUM_V2 = 512,
            ZDL_CRUISE_PATH_PRESET_MAX_COUNT = 32,
            ZDL_ARRAY_SLOT_MAXNUM = 10,
            ZDL_MASK_AREA_MAXNUM_III = 3,
            ZDL_MASK_AREA_MAXNUM_I = 1,
            ZDL_COVER_AREA_MAXNUM = 4,
            ZDL_NTP_SERVER_MAXNUM = 3,
            ZDL_GIS_FOR_ALARM_SRC_MAX_NUM = 5,
            ZDL_CONTRACT_ID = 32,
            ZDL_LICENSE_SERIALS_NUM = 256,
            ZDL_LICENSE_SERVICE_TYPE_NUM = 20,
            ZDL_PAGE_QUERY_ROW_MAX_NUM = 200,
            ZDL_ONCE_SHARE_RES_MAXNUM = 1,
            ZDL_MAX_CAMERA_NUM_PER_EC = 64,
            ZDL_MAX_SCREEN_NUM_PER_DC = 16,
            ZDL_IE_URL_LEN = ZDL_STRING_LEN_512,
            ZDL_INVALID_CHANNEL_NO = 0xFF,
            ZDL_XP_WIN_MAX_NUM = 128,
            ZDL_QUERY_DATA_MAX_LEN = 64,
            ZDL_QUERY_ITEM_MAX_NUM = 16,
            ZDL_MAX_EXTERNAL_DOMAIN_NUM = 1024,
            ZDL_MAX_USER_ROLES_NUM = 16,
            ZDL_MAX_NOTIFY_LEN = 4096,
            ZDL_DEV_STATUS_MAX_NUM = 4,
            ZDL_DISPLAY_MAXNUM_PER_LAYOUT = ZDL_MONITOR_MAXNUM_PER_WALL,
            ZDL_DISPLAY_MAXNUM_PER_SALVO = 256,
            ZDL_SCENE_MAXNUM_RES = 1,
            ZDL_RES_NUM_MAX_PER_GROUP = 256,
            ZDL_COMMON_SWITCH_RES_MAXNUM = 256,
            ZDL_GIS_MAX_HOTZONE_NUM_PER_MAP = 32,
            ZDL_GIS_MAX_ICON_NUM_PER_MAP = 2048,
            ZDL_MAX_GIS_MAP_PARAM_NUM = 1,
            ZDL_BEALARM_REPLAY_LEN = (ZDL_CODE_LEN + 8 + ZDL_TIME_LEN),
            ZDL_IDLE_LEN = (ZDL_NAME_LEN + ZDL_CODE_LEN - 12 - ZDL_BEALARM_REPLAY_LEN),
            ZDL_SYS_PARAM_MAX_NUM = 128,
            ZDL_EVENT_ENABLE_ADD_MAX_NUM = 1024,
            ZDL_EVENT_TYPE_REL_MAX_NUM = 128,
            ZDL_EMAIL_NOTIFICATION_NUMBER = 3,
            ZDL_HD_MAX_SITE_NAME_LEN = 31,
            ZDL_SITE_NAME_LEN = 48,
            ZDL_HD_MAX_CONF_NAME_LEN = 31,
            ZDL_CONF_NAME_LEN = 48,
            ZDL_HD_MAX_AUDIO_PROTOCOL_NUM = 20,
            ZDL_HD_MAX_BANNER_LEN = 43,
            ZDL_BANNER_LEN = 66,
            ZDL_HD_MAX_CONF_ALIAS_LEN = 31,
            ZDL_CONF_ALIAS_LEN = (ZDL_HD_MAX_CONF_ALIAS_LEN + 1),
            ZDL_HD_MAX_SITE_PER_CONF_NUM = 256,
            ZDL_HD_MAX_SUBPIC_NUM = 64,
            ZDL_HD_MAX_VIDEO_FORMAT_NUM = 32,
            ZDL_HD_MAX_VIDEO_FRAMERATE_NUM = 7,
            ZDL_HD_MAX_VIDEO_PROTOCOL_NUM = 4,
            ZDL_HD_MAX_VIDEO_RATE_NUM = 8,
            ZDL_HD_MAX_SIM_CAP_NUM = 8,
            ZDL_MC_MAX_CONF_CYCLE_TABLE_COUNT = 10,
            ZDL_MC_MAX_CONF_PWD_LEN = 11,
            ZDL_CONF_PWD_LEN = (ZDL_MC_MAX_CONF_PWD_LEN + 1),
            ZDL_MC_MAX_LAN_NET_NUM = 4,
            ZDL_HD_MAX_NETCARD_NAME_LEN = 31,
            ZDL_NETCARD_NAME_LEN = 48,
            ZDL_MC_MAX_MCU_NAME_LEN = 31,
            ZDL_MCU_NAME_LEN = (ZDL_MC_MAX_MCU_NAME_LEN + 1),
            ZDL_MC_MAX_MCU_IP_NUM = 4,
            ZDL_MC_MAX_LAN_ROUTE_NUM = 20,
            ZDL_MC_MAX_LAN_ARP_NUM = 20,
            ZDL_MC_MAX_MAC_ADDR_LEN = 20,
            ZDL_HD_MAX_SOFT_VERSION_LEN = 255,
            ZDL_SOFT_VERSION_LEN = (ZDL_HD_MAX_SOFT_VERSION_LEN + 1),
            ZDL_HD_MAX_DSP_PER_PLANK = 15,
            ZDL_HD_MAX_DSP_NUM_PER_CONF = 4,
            ZDL_HD_MAX_EMAIL_NAME_LEN = 63,
            ZDL_MC_MAX_WATCH_SITE_NUM = 9,
            ZDL_HD_VIDEO_OUT_NUM = (4),
            ZDL_HD_VERSION_LEN = (32),
            ZDL_HD_MAX_USER_NUM = (32),
            ZDL_HD_MAX_CAM_PRE_NUM = (20),
            ZDL_HD_MAX_NAME_LENGTH = (32),
            ZDL_HD_MAX_IP_LENGTH = (32),
            ZDL_HD_MAX_PATH_LENGTH = (100),
            ZDL_HD_MAX_PASSWORD_LENGTH = (32),
            ZDL_HD_MAX_PRIVATE_NET_COUNT = (4),
            ZDL_HD_MAX_MAC_DISPLAYLENGTH = (17),
            ZDL_TITLE_MAXNUM = (2),
            ZDL_TITLE_LEN = (2404),
            ZDL_MAX_CONTACTS_IN_CONF = (512),
            ZDL_COMPONENT_MAX_NUM = (50),
            ZDL_MAX_SITE_LIVE_NUM = (240),
            ZDL_MAX_MULTI_ADDR_NUM = (8),
            ZDL_MC_MAX_BITRATE_ADAPT_COUNT = (3),
            ZDL_MAX_MCU_IN_CONF = (16),
            ZDL_MAX_TERM_IN_CONF = (1024),
            ZDL_TRANSPARENT_IP_NUM = 1,
            ZDL_PROC_NAME_MAX_LEN = 32,
            ZDL_DEFAULT_NUM_OF_STREAM_BYPASS = 1024,
            ZDL_MAX_TASK_NUM = (16),
            ZDL_ALARM_ACTION_TRAN_MAXNUM = (300),
            ZDL_MAX_TRIGGER_NUM = (10),
            ZDL_MAX_NEW_ALARM_NUM = (1),
            ZDL_ALARM_ACTION_PLAN_MAXNUM = (1),
            ZDL_TYPE_NEW_ALARM = (65534),
            ZDL_PICTURE_SIZE_MAX_LEN = (512 * 1024),
            ZDL_VIDEO_AREA_TYPE_ROI = 3,
            ZDL_CASE_MAXNUM_PER_SERIESCASE = 64,
            ZDL_FILE_MAXNUM_PER_CASERECORD = 8,
            ZDL_VEHICLE_VIOLATION_MAX_NUM = 200,
            ZDL_VEHICLE_TYPE_MAX_NUM = 32,
            ZDL_VEHICLE_DISPOSITION_DOMAIN_MAX_NUM = 200,
            ZDL_VEHICLE_ABNORMAL_ANALYSE_TG_MAX_NUM = 200,
            ZDL_MAP_LINT_POINT_NUM = 2,
            ZDL_MAP_ROAD_POINT_MAX_NUM = 64,
            ZDL_DETECTION_ROAD_SECTION_VIO_CONF_MAX_NUM = 32,
            ZDL_ECR_CODE_LEN = (ZDL_CODE_LEN - 8),
            ZDL_TRUNK_MAXNUM = 32,
            ZDL_TRUNK_CONTENT_MAXNUM = 256,
            ZDL_MAX_3D_COVER_AREA_NUM = 8;


    interface BLACKLIST_SRC_E {
        int BLACKLIST_SRC_UNKNOWN = 0, /**
         * < 未知
         */
        BLACKLIST_SRC_LOCAL = 1, /**
         * < 手工添加
         */
        BLACKLIST_SRC_DRIVER_MANAGEMENT = 2, /**
         * < 车驾管数据库
         */
        BLACKLIST_SRC_TRAFFIC_VIOLATION = 3, /**
         * < 违法车辆数据库
         */
        BLACKLIST_SRC_VEHICLE_GRAB = 4, /**
         * < 盗抢车辆数据库
         */
        BLACKLIST_SRC_MAX = 5, /**
         * < 最大值
         */
        BLACKLIST_SRC_INVALID = 0xFFFF; /** < 无效值 */
    }

    /**
     * 用户所属域类型
     */
    interface DomainType {
        int MM_DOMAIN_SUBTYPE_LOCAL_PHYSICAL = 1; // 本物理域
        int MM_DOMAIN_SUBTYPE_LOCAL_VIRTUAL = 2; // 本域的虚拟域
    }

    /**
     * 订阅推送的类型 目前仅支持SUBSCRIBE_PUSH_TYPE_ALL
     */
    interface SubcirbePushType {
        int SUBSCRIBE_PUSH_TYPE_ALL = 0; // 接受告警推送和设备状态推送
        int SUBSCRIBE_PUSH_TYPE_ALARM = 1; // 只接收告警推送
        int SUBSCRIBE_PUSH_TYPE_ALARM_STATUS = 2; // 只接收设备状态推送
        int SUBSCRIBE_PUSH_TYPE_MAX = 3; // 本域的虚拟域
        int SUBSCRIBE_PUSH_TYPE_INVALID = 0xFFFFFFFF; // 本域的虚拟域
    }

    /**
     * 告警类型
     */
    interface AlarmTypeE {
        /**
         * MIB告警 1~200
         */
        int AlARM_TYPE_HIGH_TEMPERATURE = 1;
        /**
         * < 高温告警
         */
        int AlARM_TYPE_LOW_TEMPERATURE = 2;
        /**
         * < 低温告警
         */
        int AlARM_TYPE_TEMPERATURE_RESUME = 3;
        /**
         * < 温度告警恢复
         */
        int AlARM_TYPE_FAN_FAULT = 4;
        /**
         * < 风扇故障告警
         */
        int AlARM_TYPE_FAN_FAULT_RESUME = 5;
        /**
         * < 风扇故障告警恢复
         */
        int AlARM_TYPE_FLASH_OPERATE = 6;
        /**
         * < Flash操作告警
         */
        int AlARM_TYPE_CPU_EXCEED = 7;
        /**
         * < CPU利用率过高告警
         */
        int AlARM_TYPE_MEMOY_EXCEED = 8;
        /**
         * < 内存利用率过高告警
         */
        int AlARM_TYPE_REBOOT = 9;
        /**
         * < 设备重启
         */
        int AlARM_TYPE_DEVICE_CONFIG_CHANGE = 10;
        /**
         * < 设备配置变更
         */
        int AlARM_TYPE_DISK_ERR = 11;
        /**
         * < 磁盘故障
         */
        int AlARM_TYPE_DISK_ERR_RECOVER = 12;
        /**
         * < 磁盘故障恢复
         */
        int AlARM_TYPE_DISK_POWER_ON = 13;
        /**
         * < 磁盘上线
         */
        int AlARM_TYPE_DISK_POWER_OFF = 14;
        /**
         * < 磁盘下线
         */
        int AlARM_TYPE_RAID_EXCEPTION = 15;
        /**
         * < 阵列异常告警
         */
        int AlARM_TYPE_RAID_REBUILD_START = 16;
        /**
         * < 进入重建状态
         */
        int AlARM_TYPE_RAID_REBUILD_FINISH = 17;
        /**
         * < 退出重建
         */
        int AlARM_TYPE_STP_EXEC_EXCEPTION = 18;
        /**
         * < 未按计划录像告警
         */
        int AlARM_TYPE_STP_EXEC_RECOVER = 19;
        /**
         * < 未按计划录像恢复告警
         */
        int AlARM_TYPE_IPSAN_NO_ACCESS = 20;
        /**
         * < 无法访问IPSAN存储设备告警
         */
        int AlARM_TYPE_IPSAN_NO_ACCESS_RECOVER = 21;
        /**
         * < 无法访问IPSAN存储设备恢复告警
         */
        int AlARM_TYPE_STORED_DATA_READ_ERR = 22;
        /**
         * < 读取存储数据失败
         */
        int AlARM_TYPE_STORED_DATA_SEEK_ERR = 23;
        /**
         * < 定位存储设备失败
         */
        int AlARM_TYPE_VOD_OVER_THRESHOLD = 24;
        /**
         * < 点播路数超出阈值
         */
        int AlARM_TYPE_VOD_UNDER_THRESHOLD = 25;
        /**
         * < 点播流数量恢复
         */
        int AlARM_TYPE_TEMPERATURE = 26;
        /**
         * < 温度告警
         */
        int AlARM_TYPE_CAM_BAK_OWN_UNDER_THR = 27;
        /**
         * < 摄像机独享备份资源容量使用达到阈值恢复
         */
        int AlARM_TYPE_CAM_BAK_SHARD_OVER_THR = 28;
        /**
         * < 摄像机共享备份资源容量使用达到阈值
         */
        int AlARM_TYPE_CAM_BAK_SHARD_UNDER_THR = 29;
        /**
         * < 摄像机共享备份资源容量使用达到阈值恢复
         */
        int AlARM_TYPE_CAM_BAK_OWN_CAP_SCANT = 30;
        /**
         * < 摄像机独享备份资源配置满停止策略时，资源剩余容量不足
         */
        int AlARM_TYPE_CAM_BAK_OWN_CAP_ENOUGH = 31;
        /**
         * < 摄像机独享备份资源配置满停止策略时，资源剩余容量不足恢复
         */
        int AlARM_TYPE_BAK_RES_CAP_SCANT = 32;
        /**
         * < 全局备份配置满停止策略时，全局资源剩余容量不足
         */
        int AlARM_TYPE_BAK_RES_CAP_ENOUGH = 33;
        /**
         * < 全局备份配置满停止策略时，全局资源剩余容量不足恢复
         */
        int AlARM_TYPE_BAK_RES_ABNORMAL = 34;
        /**
         * < 备份资源异常
         */
        int AlARM_TYPE_BAK_RES_NORMAL = 35;
        /**
         * < 备份资源异常恢复
         */
        int AlARM_TYPE_BAK_FAILED = 36;
        /**
         * < 备份任务执行失败
         */
        int AlARM_TYPE_CAM_BAK_OWN_OVER_THR = 37;
        /**
         * < 摄像机独享备份资源容量使用达到阈值
         */
        /* Begin: Added by mozhanfei(kf0149); 2013-9-9 for 新增异常恢复告警 */
        int AlARM_TYPE_RAID_EXCEPTION_RECOVER = 38;
        /**
         * < 阵列异常恢复告警
         */
        /* End: Added by mozhanfei(kf0149); 2013-7-18 for 新增异常恢复告警 */
        int AlARM_TYPE_PREVENT_REMOVAL = 71;
        /**
         * < 防拆告警
         */
        int AlARM_TYPE_PREVENT_REMOVAL_RESUME = 72;
        /**
         * < 防拆告警恢复
         */
        /* Begin added by baoyihui02795; 2011-04-28 of 卡口项目 */
        int AlARM_TYPE_FLASHLIGHT_FAULT = 194;
        /**
         * < 闪光灯故障
         */
        int AlARM_TYPE_FLASHLIGHT_FAULT_RESUME = 195;
        /**
         * < 闪光灯故障恢复
         */
        int AlARM_TYPE_STOR_RES_ABNORMAL = 196;
        /**
         * < 存储资源异常
         */
        int AlARM_TYPE_STOR_RES_NORMAL = 197;
        /**
         * < 存储资源异常恢复
         */
        int AlARM_TYPE_COIL_DISABLED = 198;
        /**
         * < 线圈失效
         */
        int AlARM_TYPE_COIL_ENABLED = 199; /** < 线圈失效恢复 */
        /* End added by baoyihui02795; 2011-04-28 of 卡口项目 */
        /**
         * SIP告警 201~
         */
        int AlARM_TYPE_VIDEO_LOST = 201;
        /**
         * < 视频丢失告警
         */
        int AlARM_TYPE_VIDEO_LOST_RESUME = 202;
        /**
         * < 视频丢失告警恢复
         */
        int AlARM_TYPE_MOVE_DETECT = 203;
        /**
         * < 运动检测告警
         */
        int AlARM_TYPE_MOVE_DETECT_RESUME = 204;
        /**
         * < 运动检测告警恢复
         */
        int AlARM_TYPE_MASK_DETECT = 205;
        /**
         * < 遮挡侦测告警
         */
        int AlARM_TYPE_MASK_DETECT_RESUME = 206;
        /**
         * < 遮挡侦测告警恢复
         */
        int AlARM_TYPE_INPUT_SWITCH = 207;
        /**
         * < 输入开关量告警
         */
        int AlARM_TYPE_INPUT_SWITCH_RESUME = 208;
        /**
         * < 输入开关量告警恢复
         */
        int AlARM_TYPE_SHORT_CIRCUIT = 209;
        /**
         * < 开关量线路短路告警
         */
        int AlARM_TYPE_BREAKER_CIRCUIT = 210;
        /**
         * < 开关量线路断路告警
         */
        int AlARM_TYPE_SHORT_CIRCUIT_RESUME = 211;
        /**
         * < 开关量线路短路告警恢复
         */
        int AlARM_TYPE_STOR_FULL_PRE = 212;
        /**
         * < 存储即将满告警
         */
        int AlARM_TYPE_STOR_FULL = 213;
        /**
         * < 满存储告警
         */
        int AlARM_TYPE_STOR_FAILED = 214;
        /**
         * < 存储读写失败告警
         */
        int AlARM_TYPE_STOR_FAILED_RESUME = 215;
        /**
         * < 存储读写失败告警恢复
         */
        int AlARM_TYPE_DEVICE_ONLINE = 216;
        /**
         * < 设备上线告警
         */
        int AlARM_TYPE_DEVICE_OFFLINE = 217;
        /**
         * < 设备下线告警
         */
        int AlARM_TYPE_BREAKER_CIRCUIT_RESUME = 219;
        /**
         * < 开关量线路断路告警恢复
         */
        int AlARM_TYPE_STREAM_STOR_CAM_WARN = 222;
        /**
         * < 摄像机存储停止告警
         */
        int AlARM_TYPE_EXT_STOR_FULL_PRE = 223;
        /**
         * < 远端存储即将满告警
         */
        int AlARM_TYPE_EXT_STOR_FULL = 224;
        /**
         * < 远端存储满告警
         */
        int AlARM_TYPE_EXT_STOR_FAILED = 225;
        /**
         * < 远端存储读写失败告警
         */
        int AlARM_TYPE_EXT_STOR_FAILED_RESUME = 226;
        /**
         * < 远端存储读写失败告警恢复
         */
        int AlARM_TYPE_STOR_NO_ENOUGH_SPACE = 229;
        /**
         * < 摄像机所在磁盘存储空间不足告警
         */
        int AlARM_TYPE_STOR_DEL_FILE_FAILED = 230;
        /**
         * < 删除老文件失败告警
         */
        int AlARM_TYPE_BEHAVIOR = 231;
        /**
         * < 行为告警
         */
        int AlARM_TYPE_BEHAVIOR_RESUME = 232;
        /**
         * < 行为告警恢复
         */
        int AlARM_TYPE_STREAM_BREAK = 233;
        /**
         * < 摄像机断流告警
         */
        int AlARM_TYPE_SOUND_ABNORMAL = 241;
        /**
         * < 异常声音告警
         */
        int AlARM_TYPE_SOUND_ABNORMAL_RESUME = 242;
        /**
         * < 异常声音告警恢复
         */
        int AlARM_TYPE_CROSS_LINE = 301;
        /**
         * < 触发智能拌线
         */
        int AlARM_TYPE_INTROSION_ZONE = 302;
        /**
         * < 区域入侵
         */
        int AlARM_TYPE_ACCESS_ZONE = 303;
        /**
         * < 进入区域
         */
        int AlARM_TYPE_LEAVE_ZONE = 304;
        /**
         * < 离开区域
         */
        int AlARM_TYPE_HOVER_ZONE = 305;
        /**
         * < 区域徘徊
         */
        int AlARM_TYPE_OVER_FENCE = 306;
        /**
         * < 翻越围栏
         */
        int AlARM_TYPE_CARE_ARTICLE = 307;
        /**
         * < 物品看护
         */
        int AlARM_TYPE_REMAIN_ARTICLE = 308;
        /**
         * < 物品遗留
         */
        /* 手工告警 401~ */
        int AlARM_TYPE_IMPERATIVE_EVENT = 401;
        /**
         * < 紧急告警
         */
        int AlARM_TYPE_NM_PROTECT_EVENT = 800; /**
         * < 跨域N+
         * M保护类告警;
         * 主要用于跨域N+
         * M保护告警订阅;
         * 订阅后相当于订阅了存储失败
         * 、存储停止两个告警
         */
        /* Begin added by baoyihui02795; 2011-04-28 of 卡口项目 */
        /**
         * 卡口业务告警 2001~
         */
        int AlARM_TYPE_DISPOSITION_STOLEN_VEHICLE = 2001;
        /**
         * < 被盗车
         */
        int AlARM_TYPE_DISPOSITION_ROBBED_VEHICLE = 2002;
        /**
         * < 被抢车
         */
        int AlARM_TYPE_DISPOSITION_SUSPICION_VEHICLE = 2003;
        /**
         * < 嫌疑车
         */
        int AlARM_TYPE_DISPOSITION_TRAFFIC_VIOLATION = 2004;
        /**
         * < 交通违法车
         */
        int AlARM_TYPE_DISPOSITION_EMERGENCY_SURVEILLANCE = 2005;
        /**
         * < 紧急查控车
         */
        int AlARM_TYPE_VEHICLE_BLACKLIST = 2006;
        /**
         * < 黑名单
         */
        int AlARM_TYPE_OTHER_VEHICLE_ALARM = 2007;
        /**
         * < 其他车辆违法行为
         */
        int AlARM_TYPE_P2P_SPEED_DETECTION = 2008;
        /**
         * < 区间测速违章
         */
        int AlARM_TYPE_NOT_WHITELIST = 2009;
        /**
         * < 非白名单车辆
         */
        /* End added by baoyihui02795; 2011-04-28 of 卡口项目 */
        int AlARM_TYPE_MAX = 3000;
        /**
         * < 最大值
         */
        int AlARM_TYPE_ALL = 0xFFFE;
        /**
         * < 所有告警的特殊标记
         */
        int AlARM_TYPE_INVALID = 0xFFFF; /** < 无效值 */
    }

    /**
     * 告警严重级别枚举
     */
    interface AlarmSeverityLevelE {
        int AlARM_SEVERITY_CRITICAL = 0;
        /**
         * < 危急
         */
        int AlARM_SEVERITY_MAJOR = 1;
        /**
         * < 主要
         */
        int AlARM_SEVERITY_MINOR = 2;
        /**
         * < 次要
         */
        int AlARM_SEVERITY_WARN = 3;
        /**
         * < 警告
         */
        int AlARM_SEVERITY_INFO = 4;
        /**
         * < 提示
         */
        int AlARM_SEVERITY_MAX = 31;
        /**
         * < 最大值
         */
        int AlARM_SEVERITY_ALL = 0xFFFFFFFE;
        /**
         * < 所有告警级别的特殊标记
         */
        int AlARM_SEVERITY_INVALID = 0xFFFFFFFF; /** < 无效值 */
    }

    interface CallBackProcTypeE {
        int PROC_TYPE_DEV_STATUS = 0;
        /**
         * < 设备状态，对应结构 : AS_STAPUSH_UI_S
         */
        int PROC_TYPE_ALARM = 1;
        /**
         * < 告警，对应结构 : AS_ALARMPUSH_UI_S
         */
        int PROC_TYPE_DEV_CAM_SHEAR = 2;
        /**
         * < 共享摄像机，对应结构 : AS_DEVPUSH_UI_S
         */
        int PROC_TYPE_MONITOR_BE_REAVED = 3;
        /**
         * < 实况被抢占，对应结构 : CS_MONITOR_REAVE_NOTIFY_S
         */
        int PROC_TYPE_SWITCH_BE_REAVED = 4;
        /**
         * < 轮切被抢占，对应结构 : CS_SWITCH_REAVE_NOTIFY_S
         */
        int PROC_TYPE_MONITOR_BE_STOPPED = 5;
        /**
         * < 实况被停止，对应结构 : CS_MONITOR_REAVE_NOTIFY_S
         */
        int PROC_TYPE_SWITCH_BE_STOPPED = 6;
        /**
         * < 轮切被停止，对应结构 : CS_SWITCH_REAVE_NOTIFY_S
         */
        int PROC_TYPE_VOCSRV_BE_REAVED = 7;
        /**
         * < 语音被抢占，对应结构 : CS_VOCSRV_REAVE_NOTIFY_S
         */
        int PROC_TYPE_PTZ_EVENT = 8;
        /**
         * < 云台事件通知，对应结构 : CS_PTZ_REAVE_NOTIFY_S
         */
        int PROC_TYPE_TRB_PROC = 9;
        /**
         * < 故障处理通知，对应结构 : CS_NOTIFY_UI_TRB_EVENT_PROC_S
         */
        int PROC_TYPE_SRV_SETUP = 10;
        /**
         * < 故障恢复业务建立通知，对应结构 : CS_NOTIFY_UI_SRV_SETUP_S
         */
        int PROC_TYPE_XP_ALARM_SETUP = 11;
        /**
         * < 告警联动到XP窗格通知，对应结构 : CS_NOTIFY_UI_SRV_SETUP_S
         */
        int PROC_TYPE_LOGOUT = 12;
        /**
         * < 退出登陆，对应结构 :无
         */
        int PROC_TYPE_MEDIA_PARAM_CHANGE = 13;
        /**
         * < 媒体参数改变，对应结构 : CS_NOTIFY_UI_MEDIA_PARAM_CHANGE_PROC_S
         */
        int PROC_TYPE_EXDOMAIN_STATUS = 14;
        /**
         * < 外域状态，对应结构 : AS_EXDOMAIN_STAPUSH_UI_S
         */
        int PROC_TYPE_BACKUP_DATA_FINISH = 15;
        /**
         * < 信息备份完成通知; 对应结构 : CS_BACKUP_FINISH_INFO_S
         */
        int PROC_TYPE_TL_EVENT = 16;
        /**
         * < 透明通道事件通知，对应结构 : CS_TL_REAVE_NOTIFY_S
         */
        int PROC_TYPE_SALVO_UNIT_EVENT = 17;
        /**
         * < 组显示单元事件通知; 对应结构 : CS_NOTIFY_SALVO_UNIT_EVENT_S
         */
        int PROC_TYPE_SALVO_EVENT = 18;
        /**
         * < 组切业务事件通知; 对应结构 : CS_NOTIFY_UI_SALVO_EVENT_S
         */
        int PROC_TYPE_START_XP_SALVO = 19;
        /**
         * < 通知UI启动组轮巡的组显示; 对应结构: CS_NOTIFY_START_XP_SALVO_S
         */
        int PROC_TYPE_VODWALL_BE_REAVED = 20;
        /**
         * < 通知回放上墙被抢占，对应结构：CS_VODWALL_REAVE_NOTIFY_S
         */
        int PROC_TYPE_VODWALL_BE_STOPPED = 21;
        /**
         * < 通知回放上墙被停止，对应结构：CS_VODWALL_REAVE_NOTIFY_S
         */
        int PROC_TYPE_VOD_BE_REAVED = 22;
        /**
         * < 回放被抢占，对应结构 : CS_VOD_REAVE_NOTIFY_S
         */
        int PROC_TYPE_DOMAIN_SYN_RESULT = 23;
        /**
         * < 域间同步的结果，对应结构 : AS_DOMAIN_SYN_PUSHUI_S
         */
        int PROC_TYPE_VOC_REQ = 24;
        /**
         * < 客户端语音请求，对应结构 : CS_VOC_REQ_NOTIFY_S
         */
        int PROC_TYPE_VOC_STATE_NOTIFY = 25;
        /**
         * < 语音业务状态通知，对应结构 : CS_VOC_STATE_NOTIFY_S
         */
        int PROC_TYPE_PLAN_ALARM_CHG_REPORT = 26;
        /**
         * < 预案告警变化上报，对应结构：PLAN_ALARM_CHG_PUSH_UI_S
         */
        int PROC_TYPE_EVENT_SECURITY_CHG_REPORT = 27;
        /**
         * < 系统级别信息变化上报，对应结构：EVENT_SECURITY_CHG_PUSH_UI_S
         */
        int PROC_TYPE_OSD_NAME_CHANGED = 30;
        /**
         * < 通知人机Preview用户OSD变更，对应结构: AS_NOTIFY_OSD_NAME_UI_S
         */
        int PROC_TYPE_MASK_AREA_CHANGED = 31;
        /**
         * < 通知人机Preview用户遮挡区域变更，对应结构: AS_NOTIFY_EC_MASK_AREA_UI_S
         */
        int PROC_TYPE_PTZ_STATUS_EVENT = 32;
        /**
         * < 云台状态变更通知，对应结构 : CS_PTZ_STATUS_NOTIFY_S
         */
        int PROC_TYPE_DEL_EXDOMAIN_RESULT = 33;
        /**
         * < 删除外域结果，对应结构: AS_DEL_EXDOMAIN_PUSH_UI_S
         */
        /* Added by dengshuhua00673; 2013-02-20 of 自动布局轮巡 */
        int PROC_TYPE_START_XP_AUTOSALVO = 34; /**
         * <
         * 通知UI启动自动布局组轮巡;
         * 对应结构:
         * CS_NOTIFY_START_XP_AUTOSALVO_S
         */
        /**
         * Begin:add by sunxiaojisKF0138; 2013-7-21 of NVRV3R1
         **/
        int PROC_TYPE_GET_CHANNEL_MSG_FROM_CS_TO_UI = 35; /**
         * <
         * 透明通道上行透传消息给第三方
         */
        /**
         * End:add by sunxiaojisKF0138; 2013-7-21 of NVRV3R1
         **/
        /* Begin added by baoyihui02795; 2011-04-28 of 卡口项目 */
        int PROC_TYPE_VEHICLE_DATA = 90;
        /**
         * < 通知实时车辆信息，对应结构:VEHICLE_REAL_TIME_DATA_S
         */
        int PROC_TYPE_VEHICLE_ALARM_DATA = 91;
        /**
         * < 通知实时车辆报警，对应结构:VEHICLE_ALARM_DATA_S
         */
        int PROC_TYPE_GIS_DEV_STATUS = 92;
        /**
         * < 通知GIS设备状态变化，对应结构：DEVICE_GIS_STATUS_DATA_S
         */
        /* End added by baoyihui02795; 2011-04-28 of 卡口项目 */
        int PROC_TYPE_ELEC_BULLETIN_CHANGE = 93; /**
         * <
         * 电子公告变化上报
         * ，对应结构
         * ：
         * ELEC_BULLETIN_PUSH_UI_S
         */
        /*******************************************************************************
         * SS新增定义 新增回调函数
         *******************************************************************************/
        int PROC_TYPE_ACCEPT_SPEAK_YESORNO = 100;
        /**
         * < 发言申请， 对应结构 ：CONF_SITE_INFO_EX_S
         */
        int PROC_TYPE_CONF_STATUS_CHANGE = 101;
        /**
         * < 会议状态改变， 对应结构 ：CONF_STATUS_INFO_EX_S
         * 如果是周期会议且非最后一个周期，上报会议未开始/其它上报会议已经结束
         */
        int PROC_TYPE_DEVICE_CODE_CHANGE = 102;
        /**
         * < 设备编码改变， 对应结构 ：DEVICE_CODE_CHANGE_INFO_EX_S
         */
        int PROC_TYPE_DEVICE_CHANGE = 103;
        /**
         * < 终端设备更新信息， 当存在设备新增、删除时， 上报更新消息， 对应的结构 ：DEVICE_CHANGE_INFO_EX_S
         */
        int PROC_TYPE_MODIFY_TERM = 104;
        /**
         * < 修改终端消息， 对应的结构 ：MODIFY_TERM_REP_EX_S
         */
        int PROC_TYPE_CHAIR_CHANGE = 105;
        /**
         * < 当前主席发生改变， 主席会场释放则会场编码为空。对应的结构 ：CONF_SITE_INFO_EX_S
         */
        int PROC_TYPE_SPEAKER_CHANGE = 106;
        /**
         * < 当前发言人发生改变， 对应的结构 ：CONF_SITE_INFO_EX_S
         */
        int PROC_TYPE_TERM_STATUS_CHANGE = 107;
        /**
         * < 会场终端状态改变， 对应的结构 ：TERM_STATUS_CHANGE_EX_S
         */
        int PROC_TYPE_DELAY_CONF = 108;
        /**
         * < 延迟会议， 对应结构 ：DELAY_CONF_INFO_EX_S
         */
        int PROC_TYPE_SYNCHRONIZE_WITH_WEB = 109;
        /**
         * < 上报广播会场， 主席、主场观看会场 对应的结构 ： MC_SYNCHRONIZE_WITH_WEB_EX_S
         */
        int PROC_TYPE_MCU_BACKUP_CHANGE_TO_MASTER = 110;
        /**
         * < MCU备份通知， 对应结构 ：BACKUP_MCU_REPORT_S
         */
        int PROC_TYPE_SEND_ROLE_SITE_CHANGE = 111;
        /**
         * < 当前辅流发送者变化通知， 对应结构 ：CONF_SEND_ROLE_SITE_CHANGE_S
         */
        int PROC_TYPE_AUTOMULTIPIC_CHANGE = 112;
        /**
         * < 多画面自动切换值改变通知， 对应结构 ：CONF_AUTOMULTIPIC_CHANGE_S
         */
        int PROC_TYPE_SET_TURN_BROADCAST_CHANGE = 113;
        /**
         * < 设置画面轮询模式改变通知， 对应结构 ：CONF_SET_TURN_BROADCAST_CHANGE_S
         */
        int PROC_TYPE_SET_PIC_MODE_CHANGE = 114;
        /**
         * < 设置画面模式改变通知， 对应结构 ：CONF_SET_PIC_MODE_CHANGE_S
         */
        int PROC_TYPE_MCU_SYNC_STATUS_CHANGE = 115;
        /**
         * < MCU同步状态改变通知， 对应结构 ：MCU_SYNC_STATUS_CHANGE_S
         */
        int PROC_TYPE_CUR_BROADCAST_CHANGE = 116;
        /**
         * < 当前实际广播会场改变通知，对应结构：CUR_BROADCAST_INFO_EX_S
         */
        int PROC_TYPE_CUR_CHAIR_BROWSE_CHANGE = 117;
        /**
         * < 当前主席或主场实际观看的会场改变通知，对应结构：CUR_CHAIR_BROWSE_INFO_EX_S
         */
        int PROC_TYPE_CONF_FECC_CHANGE = 118;
        /**
         * < 当前FECC控制者或被控者变化通知，对应结构：CONF_FECC_CHANGE_S
         */
        int PROC_TYPE_CONF_MCU_BACKUP_CHANGE = 119;
        /**
         * < 当前会议中MCU备份变化通知，对应结构：CONF_MCU_BACKUP_CHANGE_S
         */
        int PROC_TYPE_CALL_SITE_RESULT = 120;
        /**
         * < 呼叫会场结果通知，对应结构：CALL_SITE_INFO_EX_S
         */
        int PROC_TYPE_GK_REG_STATE = 121;
        /**
         * < GK注册结果通知，对应结构：GK_REG_STATE_INFO_EX_S
         */
        int PROC_TYPE_MG_SESSION_STATUS_CHANGE = 122;
        /**
         * < 终端会话状态，对应结构：MG_SESSION_STATUS_EX_S
         */
        int PROC_TYPE_FREE_STORE_RES_SUCCEED = 123;
        /**
         * < 存储资源被释放，对应结构 : FREE_STORE_RES_SUCCEED_S
         */
        int PROC_TYPE_MEDIA_STATUS_NOTIFY = 124;
        /**
         * < 媒体状态通知消息，对应结构 : MEDIA_STATUS_NOTIFY_S
         */
        /* Begin added by liuzhikun/01420; 2013-11-12 for 告警联动到语音对讲 */
        int PROC_TYPE_ALARM_LINKAGE_VOCTALK = 125;
        /**
         * < 告警联动到语音对讲通知，对应结构 : ALARM_LINKAGE_VOCTALK_TO_UI_S
         */
        /* End added by liuzhikun/01420; 2013-11-12 for 告警联动到语音对讲 */
        /* ECR对应的回调函数，从400开始 */
        int PROC_TYPE_MMI_VOUT_INFO_CHANGE = 400;
        /**
         * <人机组切输出端口基本信息改变.对应结构体MMI_VOUT_INFO_FOR_ECR_S
         */
        int PROC_TYPE_MMI_VOUT_WINLIST_CHANGE = 401;
        /**
         * <人机组切预览窗格摄像机序列信息改变; 对应结构体: MMI_VOUT_WINLIST_INFO_FOR_ECR_S
         */
        int PROC_TYPE_VIRTUAL_CHANNEL_STATUS_CHANGE = 402;
        /**
         * <虚拟通道基本信息改变，对应结构体VIRTUAL_CHANNEL_BIND_STATUS_S
         */
        /* Begin: Added by chenyongfa; 2013-05-03 of IVSD00832 */
        int PROC_TYPE_VIRTUAL_CHANNEL_INFO_CHANGE = 403;
        /**
         * <虚拟通道分辨率/帧率改变，对应结构体VIRTUAL_CHANNEL_BIND_STATUS_S
         */
        /* End: Added by chenyongfa; 2013-05-03 of IVSD00832 */
        /* Begin: Added by mozhanfei(kf0149); 2013-11-15 for lock record */
        int PROC_TYPE_LOCK_SPACE_NOTIFY = 404;
        /**
         * < 检查锁定空间通知消息，对应结构 : AS_SM_LOCK_SPACE_NOTIFY_S
         */
        int PROC_TYPE_LOCK_FAILURE_NOTIFY = 405;
        /**
         * < 摄像机上线重下发通知消息，对应结构 : AS_SM_LOCK_FAILURE_NOTIFY_S
         */
        /* End: Added by mozhanfei(kf0149); 2013-11-15 for lock record */
        int PROC_TYPE_MAX = 406;
        /**
         * < 回调函数处理信息类型最大值
         */
        int PROC_TYPE_INVALID = 0xFFFFFFFF; /** < 无效值 */

    }

    /**
     * @enum tagLogicFlag
     * @brief 复杂查询条件约束中的逻辑关系定义
     * @attention 无
     */
    interface LOGIC_FLAG_E {
        int EQUAL_FLAG = 0, /**
         * < 等于
         */
        GREAT_FLAG = 1, /**
         * < 大于
         */
        LITTLE_FLAG = 2, /**
         * < 小于
         */
        GEQUAL_FLAG = 3, /**
         * < 大于等于
         */
        LEQUAL_FLAG = 4, /**
         * < 小于等于
         */
        LIKE_FLAG = 5, /**
         * < 模糊查询
         */
        ASCEND_FLAG = 6, /**
         * < 升序
         */
        DESCEND_FLAG = 7, /**
         * < 降序
         */
        NEQUAL_FLAG = 8, /**
         * < 不等于
         */
        NLIKE_FLAG = 13, /**
         * < NOT LIKE
         */
        LOGIC_FLAG_MAX = Integer.MAX_VALUE; /** < 无效值 */
    }

    interface QUERY_TYPE_E {
        int CODE_TYPE = 0, /**
         * < 编码类型(除用户编码之外)
         */
        NAME_TYPE = 1, /**
         * < 名称类型(除用户名称之外)
         */
        USER_CODE_TYPE = 2, /**
         * < 用户编码类型
         */
        USER_NAME_TYPE = 3, /**
         * < 用户名称类型
         */
        TIME_TYPE = 4, /**
         * < 时间类型
         */

        EVENT_TYPE = 5, /**
         * < 告警事件类型,取值为#AlARM_TYPE_E
         */
        EVENT_SECURITY = 6, /**
         * < 告警事件级别,取值为#ALARM_SEVERITY_LEVEL_E
         */
        EVENT_STATUS_TYPE = 7, /**
         * < 告警状态,取值为#ALARM_STATUS_E
         */
        EVENT_TIME = 8, /**
         * < 告警时间
         */

        DEV_SUB_TYPE = 9, /**
         * < 设备子类型
         */

        INDEX_TYPE = 10, /**
         * < 索引类型(如视频输入通道索引,视频输出通道索引,串口索引,开关量索引)
         */

        RES_SUB_TYPE = 11, /**
         * < 资源子类型
         */

        /* Begin: Add by x06948 for VVD38087, 20100115 */
        SRV_TYPE = 12, /**
         * < 业务类型
         */
        MONITOR_TYPE = 13, /**
         * < 监视器类型
         */
        MONITOR_NAME = 14, /**
         * < 监视器名称
         */
        MONITOR_DOMAIN = 15, /**
         * < 监视器所在域
         */
        CAMERA_NAME = 16, /**
         * < 摄像机名称
         */
        USER_LOGIN_IP = 17, /**
         * < 用户登录IP
         */
        MON_SRV_STATUS = 18, /**
         * < 实况状态
         */
        VOCBRD_SRV_STATUS = 19, /**
         * < 广播状态
         */
        /* End: Add by x06948 for VVD38087, 20100115 */
        // RES_TYPE = 20, /**< 资源类型 */

        CASE_DESC = 20, /**
         * < 案例描述
         */
        TASK_STATUS = 21, /**
         * < 任务状态
         */
        TASK_SUB_TIME = 22, /**
         * < 任务提交时间
         */
        TASK_END_TIME = 23, /**
         * < 任务结束时间
         */
        BAK_START_TIME = 24, /**
         * < 备份开始时间
         */
        BAK_END_TIME = 25, /**
         * < 备份结束时间
         */
        FILE_CREATE_TIME = 26, /**
         * < 文件创建时间
         */
        FILE_CAPACITY = 27, /**
         * < 文件容量
         */
        FILE_TYPE = 28, /**
         * < 文件类型
         */
        FILE_LOCK_FLAG = 29, /**
         * < 文件锁定标识
         */
        LAYOUT_TYPE = 30, /**
         * < 布局类型，取值为#LAYOUT_TYPE_E
         */

        PHY_DEV_IP = 31,

        ASSET_TYPE = 32, /**
         * < 资产类型，取值为#ASSET_TYPE_E
         */
        ASSET_MODEL = 33, /**
         * < 资产型号
         */
        ASSET_MANUFACTURE = 34, /**
         * < 资产厂商
         */
        ASSET_STATUS = 35, /**
         * < 资产状态，取值为#ASSET_STATUS_E
         */
        ASSET_PURCHASE_TIME = 36, /**
         * < 资产采购时间
         */
        ASSET_WARRANT_TIME = 37, /**
         * < 资产保修时间
         */
        ASSET_INSTALL_TIME = 38, /**
         * < 资产安装时间
         */
        ASSET_INSTALL_LOCATION = 39, /**
         * < 资产安装地点
         */
        ASSET_PRODEALER = 40, /**
         * < 资产工程商
         */
        FAULT_STAT_TIME = 41, /**
         * < 故障统计时间
         */
        FAULT_TYPE = 42, /**
         * < 故障类型
         */
        FAULT_RECO_TIME = 43, /**
         * < 故障恢复时间
         */
        FAULT_INTERVAL = 44, /**
         * < 故障时长
         */
        FAULT_COUNT = 45, /**
         * < 故障次数
         */

        PLATE_CODE = 46, /**
         * < 车牌号码
         */
        STUFF_TYPE = 47, /**
         * < 涉案物品类型
         */
        STUFF_PROPERTY = 48, /**
         * < 涉案物品性质
         */
        SERIESCASE_TYPE = 49, /**
         * < 串并案类型
         */
        CASEINSE_CODE = 50, /**
         * < 串并案中案件编号
         */
        CASESHARE_TYPE = 51, /**
         * < 案件共享类型
         */
        CASE_PROPERTY = 52, /**
         * < 案件性质
         */
        CASE_TYPE = 53, /**
         * < 案件类型
         */
        CASE_STATUS = 54, /**
         * < 案件状态
         */
        POLICE_INTSRC = 55, /**
         * < 案件警情来源
         */
        CASE_BEGIN_TIME = 56, /**
         * < 案件开始时间
         */
        CASE_END_TIME = 57, /**
         * < 案件结束时间
         */
        STAT_START_TIME = 58, /**
         * < 统计开始时间
         */
        STAT_END_TIME = 59, /**
         * < 统计结束时间
         */
        EBULLETIN_EXPIRE_FLAG = 60, /**
         * < 电子公告过期标志
         */
        CASE_DATA_TYPE = 61, /**
         * < 案件资料类型
         */
        CASE_SOLVED_TIME = 63, /**
         * < 案件破案时间
         */
        CASE_CLOSED_TIME = 64, /**
         * < 案件结案时间
         */
        CASE_UPLOAD_TIME = 65, /**
         * < 案件资料上传时间
         */
        CASE_CREATE_TIME = 66, /**
         * < 案件创建时间
         */
        DEPT_CODE = 67, /**
         * < 部门编码
         */
        ACTION_TYPE = 68, /**
         * < 动作类型,取值为#ACTION_TYPE_E
         */

        DOMAIN_TYPE = 100, /**
         * < 域类型,现只支持本外域
         */

        EXT_DOMAIN_TPYE = 200, /**
         * < 外域类型:上/下/平级域
         */
        EXT_DOMAIN_IP = 201, /**
         * < 外域IP
         */
        EXT_DOMAIN_PORT = 202, /**
         * < 外域PORT
         */
        EXT_DOMAIN_TRUNK_NUM = 203, /**
         * < 外域干线数量
         */
        EXT_DOMAIN_MULTICAST = 204, /**
         * < 域间组播策略
         */
        EXT_DOMAIN_SESSION = 205, /**
         * < 外域引流标志
         */
        EXT_DOMAIN_SUBTYPE = 206, /**
         * < 外域子类型
         */

        JOB_STATUS = 210, /**
         * < 升级任务状态
         */
        JOB_CREATOR = 211, /**
         * < 升级任务创建者
         */
        JOB_EXEC_TIME = 212, /**
         * < 升级任务调度时间
         */
        JOB_ESTB_TIME = 213, /**
         * < 升级任务制定时间
         */
        JOB_END_TIME = 214, /**
         * < 升级任务完成时间
         */
        JOB_RESULT = 215, /**
         * < 升级结果
         */

        OPER_TIME = 220, /**
         * < 操作时间
         */
        OPER_IP = 221, /**
         * < 操作者IP地址
         */
        OPER_TYPE = 222, /**
         * < 操作类型
         */
        OPER_RESULT = 223, /**
         * < 操作结果
         */
        OPER_SERVICE_TYPE = 224, /**
         * < 操作的业务类型
         */
        OPER_OBJ = 225, /**
         * < 操作对象
         */

        LABEL_TIME = 230, /**
         * < 标签时间点
         */
        REC_START_TIME = 231, /**
         * < 标签录像开始时间，格式为"hh:mm:ss"
         */
        REC_END_TIME = 232, /**
         * < 标签录像结束时间，格式为"hh:mm:ss"
         */

        USER_FULL_NAME = 240, /**
         * < 用户全名
         */
        USER_TEL_PHONE = 241, /**
         * < 用户座机电话
         */
        USER_MOBILE_PHONE = 242, /**
         * < 用户移动电话
         */
        USER_EMAIL = 243, /**
         * < 用户电子邮件
         */
        USER_IS_LOCKED = 244, /**
         * < 用户是否被锁定
         */

        USER_DESC = 245, /**
         * < 用户描述
         */

        ROLE_PRIORITY = 250, /**
         * < 角色优先级
         */

        DEV_TYPE = 255, /**
         * < 设备类型
         */
        RES_TYPE = 256, /**
         * < 资源类型
         */
        IS_QUERY_SUB = 257, /**
         * < 是否查下级(需要调AS_CON_Parse进行解析)
         */
        RES_ID = 258, /**
         * < 资源ID
         */
        SUPPORT_LINK = 259, /**
         * < 是否支持联动
         */
        SUPPORT_GUARD = 260, /**
         * < 是否支持布防
         */
        RES_ATTRIBUTE = 261, /**
         * < 资源属性
         */
        IS_QUERY_ENCODESET = 262, /**
         * < 是否查询摄像机或者监视器所在设备的流套餐，
         * 对应szQueryData为0-不查询，1-查询
         */

        TYPE_ACTION_PLAN = 263, /**
         * < 预案类型
         */
        IS_PLAN_ALARM = 264, /**
         * < 是否预案告警
         */
        IS_ONCE_PLAN_ALARM = 265, /**
         * < 是否启动过预案
         */
        IS_MISINFORM = 266, /**
         * < 是否误报
         */
        CHK_USER_NAME_TYPE = 267, /**
         * < 核警用户名
         */
        TRIGGER_ID = 268, /**
         * < 触发器ID
         */

        IS_HIDE_EMPTY_ORG = 269, /**
         * < 是否隐藏空组织
         */
        IS_QUERY_SHARED = 270, /**
         * < 是查询已共享资源=1还是查未共享资源=0
         */

        IS_LEACH_SHARED_BELONG = 271, /**
         * <
         * 是否过滤掉因为资源共享给外域而在资源表中生成的划归记录(
         * 需要调AS_CON_Parse进行解析)
         */
        RESULT_CODE = 272, /**
         * < 结果码
         */
        RES_ORDER_NUMBER = 273, /**
         * < 资源排序序号
         */

        AUTOID = 273, /**
         * < 主键
         */

        EVENT_TYPE_NAME = 273, /**
         * < 事件类型名称
         */

        IS_QUERY_SYSTEM_EVENT_TYPE = 274, /**
         * < 0-查询全部;1-查询系统预定义;2-
         * 查询用户自定义
         */

        IS_SUPPORT_BISTORE_CAM = 275, /**
         * < 是否增加支持双直存的外域摄像机过滤条件
         */

        RES_STATUS_CONDITON = 276, /**
         * < 资源状态查询条件
         */
        DM_CODE = 277, /**
         * < DM编码
         */ /*
         * Add by zhouquanwei/z01364 for
         * 分布式PAG——SDK接口
         */

        CONF_START_TIME = 300, /**
         * < 会议开始时间，1970年以来的秒数
         */
        CONF_END_TIME = 301, /**
         * < 会议结束时间，1970年以来的秒数
         */

        STORE_DEV_NAME = 302, /**
         * < 存储设备名称
         */
        DM_NAME = 303, /**
         * < 数据管理服务器名称
         */
        RES_BELONGIN = 304, /**
         * < 资源归属,0代表原始加入#
         * MM_RESOURCE_BELONGIN_ORIGINAL，1代表划归过来#
         * MM_RESOURCE_BELONGIN_TRANSFER
         */
        IS_CASE_SERVER = 310, /**
         * < 是否案件备份管理服务器
         */
        BAK_SERVICE_TYPE = 311, /**
         * < 备份业务类型
         */
        BAK_RES_SERVICE_TYPE = 312, /**
         * < 备份资源业务类型
         */
        DOMAIN_CODE = 350, /**
         * < 域编码
         */
        TOLLGATE_CODE = 351, /**
         * < 卡口编号
         */
        TOLLGATE_NAME = 352, /**
         * < 卡口名称
         */
        TOLLGATE_CAMERA_CODE = 353, /**
         * < 卡口相机编码
         */
        LANE_NUMBER = 354, /**
         * < 车道编号
         */
        LANE_DIRECTION = 355, /**
         * < 车道方向编号
         */
        PASS_TIME = 356, /**
         * < 通过时间
         */
        VEHICLE_LICENSE_PLATE = 357, /**
         * < 号牌号码
         */
        VEHICLE_LICENSE_PLATE_TYPE = 358, /**
         * < 号牌种类
         */
        VEHICLE_LICENSE_PLATE_COLOR = 359, /**
         * < 号牌颜色
         */
        SPEED_TYPE = 360, /**
         * < 速度
         */
        LIMIT_SPEED = 361, /**
         * < 限速
         */
        VEHICLE_LOGO = 362, /**
         * < 车辆品牌
         */
        VEHICLE_TYPE = 363, /**
         * < 车辆类型
         */
        VEHICLE_COLOR_DEPTH = 364, /**
         * < 车身颜色深浅
         */
        VEHICLE_COLOR = 365, /**
         * < 车身颜色
         */
        VEHICLE_IDENTIFY_STATUS = 366, /**
         * < 识别状态
         */
        VEHICLE_STATUS = 367, /**
         * < 行驶状态
         */
        VEHICLE_DEAL_STATUS = 368, /**
         * < 车辆处理标记
         */
        DISPOSITION_CODE = 369, /**
         * < 布控编号
         */
        DISPOSITION_TYPE = 370, /**
         * < 布控类别
         */
        DISPOSITION_DEPT = 371, /**
         * < 布控单位
         */
        DISPOSITION_USER = 372, /**
         * < 布控人员
         */
        DISPOSITION_STATUS = 373, /**
         * < 布控状态
         */
        DISPOSITION_UNDO_DEPT = 374, /**
         * < 撤控单位
         */
        DISPOSITION_UNDO_USER = 375, /**
         * < 撤控人员
         */
        PRIORITY_TYPE = 376, /**
         * < 优先级
         */
        ALARM_TYPE = 377, /**
         * < 告警类型
         */
        PLATE_ANALYSE_STATUS = 378, /**
         * < 套牌分析状态
         */
        SECTION_CODE = 379, /**
         * < 测速区间编号
         */
        SECTION_NAME = 380, /**
         * < 测速区间名称
         */
        TOLLGATE_CODE_IN = 381, /**
         * < 驶入卡口
         */
        TOLLGATE_CODE_OUT = 382, /**
         * < 驶出卡口
         */
        VEHICLE_DATA_TYPE = 383, /**
         * < 过车数据类型
         */
        PASS_TIME2 = 384, /**
         * < 通过时间2
         */
        DISPOSITION_RESULT = 385, /**
         * < 布控处理结果
         */
        EXT_DOMAIN_PROTOCOL_TYPE = 386, /**
         * < 域间通讯协议类型
         */
        DISTANCE_RANGE = 387, /**
         * < 距离范围
         */
        DEFAULT_WEBGIS_MAP = 388, /**
         * < 默认WebGis地图
         */
        DEFAULT_WEBGIS_POINT = 389, /**
         * < 默认WebGis地图关注点
         */
        STAT_TIME = 390, /**
         * < 统计时间
         */

        PLACE_CODE = 501, /**
         * < 违章地点编码
         */
        EQUIPMENT_TYPE = 502, /**
         * < 采集类型
         */
        ABNORMAL_ANALYSE_STATUS = 503, /**
         * < 异常行为分析状态
         */
        COUNT_TYPE = 504, /**
         * < 次数
         */
        RESTRICT_TYPE = 505, /**
         * < 限行方式
         */
        VEHICLE_DATA_CODE = 506, /**
         * < 车辆信息编号
         */
        COMBINE_FLAG = 507, /**
         * < 图片合成标识
         */

        PROTOCOL_ID = 508, /**
         * < 协议类型
         */
        PROTOCOL_DESC = 509, /**
         * < 协议描述
         */
        IS_SUPPORT = 510, /**
         * < 是否支持该协议
         */
        IS_DEFAULT_SG = 511, /**
         * < 是否默认SG支持的协议
         */
        SG_CODE = 512, /**
         * < SG编码
         */

        /* Begin: Added by luhaitao/01337, 2015-06-15 for ONVIF接NVR */
        PARENT_CODE_TYPE = 513, /**
         * < 父设备编码类型
         */
        /* End: Added by luhaitao/01337, 2015-06-15 for ONVIF接NVR */

        /* Begin add by l01420, 2014-7-31 for MPPD14821 */
        LOG_DESC = 515, /**
         * < 日志描述
         */
        /* End add by l01420, 2014-7-31 for MPPD14821 */

        /*
         * Begin Add By hexiaojun/hW0959 for 摄像机云台控制是否经过云台控制器 2015-2-10
         */
        IS_PASS_PTZ = 516, /**
         * < 云台摄像机云台控制是否经过云台控制器
         */
        /* End Add By hexiaojun/hW0959 for 摄像机云台控制是否经过云台控制器 2015-2-10 */
        VEHICLE_LINE = 517, /**
         * < 车系
         */
        VEHICLE_YEAR = 518, /**
         * < 车辆生产年份
         */
        VEHICLE_BRAND = 519, /**
         * < 车标
         */

        TVWALL_CODE = 520, /**
         * < 电视墙编码
         */
        TVWALL_SCENE_ID = 521, /**
         * < 电视墙场景ID
         */
        TVWALL_ORG_CODE = 522, /**
         * < 组织域编码
         */
        /* add by y02360 bugid = 29678 */
        TOLLGATE_INOUTCITY = 523, /**
         * < 卡口进出城
         */
        /*
         * Begin: Added by zhouquanwei/z01364, 2015-05-11 for CDS 独立部署
         */
        BM_CODE = 560, /**
         * < BM编码
         */
        DEV_ONLINE_STATE = 561, /**
         * < 设备在线状态
         */
        GROUP_ID = 562, /**
         * < 分组ID
         */
        ACCOUNT_ID = 563, /**
         * < 账户ID
         */
        /* End: Added by zhouquanwei/z01364, 2015-05-11 for CDS 独立部署 */

        /*
         * Begin added by liangchao, 2015-11-04 for MPPD30081 根据CDV名称查找
         */
        CDV_NAME = 564, /**
         * < CDV名称
         */
        CDV_CODE = 565, /**
         * < CDV编码
         */
        CDV_ID = 567, /**
         * < CDV ID
         */
        CDV_ADDR = 568, /**
         * < CDV地址
         */
        /* End added by liangchao, 2015-11-04 for MPPD30081 根据CDV名称查找 */
        QUERY_TYPE_MAX = Integer.MAX_VALUE; /** < 无效值 */
    }

    interface ZDL_TYPE_E {
        int ZDL_TYPE_ORG = 1, /**
         * < 组织域
         */
        ZDL_TYPE_OUTER_DOMAIN = 2, /**
         * < 外域
         */
        ZDL_TYPE_LOCAL_DOMAIN = 3, /**
         * < 本域
         */

        ZDL_TYPE_DEVICE_MIN_VALUE = 10, /**
         * < 设备资源类型最小值
         */

        ZDL_TYPE_DM = 11, /**
         * < DM
         */
        ZDL_TYPE_MS = 12, /**
         * < MS
         */
        ZDL_TYPE_VX500 = 13, /**
         * < VX500
         */
        ZDL_TYPE_MONITOR = 14, /**
         * < 监视器
         */

        ZDL_TYPE_EC = 15, /**
         * < EC
         */
        ZDL_TYPE_DC = 16, /**
         * < DC
         */

        ZDL_TYPE_GENERAL = 17, /**
         * < 通用设备
         */
        ZDL_TYPE_ECR = 18, /**
         * < ECR
         */

        ZDL_TYPE_TS = 19, /**
         * < TS
         */
        ZDL_TYPE_TMS = 30, /**
         * < 交通媒体交换服务器
         */
        ZDL_TYPE_TOLLGATE = 31, /**
         * < 卡口
         */
        ZDL_TYPE_DR = 32, /**
         * < 数据搜索服务器
         */
        ZDL_TYPE_MAPM = 33, /**
         * < 地图服务器
         */
        ZDL_TYPE_IAHR = 34, /**
         * < 智能人脸卡口服务器
         */

        /* Begin Added by shendongchun 00400 2014-02-26 for 大数据服务器增加 */
        ZDL_TYPE_DB8500 = 40, /**
         * < 数据存储服务器 - DB8500
         */
        ZDL_TYPE_DB9500 = 41, /**
         * < 数据存储服务器 - DB9500
         */
        /* End Added by shendongchun 00400 2014-02-26 for 大数据服务器增加 */

        ZDL_TYPE_MCU = 201, /**
         * < MCU
         */
        ZDL_TYPE_MG = 202, /**
         * < MG
         */

        ZDL_TYPE_CAMERA = 1001, /**
         * < 摄像机
         */
        ZDL_TYPE_TOLLGATE_CAMERA = 1002, /**
         * < 卡口相机
         */
        ZDL_TYPE_ALARM_SOURCE = 1003, /**
         * < 告警源
         */

        ZDL_TYPE_STORAGE_DEV = 1004, /**
         * < 存储设备
         */
        ZDL_TYPE_TRANS_CHANNEL = 1005, /**
         * < 透明通道
         */

        ZDL_TYPE_ALARM_OUTPUT = 1200, /**
         * < 告警输出
         */

        ZDL_TYPE_BM = 1300, /**
         * < BM
         */

        ZDL_TYPE_SEMAPHORE_OUTPUT = 1400, /**
         * <开关量输出
         */

        ZDL_TYPE_FLASHLIGHT = 1999, /**
         * < 闪光灯
         */
        ZDL_TYPE_DEVICE_MAX_VALUE = 2000, /**
         * < 设备资源类型最大值
         */

        ZDL_TYPE_GUARD_TOUR_RESOURCE = 2001, /**
         * < 轮切资源
         */
        ZDL_TYPE_GUARD_TOUR_PLAN = 2002, /**
         * < 轮切计划
         */
        ZDL_TYPE_MAP = 2003, /**
         * < 地图
         */

        ZDL_TYPE_XP = 2005, /**
         * < XP
         */
        ZDL_TYPE_XP_WIN = 2006, /**
         * < XP窗格
         */
        ZDL_TYPE_GUARD_PLAN = 2007, /**
         * < 布防计划
         */

        ZDL_TYPE_DEV_ALL = 2008, /**
         * < 所有的设备类型(EC/DC/MS/DM/VX500/摄像头/监视器)
         */

        ZDL_TYPE_TV_WALL = 3001, /**
         * < 电视墙
         */

        ZDL_TYPE_CAMERA_GROUP = 3002, /**
         * < 摄像机组
         */
        ZDL_TYPE_MONITOR_GROUP = 3003, /**
         * < 监视器组
         */
        ZDL_TYPE_SALVO_RESOURCE = 3004, /**
         * < 组显示资源
         */
        ZDL_TYPE_BROADCAST_GROUP = 3005, /**
         * < 广播组
         */
        ZDL_TYPE_IMAGE_MOSAIC = 3006, /**
         * < 图像拼接资源
         */
        ZDL_TYPE_BALLLINKAGE_GROUP = 3007, /**
         * < 枪球联动组资源
         */
        ZDL_TYPE_GROUP_SWITCH_RESOURCE = 3010, /**
         * < 组轮巡资源
         */
        ZDL_TYPE_GROUP_SWITCH_PLAN = 3011, /**
         * < 组轮巡计划资源
         */
        /* Begin Added by dengshuhua00673, 2012-12-14 of 自动布局轮巡 */
        ZDL_TYPE_AUTO_SWITCH_RESOURCE = 3012, /**
         * < 自动布局轮巡资源
         */
        ZDL_TYPE_GROUP_SWITCH_RESOURCE_BOTH = 3013, /**
         * < 两种(自动、组显示)轮巡资源
         */
        /* End Added by dengshuhua00673, 2012-12-14 of 自动布局轮巡 */

        ZDL_TYPE_SCENE = 3015, /**
         * < 场景资源(参见DAO宏定义#DAO_RES_AGG_TYPE_SCENE,如有改动，必须同步)
         */

        ZDL_TYPE_ACTION_PLAN = 3016, /**
         * < 预案资源
         */

        ZDL_TYPE_TRUNK = 3050, /**
         * < 干线
         */

        ZDL_TYPE_CONFERENCE = 4001, /**
         * < 会议资源
         */

        ZDL_TYPE_USER = 5001, /**
         * < 用户资源
         */

        /* Begin Added by zhudingjingKF0104, 2013-06-19 of 语音资源化 */
        ZDL_TYPE_MICROPHONE = 8001, /**
         * < 语音对讲资源
         */
        ZDL_TYPE_SPEAKER = 8002, /**
         * < 语音广播资源
         */

        ZDL_TYPE_AUDIO_INPUT = 8003, /**
         * < 独立音频输入
         */
        ZDL_TYPE_AUDIO_OUTPUT = 8004, /**
         * < 独立音频输出
         */
        /* End Added by zhudingjingKF0104, 2013-06-19 of 语音资源化 */

        ZDL_TYPE_MAX = Integer.MAX_VALUE;
    }

    interface XP_PROTOCOL_E {
        int XP_PROTOCOL_UDP = 0, /**
         * < UDP协议
         */
        XP_PROTOCOL_TCP = 1, /**
         * < TCP协议Client端
         */
        XP_PROTOCOL_TCP_SERVER = 2;             /**< TCP协议Server端*/
    }


    interface XP_DOWN_MEDIA_SPEED_E {
        int
                XP_DOWN_MEDIA_SPEED_ONE = 0, /**
         * < 一倍速下载媒体文件
         */
        XP_DOWN_MEDIA_SPEED_TWO = 1, /**
         * < 二倍速下载媒体文件
         */
        XP_DOWN_MEDIA_SPEED_FOUR = 2, /**
         * < 四倍速下载媒体文件
         */
        XP_DOWN_MEDIA_SPEED_EIGHT = 3;          /**< 八倍速下载媒体文件 */
    }

    interface XP_MEDIA_FILE_FORMAT_E {
        int
                XP_MEDIA_FILE_TS = 0, /**
         * < TS格式的媒体文件
         */
        XP_MEDIA_FILE_FLV = 1, /**
         * < FLV格式的媒体文件
         */
        XP_MEDIA_FILE_AVI = 2, /**
         * < AVI格式的媒体文件
         */
        XP_MEDIA_FILE_MP4 = 3, /**
         * < MP4格式的媒体文件
         */
        XP_MEDIA_FILE_WMV = 4, /**
         * < MP4格式的媒体文件
         */
        XP_MEDIA_FILE_MKV = 5, /**
         * < MKV格式的媒体文件
         */
        XP_MEDIA_FILE_ASF = 6, /**
         * < ASF格式的媒体文件
         */
        XP_MEDIA_FILE_M4V = 7, /**
         * < M4V格式
         */
        XP_MEDIA_FILE_H264 = 8, /**
         * < H264裸码流格式
         */
        XP_MEDIA_FILE_MPEG = 9, /**
         * < MPEG裸码流格式
         */

        XP_MEDIA_FILE_H3C_PRIVATE = 100,        /* H3C V1私有格式 */
                XP_MEDIA_FILE_HIK_PRIVATE = 101,        /* 海康私有格式 */
                XP_MEDIA_FILE_DAHUA_PRIVATE = 102,      /* 大华私有格式 */
                XP_MEDIA_FILE_MOBOTIX_PRIVATE = 103,    /* mobotix私有格式 */
                XP_MEDIA_FILE_NANZI_PRIVATE = 104,      /* 南自私有格式 */
                XP_MEDIA_FILE_RM_PRIVATE = 105,         /* 锐明私有格式 */
                XP_MEDIA_FILE_HANBANG_PRIVATE = 106,    /* 汉邦私有格式 */
                XP_MEDIA_FILE_CHENGFENG_PRIVATE = 107,  /* 诚丰私有格式 */

        XP_MEDIA_FILE_UNKNOWN = 0XFFFFFFFF;
    }

    enum loglevel {

        DEBUG,
        INFO,
        WARN,
        ERROR,
        FATAL,
    }

    enum QUERY_CON_TYPE {
        ZDL_CON,
        COM_CON,
    }

    int ZDL_ZDL_QUERY_ITEM_MAX_NUM = 64,
            SDK_ZDL_MAX_ITEM_NUM = 200,
            SDK_ZDL_IA_MAX_ITEM_NUM = 10;

    /**
     * SPS人脸告警类型标识
     */
    int ZDL_SEND_NOTIFY_BASE_CMDID = 0,
            NOTIFYTO_FACE_ALARM_INFO = ZDL_SEND_NOTIFY_BASE_CMDID + 34,
            NOTIFYTO_FACE_SNAP_INFO = ZDL_SEND_NOTIFY_BASE_CMDID + 35;

    /**
     * 告警类型
     */
    int COM_ALARM = 0,
            FACE_GUARD = 1,
            FACE_SNAP = 2;
}

