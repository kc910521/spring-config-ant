package com.ck.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * @Author caikun
 * @Description 需要更新注册我
 * @Date 下午7:06 22-1-29
 **/
public class ConfigMessageListener implements ApplicationListener<ConfigMessageEvent> {
    @Override
    public void onApplicationEvent(ConfigMessageEvent event) {
        // refresh context @Value
        System.out.println(event.getData());
    }
}
