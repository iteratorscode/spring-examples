package com.example.spring.example.core.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;

/**
 * 添加类描述信息
 *
 * @author zhanghui
 * @date 2021/6/23 5:41 下午
 */
@Slf4j
public class MyBootstrapRegistryInitializer implements BootstrapRegistryInitializer {
    @Override
    public void initialize(BootstrapRegistry registry) {
        log.info("init: {}", registry);
    }
}
