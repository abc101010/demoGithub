package com.example.demosession.config;

import com.example.demosession.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 拦截器的配置
@Configuration
public class SessionConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/**")    // 拦截所有的请求
                .excludePathPatterns("/login/**"); // 排除登录接口
    }
}
