package com.zjf.demo.role;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    int addRole(Role record);

    int deleteRole(Integer roleId);

    int editRole(Role record);

    List<Role> findRoles(Integer roleId);

    int addAdminIdAndRoleIds(@Param("adminId") Integer adminId, List<Integer> roleIds);

    int deleteAdminIdAndRoleIds(@Param("adminId") Integer adminId, List<Integer> roleIds);

    List<Role> findRoleIdsInAdminRole(@Param("adminId") Integer adminId);

}