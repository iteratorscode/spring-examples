package com.iterators.spring.example.mybatis.service;

import com.iterators.spring.example.mybatis.mapper.CountryMapper;
import com.iterators.spring.example.mybatis.entity.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Country Service
 *
 * @author iterators
 * @date 2021/5/19 下午12:46
 */
@Service
@AllArgsConstructor
public class CountryService {

    private final CountryMapper countryMapper;

    @Transactional
    public List<Country> list() {
        return countryMapper.list();
    }
}
