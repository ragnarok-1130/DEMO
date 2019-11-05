package com.lee.demo.service.mapper;

import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.service.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author LCQ
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据userId查询
     *
     * @param userId
     * @return
     */
    UserDto selectByUserId(@Param("userId") Long userId);

    /**
     * 插入（含空值）
     *
     * @param user
     * @return
     */
    int insert(UserEntity user);

    /**
     * 插入（非空值）
     *
     * @param user
     * @return
     */
    int insertSelective(UserEntity user);

    /**
     * 根据ID更新用户所有信息
     * @param user
     * @return
     */
    int updateAllById(UserEntity user);

    /**
     * 根据ID更新用户信息
     * @param user
     * @return
     */
    int updateSelectiveById(UserEntity user);

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    UserDto selectUserByUserName(@Param("username") String username);
}
