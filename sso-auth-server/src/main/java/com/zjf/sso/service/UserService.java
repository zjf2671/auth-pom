package com.zjf.sso.service;


import com.zjf.sso.entity.SysUser;

/**
 * @author Harry
 */
public interface UserService {

    /**
     * @param username
     * @return
     */
    SysUser getByUsername(String username);
}