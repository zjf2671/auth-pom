package com.zjf.common.security.service;

import com.zjf.common.core.constant.SecurityConstants;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @Description 用户详细信息
 * @Author Harry
 * @Date 2019/9/5 14:32
 **/
@Service
public class ZjfUserDetailsServiceImpl implements UserDetailsService{

    /**
     * 用户密码登录
     *
     * @param username 用户名
     * @return
     */
    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username){
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //todo 从数据库中查找用户信息和相关角色信息

        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(SecurityConstants.ROLE + "role-1");

        // 构造security用户
        return new AuthUser(1, 1, username, new BCryptPasswordEncoder().encode("123456"),
                true, true, true, true, authorities);
    }


}
