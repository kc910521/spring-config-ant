package com.ck.spring.basic;

import com.ck.spring.event.ConfigMessageEvent;
import com.ck.spring.event.ConfigMessageListener;
import com.ck.spring.inject.HookFieldPostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author caikun
 * @Description //TODO $END
 * @Date 下午3:33 22-2-11
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Import({Dep3.class, HookFieldPostProcessor.class, ConfigMessageListener.class})
@ComponentScan("com.ck.spring")
public class AutoRefreshListenerTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Dep3 dep3;

    @Test
    public void listenerActivation() throws InterruptedException {
        dep3.test();
        Map<String, Object> newData = new HashMap<>();
        newData.put("kk", "888C");
        applicationContext.publishEvent(new ConfigMessageEvent(newData));
        dep3.test();
        TimeUnit.MILLISECONDS.sleep(3000);
        dep3.test();
    }

}
