package com.zdl.code.api;

import com.sun.jna.Structure;
import com.zdl.code.jna.SDKStructure;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ZDLegend on 2016/11/24.
 */
public interface QueryAPI<R> {

    /**
     * 查询返回的结果\n
     *
     * @param headers       的Http头
     * @param Condition     通用查询条件
     * @param QueryPageInfo 分页参数
     * @param RspPageInfo   分页信息查询结果
     * @param Info          查询结果
     * @return 返回如下结果：
     */
    int query(HttpHeaders headers, Structure Condition,
              SDKStructure.QUERY_PAGE_INFO_S QueryPageInfo,
              SDKStructure.RSP_PAGE_INFO_S RspPageInfo,
              R[] Info);
}
