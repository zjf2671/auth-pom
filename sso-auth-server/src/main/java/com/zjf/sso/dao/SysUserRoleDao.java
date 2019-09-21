package com.zjf.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjf.sso.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Harry
 */
@Component("sysUserRoleDao")
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}
