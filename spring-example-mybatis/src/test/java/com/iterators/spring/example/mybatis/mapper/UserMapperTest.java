package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getById() {
        UserDO userDO = userMapper.getById(1L);
        log.info("userDO: {}", userDO);
    }

    @Test
    void listByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<UserDO> users = userMapper.listByIds(ids);
        log.info("users: {}", users);
    }
}