package com.ck.spring.define;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author caikun
 * @Description 内部使用
 * @Date 下午5:19 22-2-9
 **/
public class BeanFieldsHolder {

    private String beanName;

    private WeakReference<Object> springBeanWeak;

    private final Set<Field> fields = new HashSet<>();


    public Object getSpringBean() {
        return springBeanWeak.get();
    }

    public BeanFieldsHolder(String beanName, Object bean) {
        this.beanName = beanName;
        this.springBeanWeak = new WeakReference<>(bean);
    }

    public BeanFieldsHolder(String beanName, Object bean, Field field) {
        this.beanName = beanName;
        this.springBeanWeak = new WeakReference<>(bean);
        this.fields.add(field);
    }

    public void setSpringBeanWeak(Object bean) {
        this.springBeanWeak = new WeakReference<>(bean);
    }


    @Override
    public int hashCode() {
        return this.beanName.hashCode() ^ 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BeanFieldsHolder) {
            BeanFieldsHolder old = (BeanFieldsHolder) obj;
            Object realOldBean = old.getSpringBean();
            if (realOldBean != null) {
                Set<Field> oldFields = old.getFields();
                if (Objects.equals(realOldBean, this.getSpringBean())) {
                    //  object equals
                    if (Objects.equals(oldFields, this.getFields())) {
                        return true;
                    }
                    old.getFields().addAll(this.getFields());
                    return true;
                } else {
                    return false;
                }
            }
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "BeanFieldsHolder{" +
                "beanName='" + beanName + '\'' +
                ", springBeanWeak=" + springBeanWeak +
                ", fields=" + fields +
                '}';
    }

    public Set<Field> getFields() {
        return fields;
    }


    public String getBeanName() {
        return beanName;
    }
}
