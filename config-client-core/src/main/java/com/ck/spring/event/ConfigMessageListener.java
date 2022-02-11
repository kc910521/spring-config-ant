package com.ck.spring.event;

import com.ck.spring.cache.PropRelationHolder;
import com.ck.spring.define.BeanFieldsHolder;
import com.google.common.collect.SetMultimap;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.Set;

/**
 * @Author caikun
 * @Description 需要更新注册我
 *
 * org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement#resolveFieldValue(java.lang.reflect.Field, java.lang.Object, java.lang.String)
 * @Date 下午7:06 22-1-29
 **/
@Component
public class ConfigMessageListener implements ApplicationListener<ConfigMessageEvent>, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    private final Logger logger = LoggerFactory.getLogger(ConfigMessageListener.class);

    @Override
    public void onApplicationEvent(ConfigMessageEvent event) {
        SetMultimap<String, BeanFieldsHolder> paramRelationMap = PropRelationHolder.getParamRelationMap();
        // refresh context @Value
        logger.debug("refreshing");
        Map<String, Object> data = event.getData();
        data.entrySet().forEach(stringObjectEntry -> {
            logger.debug("s:{}", stringObjectEntry);
            paramRelationMap.get(stringObjectEntry.getKey()).forEach(beanFieldsHolder -> {
                beanFieldsHolder.getFields().forEach(field -> {
                    Object springBean = beanFieldsHolder.getSpringBean();
                    if (springBean != null) {
                        ReflectionUtils.makeAccessible(field);
                        TypeConverter typeConverter = this.beanFactory.getTypeConverter();
                        Object result = typeConverter.convertIfNecessary(stringObjectEntry.getValue(), field.getType(), field);
                        ReflectionUtils.setField(field, springBean, result);
                    }
                });

            });
//            paramRelationMap.get(stringObjectEntry)
//

        });
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (!(beanFactory instanceof ConfigurableListableBeanFactory)) {
            throw new IllegalArgumentException(
                    "ConfigMessageListener requires a ConfigurableListableBeanFactory: " + beanFactory);
        }
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}
