package com.GrappleGame.Web.Data;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by tppppp on 2016/12/2.
 */
@Configuration
public class Config {
////    @Bean
////    public MessageSource messageSource(){
////        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
////        messageSource.setBasename("message");
////        return messageSource;
//    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:///message");
        messageSource.setCacheSeconds(10);
        return  messageSource;
    }
}