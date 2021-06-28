package com.iterators.spring.example.async.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Hello controler
 *
 * @author iterators
 * @date 2020/12/17 上午11:47
 */
@RestController
public class HelloController {

    public DeferredResult<String> asyncHello() {
        DeferredResult<String> result = new DeferredResult<>();

        return result;
    }
}
