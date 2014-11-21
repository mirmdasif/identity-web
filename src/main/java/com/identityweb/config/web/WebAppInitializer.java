package com.identityweb.config.web;
import com.identityweb.config.core.CoreConfig;
import com.identityweb.config.security.SecurityConfig;
import com.identityweb.config.utils.MailConfig;
import org.springframework.boot.context.embedded.MultiPartConfigFactory;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;


public class WebAppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    private static final int MAX_FILE_SIZE = 20000;
    private static final int MAX_REQUEST_SIZE = 20000;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { CoreConfig.class, SecurityConfig.class, MailConfig.class };
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
        multiPartConfigFactory.setMaxRequestSize(MAX_REQUEST_SIZE);
        multiPartConfigFactory.setMaxFileSize(MAX_FILE_SIZE);
        registration.setMultipartConfig(multiPartConfigFactory.createMultipartConfig());
    }

}