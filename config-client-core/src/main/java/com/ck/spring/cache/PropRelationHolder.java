package com.ck.spring.cache;

import com.ck.spring.define.BeanFieldsHolder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;

import java.lang.reflect.Field;

/**
 * @Author caikun
 * @Description 保存属性
 * @Date 下午4:58 22-2-9
 **/
public class PropRelationHolder {

    /**
     * key: config key
     * (fixme:暂时不考虑一个客户端支持多个namespace)
     * value:
     *========================
     * {
     *   configKey1 --> [
     *    {
     *        beanObject1,
     *        Field: [
     *            f1,
     *            f2
     *        ]
     *    }
     *    ,{
     *        beanObject2,
     *        Field: [
     *            f3
     *        ]
     *    }
     *
     *   ]
     * }
     *
     *
     */
    private static SetMultimap<String, BeanFieldsHolder> paramRelationMap = HashMultimap.create();

//    public static Multimap<String, BeanFieldsHolder> getParamRelationMap() {
//        return paramRelationMap;
//    }

    public static void buildRelation(String key, String beanName, Object beanObject, Field valueField) {
        BeanFieldsHolder beanFieldsHolder = new BeanFieldsHolder(beanName, beanObject, valueField);
//        paramRelationMap.put(key, )
        paramRelationMap.put(key, beanFieldsHolder);
//        if (paramRelationMap.containsKey(key)) {
//            paramRelationMap.get(key).forEach(bfh -> {
////
//            });
//
//        }


    }

    public static SetMultimap<String, BeanFieldsHolder> getParamRelationMap() {
        return paramRelationMap;
    }
}
