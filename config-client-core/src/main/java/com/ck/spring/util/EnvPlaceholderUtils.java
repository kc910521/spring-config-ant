package com.ck.spring.util;

import com.ck.spring.inject.LocalEnvironmentPlaceholderResolver;
import org.springframework.core.env.Environment;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.SystemPropertyUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @Author caikun
 * @Description
 * @Date 下午5:21 22-2-9
 **/
public class EnvPlaceholderUtils {


    private final static PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper(SystemPropertyUtils.PLACEHOLDER_PREFIX,
            SystemPropertyUtils.PLACEHOLDER_SUFFIX, SystemPropertyUtils.VALUE_SEPARATOR, true);


    private static LocalEnvironmentPlaceholderResolver phr(Environment environment) {
        return new LocalEnvironmentPlaceholderResolver(environment);
    }

    /**
     * todo: customize type support
     *
     * @param bean
     * @param field
     * @param newObject
     * @param <NEW>
     */
    public static <NEW> void injectTo(Object bean, Field field, NEW newObject) {
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            field.set(bean, newObject);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(accessible);
    }


    public static Set<String> listAllPlaceholders(String value, Environment environment) {
        LocalEnvironmentPlaceholderResolver phr = EnvPlaceholderUtils.phr(environment);
        propertyPlaceholderHelper.replacePlaceholders(value, phr);
        return phr.getPlaceholders();
    }

}
