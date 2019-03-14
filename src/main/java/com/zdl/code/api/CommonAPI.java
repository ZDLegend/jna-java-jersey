package com.zdl.code.api;

import com.sun.jna.Structure;

import javax.ws.rs.core.HttpHeaders;

/**
 * 通用C++ API封装
 * <p>
 * Created by ZDLegend on 2019/3/13.
 */
public interface CommonAPI<T extends Structure, OUT extends Structure> {

    /**
     * 执行某个C++ API
     *
     * @param headers http头，用于C++鉴权
     * @param data    C++ API入参
     * @return C++ API 调用错误码
     */
    int execute(HttpHeaders headers, T data);

    /**
     * 获取C++ API 入参结构体中的出参
     *
     * @param data data C++ API入参
     * @return 出参结果
     */
    OUT getOut(T data);
}
