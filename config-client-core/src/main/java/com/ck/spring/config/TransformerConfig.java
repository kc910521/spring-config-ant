package com.ck.spring.config;

import com.ck.spring.tool.converter.AddressNameEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author caikun
 * @Description
 * @Date 下午5:40 22-1-28
 **/
@Configuration
public class TransformerConfig {
    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer cec = new CustomEditorConfigurer();
        cec.setPropertyEditorRegistrars(
                new PropertyEditorRegistrar[]{
                        new AddressNameEditorRegistrar()});
        return cec;
    }
}
