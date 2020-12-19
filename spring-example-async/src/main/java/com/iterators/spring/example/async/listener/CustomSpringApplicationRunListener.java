package com.iterators.spring.example.async.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义 SpringApplicationRunListener: 监听SpringApplication的启动事件，扩展自己的业务逻辑
 *
 * @author iterators
 * @date 2020.12.19
 */
@Slf4j
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;


    public CustomSpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        bootstrapContext.addCloseListener((event) -> {
            log.info("Context closed: {}", event.getApplicationContext());
        });
        log.info("Starting -> configurableBootstrapContext: {}", bootstrapContext);
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        environment.addActiveProfile("default");
        log.info("Environment prepared -> configurableBootstrapContext: {}, environment: {}", bootstrapContext, environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("Context prepared -> configurableBootstrapContext: {}", context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("Context loaded -> configurableBootstrapContext: {}", context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("Context started -> configurableBootstrapContext: {}", context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("Context running -> configurableBootstrapContext: {}", context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("Context failed -> configurableBootstrapContext: {}, throwable: {}", context, exception);
    }
}
