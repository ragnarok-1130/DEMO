package com.lee.demo.api.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LCQ
 */
@Data
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
