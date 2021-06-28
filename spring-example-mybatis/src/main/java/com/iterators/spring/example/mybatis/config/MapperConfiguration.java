package com.iterators.spring.example.mybatis.config;

import com.iterators.spring.example.mybatis.interceptor.EncryptResultInterceptor;
import com.iterators.spring.example.mybatis.interceptor.SqlCostInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Mapper配置
 *
 * @author iterators
 * @date 2021/5/19 下午12:40
 */
@Configuration
@MapperScan("com.iterators.spring.example.mybatis.mapper")
public class MapperConfiguration {

    @Bean
    public SqlCostInterceptor executionTimeLogInterceptor() {
        SqlCostInterceptor interceptor = new SqlCostInterceptor();
        Properties properties = new Properties();
        properties.setProperty("p1", "v1");
        interceptor.setProperties(properties);
        return interceptor;
    }

    @Bean
    public EncryptResultInterceptor encryptResultInterceptor() {
        return new EncryptResultInterceptor();
    }
}
