package com.lee.demo.service.mapper;

import com.lee.demo.service.entity.user.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LCQ
 */
@Mapper
@Repository
public interface RoleMapper {
    /**
     * 根据Id查询角色
     * @param id
     * @return
     */
    RoleEntity selectById(Long id);

    /**
     * 插入（含空值）
     *
     * @param role
     * @return
     */
    int insert(RoleEntity role);

    /**
     * 插入（非空值）
     *
     * @param role
     * @return
     */
    int insertSelective(RoleEntity role);

    /**
     * 根据ID更新角色信息
     * @param role
     * @return
     */
    int updateAllById(RoleEntity role);

    /**
     * 根据ID更新角色信息
     * @param role
     * @return
     */
    int updateSelectiveById(RoleEntity role);

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    List<String> queryPermissionByUserId(@Param("userId") Long userId);
}
