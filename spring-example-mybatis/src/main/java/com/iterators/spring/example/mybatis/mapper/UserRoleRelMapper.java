package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.domain.vo.UserVO;

/**
 * User Role 关系表
 *
 * @author iterators
 * @since 2021/08/03
 */
public interface UserRoleRelMapper {

    UserVO getByUserId(Long userId);
}
