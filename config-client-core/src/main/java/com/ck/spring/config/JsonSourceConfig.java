package com.ck.spring.config;

import com.ck.spring.prop.JsonPropertySourceFactory;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author caikun
 * @Description
 * @Date 下午5:41 22-2-9
 **/
//@DependsOn("ymlSourceConfig")
@PropertySource(value = "file:${spring.config.ant.client.cache-file-path}", factory = JsonPropertySourceFactory.class)
public class JsonSourceConfig {
}
