package com.ck.spring.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @Author caikun
 * @Description 配置消息事件
 * @Date 下午7:05 22-1-29
 **/
public class ConfigMessageEvent extends ApplicationEvent {

    public ConfigMessageEvent(Object source) {
        super(source);
    }

    /**
     * 配置数据
     */
    private Map<String, Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
