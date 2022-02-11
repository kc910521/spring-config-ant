package com.ck.spring.inject;

import com.ck.spring.cache.PropRelationHolder;
import com.ck.spring.define.BeanFieldsHolder;
import com.ck.spring.util.EnvPlaceholderUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author caikun
 * @Description 处理属性时，加入bean-field缓存
 * @Date 下午4:16 22-2-10
 **/
public class HookFieldPostProcessor implements InstantiationAwareBeanPostProcessor, EnvironmentAware {

    private final Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(4);

    private PropRelationHolder propRelationHolder;

    private Environment environment;

    public HookFieldPostProcessor() {
        this.autowiredAnnotationTypes.add(Value.class);
        this.propRelationHolder = new PropRelationHolder();
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass() + " |" + pvs);
//        final BeanFieldsHolder beanFieldsHolder = new BeanFieldsHolder(beanName, bean);
//        beanFieldsHolder.setSpringBeanWeak(bean);
        ReflectionUtils.doWithLocalFields(bean.getClass(), field -> {
            MergedAnnotation<?> ann = findAutowiredAnnotation(field);
            if (ann != null) {
                if (Modifier.isStatic(field.getModifiers())) {
//                    if (logger.isInfoEnabled()) {
//                        logger.info("Autowired annotation is not supported on static fields: " + field);
//                    }
                    return;
                }
                Value valueAnno = field.getAnnotation(Value.class);
                if (valueAnno == null) {
                    return;
                }
                // 依次得到configKey（注解上的）
                EnvPlaceholderUtils.listAllPlaceholders(valueAnno.value(), this.environment).forEach(configKey -> {
                    // 插入confkey到holder缓存
                    PropRelationHolder.buildRelation(configKey, beanName, bean, field);
                });

            }
        });
        return pvs;
    }

    private MergedAnnotation<?> findAutowiredAnnotation(AccessibleObject ao) {
        MergedAnnotations annotations = MergedAnnotations.from(ao);
        for (Class<? extends Annotation> type : this.autowiredAnnotationTypes) {
            MergedAnnotation<?> annotation = annotations.get(type);
            if (annotation.isPresent()) {
                return annotation;
            }
        }
        return null;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
