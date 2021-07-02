package com.example.spring.example.core;

import com.example.spring.example.core.bean.*;
import com.example.spring.example.core.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author iterators
 */
@SpringBootApplication
public class SpringExampleCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringExampleCoreApplication.class, args);
        context.getBean(ApplicationConfig.class);

        Dog dog = context.getBean(Dog.class);
        System.out.println("dog.toString() = " + dog);

        Cat cat = context.getBean(Cat.class);
        System.out.println("dog.toString() = " + cat);

        Zoo zoo = context.getBean(Zoo.class);
        System.out.println("zoo = " + zoo);

        Foo foo = context.getBean(Foo.class);
        System.out.println("foo = " + foo);
    }

}
