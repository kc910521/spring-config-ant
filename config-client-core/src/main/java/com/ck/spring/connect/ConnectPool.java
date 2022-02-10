package com.ck.spring.connect;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author caikun
 * @Description //TODO $END
 * @Date 下午3:09 22-2-10
 **/
public class ConnectPool {

    private static final ThreadFactory threadFactory = r -> new Thread("[spring-config-ant]");

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 0, 0, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            ConnectPool.threadFactory,
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void add(Runnable command) {
        threadPoolExecutor.execute(command);
    }


}
