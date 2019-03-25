package com.zdl.code;

import com.sun.jna.Platform;
import com.zdl.code.server.AuthorizationRequestFilter;
import com.zdl.code.server.HttpUtils;
import com.zdl.code.server.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ZDLegend on 2016/10/19.
 */
@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    static {
        logger.debug("Yu Zhou Di Yi Shuai - ZDLegend App Start");
    }

    public JerseyConfig() {
        /* 注册资源 */
        packages("com.zdl.code.controller");
        register(LoggingFeature.class);
        register(AuthorizationRequestFilter.class);

        /* 初始化日志配置 */
        String res = (Platform.isWindows() ? "../log4j.properties" : "../log4j_linux.properties");
        String url = this.getClass().getResource(res).getPath();
        String path = StringUtils.spaceString(url);
        PropertyConfigurator.configure(path);
    }
}
