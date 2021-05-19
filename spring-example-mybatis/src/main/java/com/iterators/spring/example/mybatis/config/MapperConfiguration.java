package com.iterators.spring.example.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mapper配置
 *
 * @author iterators
 * @date 2021/5/19 下午12:40
 */
@Configuration
@MapperScan("com.iterators.spring.example.mybatis.mapper")
public class MapperConfiguration {
}
