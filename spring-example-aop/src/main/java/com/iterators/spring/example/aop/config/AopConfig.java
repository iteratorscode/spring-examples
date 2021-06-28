package com.iterators.spring.example.aop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aop 配置
 *
 * @author iterators
 * @date 2020/12/18 下午4:06
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@Configuration
public class AopConfig {
}
