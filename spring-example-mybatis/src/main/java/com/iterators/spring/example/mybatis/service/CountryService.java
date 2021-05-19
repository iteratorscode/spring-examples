package com.iterators.spring.example.mybatis.service;

import com.iterators.spring.example.mybatis.dao.ICountryDao;
import com.iterators.spring.example.mybatis.entity.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    private final ICountryDao countryDao;

    public List<Country> list() {
        return countryDao.list();
    }
}
