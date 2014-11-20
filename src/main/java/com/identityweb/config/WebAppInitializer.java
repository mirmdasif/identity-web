package com.identityweb.config;
import org.springframework.boot.context.embedded.MultiPartConfigFactory;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;


public class WebAppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { CoreConfig.class, SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MultipartFilter()};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultiPartConfigFactory multiPartConfigFactory = new MultiPartConfigFactory();
        multiPartConfigFactory.setMaxRequestSize(20000);
        multiPartConfigFactory.setMaxFileSize(20000);
        registration.setMultipartConfig(multiPartConfigFactory.createMultipartConfig());
    }

}