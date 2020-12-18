package com.iterators.spring.example.aop.component.whitelist.impl;

import com.iterators.spring.example.aop.component.whitelist.IWhitelistService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Id白名单
 *
 * @author zhanghui
 * @date 2020/12/18 下午3:18
 */
@Service
public class IdWhitelistService implements IWhitelistService {
    @Override
    public List<Object> getWhitelist() {
        return Collections.singletonList(1);
    }
}
