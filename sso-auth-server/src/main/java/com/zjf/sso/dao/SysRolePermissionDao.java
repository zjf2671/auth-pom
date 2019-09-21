package com.zjf.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjf.sso.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Harry
 */
@Component("sysRolePermissionDao")
@Mapper
public interface SysRolePermissionDao extends BaseMapper<SysRolePermission> {

}
