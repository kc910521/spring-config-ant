package com.ck.spring.prop;

import org.springframework.core.env.EnumerablePropertySource;

import java.util.Map;

/**
 * @Author caikun
 * @Description
 * @Date 下午6:17 22-1-28
 **/
public class DynamicPropertySource extends EnumerablePropertySource<Map<String, Object>> {


    @Override
    public String[] getPropertyNames() {
        return source.keySet().toArray(new String[source.size()]);
    }

    @Override
    public Object getProperty(String name) {
        return source.get(name);
    }

    public DynamicPropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    protected DynamicPropertySource(String name) {
        super(name);
    }

    @Override
    public boolean containsProperty(String name) {
        return source.containsKey(name);
    }


}
