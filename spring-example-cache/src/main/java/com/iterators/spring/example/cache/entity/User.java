package com.iterators.spring.example.cache.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户 Entity
 *
 * @author iterators
 * @date 2020/11/30 下午8:21
 */
@Data
@NoArgsConstructor
public class User {

    private Long id;

    private String name;
}
