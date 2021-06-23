package com.example.spring.example.core;

import com.example.spring.example.core.bean.ExcludeBean;
import com.example.spring.example.core.bean.Foo;
import com.example.spring.example.core.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringExampleCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringExampleCoreApplication.class, args);
        context.getBean(ApplicationConfig.class);
        Foo.Bar bean = context.getBean(Foo.Bar.class);
        System.out.println("bean.toString() = " + bean.toString());
    }

}
