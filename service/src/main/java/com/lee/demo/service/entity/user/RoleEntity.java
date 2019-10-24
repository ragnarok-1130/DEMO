package com.lee.demo.service.entity.user;

import lombok.Data;

/**
 * @author LCQ
 */
@Data
public class RoleEntity {
    /**
     * 角色主键ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色代码
     */
    private String roleCode;
    /**
     * 备注
     */
    private String remark;
}
