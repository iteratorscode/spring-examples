package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.entity.Country;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Country Mapper
 *
 * @author iterators
 * @date 2021/5/19 下午12:36
 */
public interface CountryMapper {

    @Select("SELECT * FROM country")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name")
    })
    List<Country> getAll();
}
