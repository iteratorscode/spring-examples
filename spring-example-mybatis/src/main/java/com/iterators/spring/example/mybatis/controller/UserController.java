package com.iterators.spring.example.mybatis.controller;

import com.iterators.spring.example.mybatis.domain.UserDO;
import com.iterators.spring.example.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * User Controller
 *
 * @author zhanghui
 * @date 2021/8/4 4:22 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public UserDO getById(@PathVariable(value = "id") Long id) {
        return userService.getById(id);
    }
}
