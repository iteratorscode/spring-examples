package com.iterators.spring.example.cache.controller;

import com.iterators.spring.example.cache.entity.User;
import com.iterators.spring.example.cache.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @author iterators
 * @date 2020/11/30 下午8:17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    private User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/remove/{id}")
    private Boolean removeById(@PathVariable Long id) {
        return userService.removeById(id);
    }

}
