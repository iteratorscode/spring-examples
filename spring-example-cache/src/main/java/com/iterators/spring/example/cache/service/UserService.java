package com.iterators.spring.example.cache.service;

import com.iterators.spring.example.cache.dao.UserDao;
import com.iterators.spring.example.cache.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * User Service
 *
 * @author iterators
 * @date 2020/11/30 下午8:18
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public Boolean removeById(Long id) {
        return userDao.removeById(id);
    }
}
