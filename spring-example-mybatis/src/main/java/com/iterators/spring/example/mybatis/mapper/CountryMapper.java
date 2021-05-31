package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.entity.Country;

import java.util.List;

/**
 * Country DAO
 *
 * @author iterators
 * @date 2021/5/19 下午12:28
 */
public interface CountryMapper {

    /**
     * 查询所有国家
     */
    List<Country> list();
}
