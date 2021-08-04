package com.iterators.spring.example.mybatis.domain;

import lombok.Data;

/**
 * User DO
 *
 * @author iterators
 * @date 2021/8/4 下午4:16
 */
@Data
public class UserDO {

    private Long id;

    private String name;

    private String password;

    private RoleDO role;

}
