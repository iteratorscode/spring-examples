package com.example.spring.example.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Foo class
 *
 * @author zhanghui
 * @date 2021/6/21 下午4:33
 */
@Component
public class Foo {

    @Autowired
    private Bar bar;
}
