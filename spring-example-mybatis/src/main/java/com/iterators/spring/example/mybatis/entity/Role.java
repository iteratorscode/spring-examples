package com.iterators.spring.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author iterators
 * @since 2021/08/03
 */
@Data
public class Role implements Serializable {

    private Long id;

    private String name;

    private Long authorityId;
}
