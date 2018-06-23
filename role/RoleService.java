package com.zjf.demo.role;

import com.zjf.demo.utils.AjaxResult;

import java.util.List;

public interface RoleService {

    AjaxResult addRole(Role role, List<Integer> moduleIds);

    AjaxResult deleteRole(Integer roleId);

    AjaxResult editRole(Role role, List<Integer> moduleIds);

    AjaxResult findRoles(Integer roleId);

}
