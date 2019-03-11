package com.zdl.code.api;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/11/24.
 */
public interface CreateAPI<T> {

    /**
     * 创建接口
     *
     * @param headers 的Http头
     * @param data    数据封装采用JSON
     * @return 返回如下结果：
     */
    int create(HttpHeaders headers, T data);
}
