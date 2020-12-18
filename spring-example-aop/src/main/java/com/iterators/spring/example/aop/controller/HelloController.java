package com.iterators.spring.example.aop.controller;

import com.iterators.spring.example.aop.service.hello.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main controller
 *
 * @author zhanghui
 * @date 2020/12/18 下午2:28
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final IHelloService helloService;

    public HelloController(IHelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/{id}")
    public String hello(@PathVariable Integer id) {
        return helloService.hello(id);
    }
}
