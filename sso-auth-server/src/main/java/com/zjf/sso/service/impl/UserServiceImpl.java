package com.zjf.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjf.sso.dao.SysUserDao;
import com.zjf.sso.entity.SysUser;
import com.zjf.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Harry
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserDao.selectOne(new QueryWrapper<SysUser>().eq("username", username));
    }
}