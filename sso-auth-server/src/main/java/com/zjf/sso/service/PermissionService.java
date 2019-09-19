package com.zjf.sso.service;


import com.zjf.sso.entity.SysPermission;

import java.util.List;

/**
 * @author Harry
 */
public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

}