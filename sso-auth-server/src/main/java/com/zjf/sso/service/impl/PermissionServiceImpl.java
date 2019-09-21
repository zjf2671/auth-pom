package com.zjf.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjf.sso.dao.*;
import com.zjf.sso.entity.SysPermission;
import com.zjf.sso.entity.SysRolePermission;
import com.zjf.sso.entity.SysUserRole;
import com.zjf.sso.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Harry
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRolePermissionDao sysRolePermissionDao;
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        List<SysUserRole> sysUserRoleList = sysUserRoleDao.selectList(new QueryWrapper<SysUserRole>().eq("user_id", userId));
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> rolePermissionList = sysRolePermissionDao
                .selectList(new QueryWrapper<SysRolePermission>().in(StringUtils.isEmpty(roleIdList),"role_id", roleIdList));
        if (CollectionUtils.isEmpty(rolePermissionList)) {
            return null;
        }
        List<Integer> permissionIdList = rolePermissionList.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        List<SysPermission> sysPermissionList = sysPermissionDao.selectBatchIds(permissionIdList);
        if (CollectionUtils.isEmpty(sysPermissionList)) {
            return null;
        }
        return sysPermissionList;
    }
}