package com.zdl.code.jna;

/**
 * Created by user on 2016/7/9.
 */
public interface SDKErrorCode {

    int ERR_COMMON_SUCCEED = 0;
    int ERR_COMMON_FAIL = 1;

    int
            ERR_ROLE_NUM_OUT_FOUND = 50001,
            ERR_JSON_LACK_FIELD = 50002,
            ERR_JSON_TO_STRUCT = 50003,
            ERR_INVALID_INPUT = 50004,
            ERR_QUERY_MAX_NUM = 50005;
}
