package com.example.spring.example.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Cat
 *
 * @author zhanghui
 * @date 2021/6/28 11:43 上午
 */
@Data
@AllArgsConstructor
public class Cat {

    private final String name;

    public static class Factory {
        public Cat create(String name){
            return new Cat(name);
        }
    }
}
