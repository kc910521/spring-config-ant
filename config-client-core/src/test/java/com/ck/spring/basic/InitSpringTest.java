package com.ck.spring.basic;

import com.ck.spring.config.SpringConfigAntClientConfig;
import com.ck.spring.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author caikun
 * @Description
 * @Date 下午3:45 22-2-9
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@ComponentScan("com.ck.spring")
@Import(Dep3.class)
public class InitSpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringConfigAntClientConfig springConfigAntClientConfig;

    @Value("${mk}")
    private String kk;
    @Autowired
    private Dep3 dep3;

    @Test
    public void bdList() {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("========");
        System.out.println(applicationContext.getEnvironment().getProperty("mk"));
        System.out.println(applicationContext.getEnvironment().getProperty("spring.config.ant.client.cache-file-path"));
        System.out.println("=======");
        System.out.println(springConfigAntClientConfig.getCacheFilePath());
        System.out.println(JsonUtils.getFromJsonString("{k1: 12}"));
        System.out.println("KK1:" + this.kk);
    }

}
