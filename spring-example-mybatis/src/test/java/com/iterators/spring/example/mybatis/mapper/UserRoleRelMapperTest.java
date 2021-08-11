package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRoleRelMapperTest {

    @Autowired
    private UserRoleRelMapper userRoleRelMapper;

    @Test
    void getByUserId() {
        UserVO userVO = userRoleRelMapper.getByUserId(1L);
        log.info("userVO: {}", userVO);
    }
}