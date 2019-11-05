package com.lee.demo.service.protocol;

import com.lee.demo.api.dto.user.RoleDto;
import com.lee.demo.api.protocol.user.RoleServiceProtocol;
import com.lee.demo.service.entity.user.RoleEntity;
import com.lee.demo.service.intf.user.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LCQ
 */
@Service("roleServiceProtocol")
@Slf4j
public class RoleServiceProtocolImpl implements RoleServiceProtocol {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto selectById(Long id) {
        RoleEntity roleEntity = roleService.selectById(id);
        RoleDto dto = new RoleDto();
        BeanUtils.copyProperties(roleEntity, dto);
        return dto;
    }

    @Override
    public int addRole(RoleDto role) {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(role, roleEntity);
        return roleService.addRole(roleEntity);
    }

    @Override
    public int updateRole(RoleDto role) {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(role, roleEntity);
        return roleService.updateRole(roleEntity);
    }

    @Override
    public List<String> queryPermissionByUserId(Long userId) {
        return roleService.queryPermissionByUserId(userId);
    }
}
