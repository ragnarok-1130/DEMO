package com.lee.demo.service.intf.user;

import com.lee.demo.service.entity.user.RoleEntity;

/**
 * @author LCQ
 */
public interface RoleService {

    /**
     * 根据Id查询角色
     * @param id
     * @return
     */
    RoleEntity selectById(Long id);

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(RoleEntity role);

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    int updateRole(RoleEntity role);
}
