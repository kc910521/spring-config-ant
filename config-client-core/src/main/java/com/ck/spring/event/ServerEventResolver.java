package com.ck.spring.event;

import com.ck.spring.define.ServerConnResult;

/**
 * @Author caikun
 * @Description 可以通过SPI实现自己的数据格式解析
 * @Date 下午3:05 22-2-10
 **/
public interface ServerEventResolver {

    ServerConnResult sendAndGet();

}
