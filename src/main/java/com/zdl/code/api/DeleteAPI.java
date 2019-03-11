package com.zdl.code.api;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/11/24.
 */
public interface DeleteAPI {

    /**
     * 删除接口 \n
     *
     * @param headers 请求的Http头
     * @param id      对应资源ID
     * @return 返回如下结果：
     */
    int delete(HttpHeaders headers, String id);
}
