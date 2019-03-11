package com.zdl.code.jna;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * Created by user on 2016/7/9.
 */
public interface SDKFunction extends Library {

    SDKFunction INSTANCE = (SDKFunction) Native.loadLibrary(Platform.isWindows() ? "is_sdk" : "sdk",
            SDKFunction.class);

    interface CALL_BACK_ALARM_PROC_PF extends Callback {
        void invoke(SDKStructure.EVENT_RECORD_V2_S pstEventRecord);
    }

    /**
     * Restful初始化函数 \n
     *
     * @param [IN] CHAR    szServerAdd[IMOS_IPADDR_LEN] 服务器IP
     * @param [IN] CALL_BACK_ALARM_PROC_PF pfnCallBackAlarmProc 告警回调函数
     * @param [IN] SPS_CALL_BACK_ALARM_PROC_PF pfnSpsCallBackAlarmProc SPS告警回调函数
     * @return ULONG_32    返回如下结果:
     * - 成功：ERR_COMMON_SUCCEED
     * - 失败：
     * - 	返回操作结果码，见错误码文件。
     * @note 无
     */
    int ZDL_InitRestful
    (
            String szServerAdd,
            CALL_BACK_ALARM_PROC_PF pfnCallBackAlarmProc,
            SPSFunction.SPS_CALL_BACK_ALARM_PROC_PF pfnSpsCallBackAlarmProc
    );

    /**
     * 增加用户
     *
     * @param [IN] pstUserLoginIDInfo 用户登录ID信息标识。
     * @param [IN] szOrgCode          组织编码
     * @param [IN] pstUserPasswordInfo  用户信息
     * @return 返回如下错误码：
     * -
     * @note - 1、此信息中包含用户编码，是用户唯一标识
     */
    int ZDL_AddUser
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLoginIDInfo,
            byte[] szOrgCode,
            SDKStructure.USER_INFO_PASSWORD_S pstUserPasswordInfo
    );

    /**
     * 删除用户
     *
     * @param [IN] pstUserLoginIDInfo 用户登录ID信息标识。
     * @param [IN] szUserCode 用户编码
     * @return 返回如下错误码：
     * -
     * @note - 1、
     */
    int ZDL_DelUser
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLoginIDInfo,
            String szUserCode
    );

    /**
     * 查询带密码用户详细信息
     *
     * @param [IN]  pstUserLoginIDInfo 用户登录ID信息标识。
     * @param [IN]  pstQueryCondition 查询通用条件
     * @param [OUT] pstUserInfo  带密码的用户信息
     * @return 返回如下错误码：
     * -
     * @note 1. 对应通用查询条件中的查询项类型分别为:USER_CODE_TYPE、USER_NAME_TYPE、USER_DESC
     * 2. 该接口仅支持VM平台
     */
    int ZDL_QueryUserInfoByCondition
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLogIDInfo,
            SDKStructure.COMMON_QUERY_CONDITION_S pstQueryCondition,
            SDKStructure.USER_INFO_PASSWORD_S pstUserPasswordInfo
    );

    /**
     * 用户修改自己的密码信息
     *
     * @param [IN] pstUserLoginIDInfo        用户信息标识
     * @param [IN] pstUserModifyPassword   用户密码信息
     * @return 返回如下结果：
     * - 成功：
     * - 失败：
     * -     返回操作结果码，见错误码文件
     * @note 无
     */
    int ZDL_ModifyUserPassword
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLoginIDInfo,
            SDKStructure.USER_MODIFY_PASSWORD_S pstUserModifyPassword
    );

    /**
     * 给用户赋予角色（列表）
     *
     * @param [IN] pstUserLoginIDInfo            用户信息标识
     * @param [IN] szUserCode                  用户编码
     * @param [IN] aszRoleCode                 角色编码列表
     * @param [IN] ulRoleCount                 角色个数,不能超过IMOS_MAX_USER_ROLES_NUM个
     * @return 返回如下结果：
     * - 成功：
     * - 失败：
     * -     返回操作结果码，见错误码文件
     * @note 无
     */
    int ZDL_AssignRoleForUser
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLoginIDInfo,
            byte[] szUserCode,
            byte[] aszRoleCode,
            int ulRoleCount
    );

    /**
     * 增加Statement内容 \n
     *
     * @param [IN] pstUserLogIDInfo        用户登录ID信息标识
     * @param [IN] pstDispositionInfo      Statement信息
     * @param [IN] pstMapAreaDisposeResInfo区域Statement资源信息
     * @return 返回如下结果：
     * - 成功：
     * - #ERR_COMMON_SUCCEED
     * - 失败：
     * -     返回操作结果码，见错误码文件
     */
    int ZDL_AddStatementDisposition
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLogIDInfo,
            SDKStructure.STATEMENT_DISPOSITION_INFO_S pstDispositionInfo,
            SDKStructure.MAP_AREA_DISPOSE_RES_INFO_S pstMapAreaDisposeResInfo
    );

    /**
     * 删除Statement内容 \n
     *
     * @param [IN] pstUserLogIDInfo        用户登录ID信息标识
     * @param [IN] szDispositionCode       Statement编号
     * @return 返回如下结果：
     * - 成功：
     * - #ERR_COMMON_SUCCEED
     * - 失败：
     * -     返回操作结果码，见错误码文件
     * @note 删除时后台会同时删除Statement照片
     */
    int ZDL_DelStatementDisposition
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLogIDInfo,
            String szDispositionCode
    );

    /**
     * 查询Statement列表 \n
     *
     * @param [IN]  pstUserLogIDInfo        用户登录ID信息标识
     * @param [IN]  pstQueryCondition       通用查询条件
     * @param [IN]  pstQueryPageInfo        请求分页信息
     * @param [OUT] pstRspPageInfo          响应分页信息
     * @param [OUT] pstDispositionList      Statement列表
     * @return 返回如下结果：
     * - 成功：
     * - #ERR_COMMON_SUCCEED
     * - 失败：
     * -     返回操作结果码，见错误码文件
     */
    int ZDL_QueryStatementDispositionList
    (
            SDKStructure.USER_LOGIN_ID_INFO_S pstUserLogIDInfo,
            SDKStructure.COMMON_QUERY_CONDITION_S pstQueryCondition,
            SDKStructure.QUERY_PAGE_INFO_S pstQueryPageInfo,
            SDKStructure.RSP_PAGE_INFO_S pstRspPageInfo,
            SDKStructure.STATEMENT_DISPOSITION_INFO_S[] pstDispositionList
    );

}

