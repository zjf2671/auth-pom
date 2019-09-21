package com.zjf.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjf.sso.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Harry
 */
@Component("sysPermissionDao")
@Mapper
public interface SysPermissionDao extends BaseMapper<SysPermission> {


}
