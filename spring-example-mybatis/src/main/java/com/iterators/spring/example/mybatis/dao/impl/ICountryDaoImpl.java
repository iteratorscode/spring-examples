package com.iterators.spring.example.mybatis.dao.impl;

import com.iterators.spring.example.mybatis.dao.ICountryDao;
import com.iterators.spring.example.mybatis.entity.Country;
import com.iterators.spring.example.mybatis.mapper.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Country DAOImpl
 *
 * @author iterators
 * @date 2021/5/19 下午12:29
 */
@Repository
@AllArgsConstructor
public class ICountryDaoImpl implements ICountryDao {

    private final CountryMapper countryMapper;

    @Override
    public List<Country> list() {
        return countryMapper.getAll();
    }
}
