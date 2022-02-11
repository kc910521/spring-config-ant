package com.ck.spring.inject;

import org.springframework.core.env.Environment;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author caikun
 * @Description 属性获取工具
 * 获取时可以拿到解析出的Key
 * @Date 上午11:55 22-2-11
 **/
public class LocalEnvironmentPlaceholderResolver implements PropertyPlaceholderHelper.PlaceholderResolver {

    private final Set<String> placeholders = new HashSet<>();

    private Environment environment;

    public LocalEnvironmentPlaceholderResolver(Environment environment) {
        this.environment = environment;
    }


    @Override
    public String resolvePlaceholder(String placeholderName) {
        String property = environment.getProperty(placeholderName);
        if (property != null) {
            this.placeholders.add(placeholderName);
        }
        return property;
    }

    public Set<String> getPlaceholders() {
        return this.placeholders;
    }
}
