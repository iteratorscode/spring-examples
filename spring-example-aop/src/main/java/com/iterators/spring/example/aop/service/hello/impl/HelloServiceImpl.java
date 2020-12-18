package com.iterators.spring.example.aop.service.hello.impl;

import com.iterators.spring.example.aop.annotation.HelloAnnotation;
import com.iterators.spring.example.aop.service.hello.IHelloService;
import org.springframework.stereotype.Service;

/**
 * Hello service
 *
 * @author zhanghui
 * @date 2020/12/18 下午2:29
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @HelloAnnotation(value = "id")
    @Override
    public String hello(Integer id) {
        return "From hello service" + id;
    }
}