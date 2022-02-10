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
@ConfigurationProperties(prefix = "spring.config.ant.server")
public class SpringConfigAntServerConfig {

    @Value("${host-url}")
    private String hostUrl;

    @Value("${polling.path}")
    private String pollingPath;

    @Value("${polling.method}")
    private String pollingMethod;

    public String getHostUrl() {
        return hostUrl;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public String getPollingPath() {
        return pollingPath;
    }

    public void setPollingPath(String pollingPath) {
        this.pollingPath = pollingPath;
    }

    public String getPollingMethod() {
        return pollingMethod;
    }

    public void setPollingMethod(String pollingMethod) {
        this.pollingMethod = pollingMethod;
    }
}
