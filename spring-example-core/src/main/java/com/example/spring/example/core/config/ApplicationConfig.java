package com.example.spring.example.core.config;

import com.example.spring.example.core.bean.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类
 *
 * @author iterators
 * @date 2021.05.06
 */
@Configuration
// @ComponentScan(basePackages = "com.example.spring.example.core",
//     useDefaultFilters = false,
//     excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {ApplicationTypeFilter.class})})
public class ApplicationConfig {

    // @Bean
    // public Foo foo() {
    //     return new Foo();
    // }
}
