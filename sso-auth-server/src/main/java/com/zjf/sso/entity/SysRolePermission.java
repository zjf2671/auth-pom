package com.zjf.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Harry
 */
@Data
@TableName("sys_role_permission")
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 7402412601579098788L;

    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}
