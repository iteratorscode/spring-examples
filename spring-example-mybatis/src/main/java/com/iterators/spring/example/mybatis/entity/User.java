package com.iterators.spring.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author iterators
 * @since 2021/08/03
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String password;

    private Long roleId;

}
