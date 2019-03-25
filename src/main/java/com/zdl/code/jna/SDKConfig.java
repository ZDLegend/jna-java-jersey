package com.zdl.code.jna;

import com.zdl.code.server.SDKHandler;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 初始化SDK
 */
@Configuration
public class SDKConfig {
    @PostConstruct
    public void SDKInit(){
        SDKHandler handler = new SDKHandler();
        handler.init();
    }
}
