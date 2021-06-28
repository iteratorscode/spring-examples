package com.iterators.spring.example.aop.component.whitelist;

import java.util.List;

/**
 * 白名单服务
 *
 * @author iterators
 * @date 2020/12/18 下午3:16
 */
public interface IWhitelistService {

    /**
     * 获取白名单
     */
    List<Object> getWhitelist();
}
