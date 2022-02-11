package com.ck.spring.basic;

import com.ck.spring.cache.PropRelationHolder;
import com.ck.spring.define.BeanFieldsHolder;
import com.ck.spring.inject.HookFieldPostProcessor;
import com.google.common.collect.SetMultimap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

/**
 * @Author caikun
 * @Description
 * @Date 下午2:28 22-2-11
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Import({Dep3.class, HookFieldPostProcessor.class})
@ComponentScan("com.ck.spring")
public class RelationHolderTest {

    @Test
    public void buildRelationTest() throws ClassNotFoundException, NoSuchFieldException {
        Dep3 o1 = new Dep3();
        Dep3 o2 = new Dep3();
        Class<?> cls = Class.forName("com.ck.spring.basic.Dep3");

        Field field1 = cls.getDeclaredField("suka");
        Field field2 = cls.getDeclaredField("rb");
        Field field11 = cls.getDeclaredField("suka");


        PropRelationHolder.buildRelation("key1", "b1", o1, field1);
        PropRelationHolder.buildRelation("key1", "b1", o1, field2);
        PropRelationHolder.buildRelation("key1", "b1", o1, field1);
        PropRelationHolder.buildRelation("key1", "b1", o1, field11);
        PropRelationHolder.buildRelation("key2", "b1", o1, field1);
        PropRelationHolder.buildRelation("key2", "b2", o1, field1);
        PropRelationHolder.buildRelation("key2", "b2", o2, field1);
//        PropRelationHolder.buildRelation("key1", "b2", o2, field1);
//        PropRelationHolder.buildRelation(configKey, beanName, bean, field);
        // show
        SetMultimap paramRelationMap = PropRelationHolder.getParamRelationMap();
        System.out.println(paramRelationMap);
        System.out.println("==1=");
        paramRelationMap.get("key1").forEach(System.out::println);
        System.out.println("==2=");
        paramRelationMap.get("key2").forEach(System.out::println);
        System.out.println("==3=");
        paramRelationMap.get("key3").forEach(System.out::println);


    }

}
