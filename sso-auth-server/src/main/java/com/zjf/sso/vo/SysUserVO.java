package com.zjf.sso.vo;

import com.zjf.sso.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author Harry
 */
@Data
public class SysUserVO extends SysUser {

    /**
     * 权限列表
     */
    private List<String> authorityList;

}
