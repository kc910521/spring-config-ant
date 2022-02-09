package com.ck.spring.config;

import com.ck.spring.prop.YmlPropertySourceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author caikun
 * @Description 内部配置和外部配置
 * @Date 下午4:32 22-1-28
 **/
@Configuration
@EnableConfigurationProperties
//@PropertySource(value = "file:${config.local.path:${user.home}/config}/server_data.json", factory = NetPropertySourceFactory.class)
@PropertySource(value = "classpath:/remote_config.yml", factory = YmlPropertySourceFactory.class)
@Import(JsonSourceConfig.class)
public class YmlSourceConfig {


}
