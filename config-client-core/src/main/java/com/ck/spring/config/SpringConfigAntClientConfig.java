package com.ck.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author caikun
 * @Description
 * @Date 下午4:30 22-2-9
 **/
@Component
@ConfigurationProperties(prefix = "spring.config.ant.client")
public class SpringConfigAntClientConfig {

    @Value("${cache-file-path}")
    private String cacheFilePath;

    public void setCacheFilePath(String cacheFilePath) {
        this.cacheFilePath = cacheFilePath;
    }

    public String getCacheFilePath() {
        return cacheFilePath;
    }
}
