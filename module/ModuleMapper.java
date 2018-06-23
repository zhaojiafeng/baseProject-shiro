package com.zjf.demo.module;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModuleMapper {

    int addModule(Module module);

    int deleteModule(Integer moduleId);

    int editModule(Module module);

    List<Module> findModules(Module module);

    int addRoleIdAndModuleIds(@Param("roleId") Integer roleId, List<Integer> moduleIds);

    int deleteRoleIdAndModuleIds(@Param("roleId") Integer roleId, List<Integer> moduleIds);

    List<Module> findModuleIdsInRoleModule(@Param("roleIds") List<Integer> roleIds);

}