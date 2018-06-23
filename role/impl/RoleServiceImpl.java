package com.zjf.demo.role.impl;

import com.zjf.demo.module.Module;
import com.zjf.demo.module.ModuleMapper;
import com.zjf.demo.role.Role;
import com.zjf.demo.role.RoleMapper;
import com.zjf.demo.role.RoleService;
import com.zjf.demo.utils.AjaxResult;
import com.zjf.demo.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Resource
    ModuleMapper moduleMapper;

    @Override
    public AjaxResult addRole(Role role, List<Integer> moduleIds) {

        roleMapper.addRole(role);
        moduleMapper.addRoleIdAndModuleIds(role.getRoleId(), moduleIds);
        return new AjaxResult("添加成功");

    }

    @Override
    public AjaxResult deleteRole(Integer roleId) {

        List<Integer> list = new LinkedList<>();
        list.add(roleId);
        roleMapper.deleteRole(roleId);
        roleMapper.deleteAdminIdAndRoleIds(null, list);
        moduleMapper.deleteRoleIdAndModuleIds(roleId, null);
        return new AjaxResult("删除成功");

    }

    @Override
    public AjaxResult editRole(Role role, List<Integer> newModuleIds) {
        List<Integer> oldModuleIds = new LinkedList<>();

        List<Integer> roleIds = new LinkedList<>();
        roleIds.add(role.getRoleId());

        List<Module> moduleList = moduleMapper.findModuleIdsInRoleModule(roleIds);
        for (Module module: moduleList) {
            oldModuleIds.add(module.getModuleId());
        }
//
        moduleMapper.addRoleIdAndModuleIds(role.getRoleId(), Tools.addList(oldModuleIds, newModuleIds));
        moduleMapper.deleteRoleIdAndModuleIds(role.getRoleId(), Tools.deleteList(oldModuleIds, newModuleIds));
        roleMapper.editRole(role);

        return new AjaxResult("编辑成功");
    }

    @Override
    public AjaxResult findRoles(Integer roleId) {
        List<Role> roleList = roleMapper.findRoles(roleId);
        return new AjaxResult(roleList);
    }

}
