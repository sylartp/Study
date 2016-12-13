package com.GrappleGame.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.*;

/**
 * Created by tppppp on 2016/12/1.
 */
public class GrappleGameWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

//    @Override
//    protected void customizeRegistration(Dynamic registration) {
//        registration.setMultipartConfig(new MultipartConfigElement("/resources/temp/uploads", 2097152, 4194304, 0));
//    }
}
