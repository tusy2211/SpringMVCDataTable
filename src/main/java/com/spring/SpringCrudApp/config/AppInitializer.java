package com.spring.SpringCrudApp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.SpringCrudApp.config.AppConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
