package com.lee.demo.api.protocol.user;

import com.lee.demo.api.dto.user.RoleDto;

import java.util.List;

/**
 * @author LCQ
 */
public interface RoleServiceProtocol {

    /**
     * 根据Id查询角色
     * @param id
     * @return
     */
    RoleDto selectById(Long id);

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(RoleDto role);

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    int updateRole(RoleDto role);

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    List<String> queryPermissionByUserId(Long userId);
}
