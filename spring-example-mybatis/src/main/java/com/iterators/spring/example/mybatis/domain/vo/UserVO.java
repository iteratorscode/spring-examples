package com.iterators.spring.example.mybatis.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * User VO
 *
 * @author iterators
 * @date 2021/8/4 下午5:36
 */
@Data
public class UserVO {

    private Long id;

    private String name;

    private String password;

    private List<RoleVO> roles;
}
