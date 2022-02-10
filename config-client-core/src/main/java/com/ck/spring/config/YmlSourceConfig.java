package com.ck.spring.config;

import com.ck.spring.prop.YmlPropertySourceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author caikun
 * @Description 处理客户端内部配置
 * @Date 下午4:32 22-1-28
 **/
@Configuration
@EnableConfigurationProperties
@PropertySource(value = "classpath:/remote_config.yml", factory = YmlPropertySourceFactory.class)
@Import(JsonSourceConfig.class)
public class YmlSourceConfig {


}
