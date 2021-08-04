package com.iterators.spring.example.mybatis.mapper;

import com.iterators.spring.example.mybatis.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iterators
 * @since 2021/08/03
 */
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id 用户id
     */
    UserDO getById(Long id);

    /**
     * 根据id批量查询用户信息
     *
     * @param ids 用户id集合
     */
    List<UserDO> listByIds(@Param("ids") List<Long> ids);
}
