package com.lee.demo.api.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LCQ
 */
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * 唯一ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 显示名称
     */
    private String displayName;
}
