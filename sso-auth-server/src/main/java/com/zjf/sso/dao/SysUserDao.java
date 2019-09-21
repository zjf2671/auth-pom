package com.zjf.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjf.sso.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Harry
 */
@Component("sysUserDao")
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

}
