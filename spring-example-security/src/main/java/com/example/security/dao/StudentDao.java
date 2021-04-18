package com.example.security.dao;

import com.example.security.entity.Student;

/**
 * 实体操作类
 *
 * @author iterators
 * @since 2021/4/18 14:40
 */
public interface StudentDao {

    /**
     * 通过用户名加载entity
     *
     * @param userName 用户名
     * @return 实体
     */
    Student loadEntityByUsername(String userName);
}
