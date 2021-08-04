package com.iterators.spring.example.mybatis.domain.vo;

import java.util.List;

/**
 * Role VO
 *
 * @author iterators
 * @date 2021/8/4 下午5:38
 */
public class RoleVO {

    private Long id;

    private String name;

    private List<AuthorityVO> authorities;
}
