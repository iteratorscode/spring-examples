package com.iterators.spring.example.cache.dao;

import com.iterators.spring.example.cache.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
@CacheConfig(cacheNames = {"users"})
public class UserDao {

    @Cacheable(key = "#id")
    public User getById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName(UUID.randomUUID().toString());
        return user;
    }

    @CacheEvict(key = "#id", allEntries = true, beforeInvocation = true)
    public Boolean removeById(Long id) {
        return Boolean.TRUE;
    }
}
