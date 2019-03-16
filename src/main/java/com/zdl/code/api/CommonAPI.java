package com.zdl.code.api;

import com.sun.jna.Structure;

import javax.ws.rs.core.HttpHeaders;

/**
 * 通用C++ API封装
 * [IN] 为SDK api入参，[OUT] 为SDK api出参
 * <p>
 * Created by ZDLegend on 2019/3/13.
 */
public interface CommonAPI<IN extends Structure, OUT extends Structure> {

    /**
     * 执行某个C++ API
     *
     * @param headers http头，用于C++鉴权
     * @param data    C++ API入参
     * @return C++ API 调用错误码
     */
    int execute(HttpHeaders headers, IN data);

    /**
     * 获取C++ API 的出参
     *
     * @return 出参结果
     */
    OUT getOut();
}
