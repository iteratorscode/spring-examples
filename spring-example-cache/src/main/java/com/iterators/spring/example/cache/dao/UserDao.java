package com.iterators.spring.example.cache.dao;

import com.iterators.spring.example.cache.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * User Dao
 *
 * @author iterators
 * @date 2020/11/30 下午8:18
 */
@Repository
public class UserDao {

    @Cacheable(value = "user", key = "#id")
    public User getById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName(UUID.randomUUID().toString());
        return user;
    }
}
