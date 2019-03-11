package com.zdl.code.server;

import com.zdl.code.exception.AuthenticationException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;

/**
 * 用户鉴权过滤器
 */
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String url = requestContext.getUriInfo().getPath();
        if (url.contains("login")) {
            return;
        }

        String accessToken = requestContext.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
        boolean ret = UserManager.getInstance().checkAccessToken(accessToken);
        if (ret) {
            UserManager.getInstance().updateUserInfo(accessToken);
        } else {
            throw new AuthenticationException("无效用户");
        }
    }
}
