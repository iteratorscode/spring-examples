package com.iterators.spring.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Country entity
 *
 * @author iterators
 * @date 2021/5/19 下午12:30
 */
@Data
public class Country implements Serializable {

    private Long id;

    private String name;
}
