package com.ck.spring.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author caikun
 * @Description //TODO $END
 * @Date 下午5:22 22-1-27
 **/
@Component
public class Dep3 {

    //    @Value("${caikun_1}")
//    private int[] ok;
//
//    @Value("${tim_address}")
//    private AddressName address1;
    @Value("${kk${mk:fuck}}")
    private String suka;

    @Value("${kk}")
    private String kk;

    private String rb;

    @PostConstruct
    public void init2() {
        System.out.println("ss=========" + suka);
//        System.out.println("add:" + address1);
    }

    public void test() {
        System.out.println("test mk:" + suka);
        System.out.println("test kk:" + kk);
    }

}
