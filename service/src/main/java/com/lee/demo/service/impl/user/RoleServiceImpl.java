package com.lee.demo.service.impl.user;

import com.lee.demo.service.entity.user.RoleEntity;
import com.lee.demo.service.intf.user.RoleService;
import com.lee.demo.service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LCQ
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleEntity selectById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int addRole(RoleEntity role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateRole(RoleEntity role) {
        return roleMapper.updateAllById(role);
    }

    @Override
    public List<String> queryPermissionByUserId(Long roleId) {
        return roleMapper.queryPermissionByUserId(roleId);
    }
}
