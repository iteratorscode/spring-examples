package com.iterators.spring.example.mybatis.controller;

import com.iterators.spring.example.mybatis.entity.Country;
import com.iterators.spring.example.mybatis.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Country Controller
 *
 * @author iterators
 * @date 2021/5/19 下午12:44
 */
@RestController
@RequestMapping("country")
@AllArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/list")
    public List<Country> list() {
        return countryService.list();
    }
}
