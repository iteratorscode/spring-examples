package com.example.spring.example.core.bean;

import com.example.spring.example.core.bean.Foo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bar
 *
 * @author zhanghui
 * @date 2021/7/2 下午5:26
 */
@Component
public class Bar {

    @Autowired
    private Foo foo;
}
