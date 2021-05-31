package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class CountryMapperTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SqlSession sqlSession;

    @BeforeEach
    void setUp() {
    }

    @Test
    void list() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);

        List<Country> countries = countryMapper.list();
        log.info("countries: {}", countries);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CountryMapper countryMapper1 = sqlSession1.getMapper(CountryMapper.class);
        List<Country> countries1 = countryMapper1.list();

        log.info("countries1: {}", countries1);
    }

    @Test
    void execute() {
        sqlSession.select("list", new DefaultResultHandler());

    }
}