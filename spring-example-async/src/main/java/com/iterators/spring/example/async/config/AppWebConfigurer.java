package com.iterators.spring.example.async.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web支持异步请求配置
 *
 * @author zhanghui
 * @date 2020/12/17 上午11:54
 */
@Configuration
public class AppWebConfigurer implements WebMvcConfigurer {
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.registerCallableInterceptors();
        configurer.registerDeferredResultInterceptors();
        configurer.setDefaultTimeout(3000L);
        // configurer.setTaskExecutor();
    }
}
