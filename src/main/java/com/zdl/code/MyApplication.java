package com.zdl.code;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jna.Platform;
import com.zdl.code.server.AuthorizationRequestFilter;
import com.zdl.code.server.SDKHandler;
import com.zdl.code.server.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import javax.json.stream.JsonGenerator;
import javax.ws.rs.ApplicationPath;

/**
 * Created by ZDLegend on 2016/10/19.
 */
@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    static {
        System.out.println("Yu Zhou Di Yi Shuai - ZDLegend App Start");
    }

    public MyApplication() {

        /* 注册资源 */
        packages("com.zmh.code.controller");
        register(LoggingFeature.class);
        register(AuthorizationRequestFilter.class);
        register(MultiPartFeature.class);
        register(JacksonJsonProvider.class);
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/");
        property(JsonGenerator.PRETTY_PRINTING, true);

        /* 初始化日志配置 */
        String res = (Platform.isWindows() ? "../log4j.properties" : "../log4j_linux.properties");
        String url = this.getClass().getResource(res).getPath();
        String path = StringUtils.spaceString(url);
        PropertyConfigurator.configure(path);

        /* 初始化SDK */
        SDKHandler handler = new SDKHandler();
        handler.init();
    }
}
