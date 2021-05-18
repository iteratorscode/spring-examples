package com.example.spring.example.core;

import com.example.spring.example.core.bean.ExcludeBean;
import com.example.spring.example.core.config.ApplicationConfig;
import com.example.spring.example.core.config.ApplicationTypeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.spring.example.core",
        useDefaultFilters = false,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {ApplicationTypeFilter.class})})
public class SpringExampleCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringExampleCoreApplication.class, args);
        context.getBean(ApplicationConfig.class);
        ExcludeBean bean = context.getBean(ExcludeBean.class);
        System.out.println("bean.toString() = " + bean.toString());
    }

}
