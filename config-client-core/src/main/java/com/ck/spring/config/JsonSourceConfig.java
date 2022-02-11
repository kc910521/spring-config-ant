package com.ck.spring.config;

import com.ck.spring.prop.JsonPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author caikun
 * @Description 本地的数据中心配置
 * @Date 下午5:41 22-2-9
 **/
@PropertySource(value = "file:${spring.config.ant.client.cache-file-path}", factory = JsonPropertySourceFactory.class)
public class JsonSourceConfig {

}
