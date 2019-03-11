package com.zdl.code.api;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/11/24.
 */
public interface UpdateAPI<T> {

    /**
     * 更新接口\n
     *
     * @param headers 请求的Http头
     * @param data    数据封装采用JSON
     * @return 返回如下结果：
     */
    int update(HttpHeaders headers, T data);
}
