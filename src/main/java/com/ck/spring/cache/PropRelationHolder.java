package com.ck.spring.cache;

import com.ck.spring.define.BeanFieldsHolder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * @Author caikun
 * @Description 保存属性
 * @Date 下午4:58 22-2-9
 **/
public class PropRelationHolder {

    /**
     * key: config namespace_key
     * value:
     */
    private static Multimap<String, BeanFieldsHolder> paramRelationMap = HashMultimap.create();

    public static Multimap<String, BeanFieldsHolder> getParamRelationMap() {
        return paramRelationMap;
    }

    public void invoke(String key, Object value) {
        if (paramRelationMap.containsKey(key)) {
            paramRelationMap.get(key).forEach(bfh -> {
//                fd.setAccessible(true);
//                // fixme: 类型转换
//                fd.
            });

        }


    }
}
