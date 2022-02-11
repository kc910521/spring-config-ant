package com.ck.spring.basic;

import com.ck.spring.config.SpringConfigAntClientConfig;
import com.ck.spring.event.ConfigMessageEvent;
import com.ck.spring.util.EnvPlaceholderUtils;
import com.ck.spring.inject.HookFieldPostProcessor;
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
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author caikun
 * @Description
 * @Date 下午3:45 22-2-9
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@ComponentScan("com.ck.spring")
@Import({Dep3.class, HookFieldPostProcessor.class})
public class InitSpringTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private SpringConfigAntClientConfig springConfigAntClientConfig;

    @Value("${mk}")
    private String mmmm;

    @Autowired
    private Environment environment;


    @Test
    public void firstKiss() {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("========");
        System.out.println(applicationContext.getEnvironment().getProperty("mk"));
        System.out.println(applicationContext.getEnvironment().getProperty("spring.config.ant.client.cache-file-path"));
        System.out.println("=======");
        System.out.println(springConfigAntClientConfig.getCacheFilePath());
        System.out.println(JsonUtils.getFromJsonString("{k1: 12}"));
        System.out.println("KK1:" + this.mmmm);
    }


    @Test
    public void placeholderResolveTest() {
        Set<String> s1 = EnvPlaceholderUtils.listAllPlaceholders("${not_exist}", environment);
        System.out.println(s1);
        Set<String> s2 = EnvPlaceholderUtils.listAllPlaceholders("${kk}", environment);
        System.out.println(s2);
        Set<String> s3 = EnvPlaceholderUtils.listAllPlaceholders("${kk${mk:fuck}}", environment);
        System.out.println(s3);
        Set<String> s4 = EnvPlaceholderUtils.listAllPlaceholders("${kk${not_exist:all}}", environment);
        System.out.println(s4);
    }

}
