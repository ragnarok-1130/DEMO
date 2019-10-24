package com.lee.demo.service.entity.user;

import lombok.Data;

/**
 * @author LCQ
 */
@Data
public class UserEntity {
    /**
     * 唯一ID
     */
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 显示名称
     */
    private String displayName;
}
