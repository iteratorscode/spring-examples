package com.example.security.service;

import com.example.security.dao.StudentDao;
import com.example.security.entity.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 加载用户名和密码
 *
 * @author iterators
 * @date 2021.04.18
 */
@Component
@AllArgsConstructor
@Slf4j
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final StudentDao studentDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("loadUserByUsername: {}", s);
        // 获取用户信息
        Student student = studentDao.loadEntityByUsername(s);
        if (Objects.isNull(student)) {
            throw new UsernameNotFoundException(s);
        }
        // 获取用户权限信息
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        return new User(student.getUserName(), new BCryptPasswordEncoder().encode(student.getPassword()), auths);
    }
}
