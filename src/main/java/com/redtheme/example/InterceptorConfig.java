package com.redtheme.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.redtheme.example.interceptor.CongnitoInterceptor;;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    CongnitoInterceptor congnitoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(congnitoInterceptor);
    }
}