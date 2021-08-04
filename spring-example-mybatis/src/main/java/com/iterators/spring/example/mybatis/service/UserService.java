package com.iterators.spring.example.mybatis.service;

import com.iterators.spring.example.mybatis.domain.UserDO;
import com.iterators.spring.example.mybatis.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 添加类描述信息
 *
 * @author iterators
 * @date 2021/8/4 下午4:24
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserDO getById(Long id) {
        return userMapper.getById(id);
    }

}
