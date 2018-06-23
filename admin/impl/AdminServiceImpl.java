package com.zjf.demo.admin.impl;

import com.zjf.demo.admin.Admin;
import com.zjf.demo.admin.AdminMapper;
import com.zjf.demo.admin.AdminService;
import com.zjf.demo.role.Role;
import com.zjf.demo.role.RoleMapper;
import com.zjf.demo.utils.AjaxResult;
import com.zjf.demo.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public AjaxResult addAdmin(Admin admin, List<Integer> roleIds) {
        adminMapper.addAdmin(admin);
        roleMapper.addAdminIdAndRoleIds(admin.getAdminId(), roleIds);
        return new AjaxResult("编辑成功");
    }

    @Override
    public AjaxResult deleteAdmin(Admin admin) {
        adminMapper.deleteAdmin(admin.getAdminId());
        roleMapper.deleteAdminIdAndRoleIds(admin.getAdminId(), null);
        return new AjaxResult("删除成功");
    }

    @Override
    public AjaxResult editAdmin(Admin admin, List<Integer> roleIds) {

        List<Integer> oldRoleIds = new LinkedList<>();
        List<Role> moduleList = roleMapper.findRoleIdsInAdminRole(admin.getAdminId());
        for (Role role: moduleList) {
            oldRoleIds.add(role.getRoleId());
        }
        roleMapper.addAdminIdAndRoleIds(admin.getAdminId(), Tools.addList(oldRoleIds,roleIds));
        roleMapper.deleteAdminIdAndRoleIds(admin.getAdminId(),Tools.deleteList(oldRoleIds,roleIds));
        adminMapper.editAdmin(admin);
        return new AjaxResult("编辑成功");
    }

    @Override
    public AjaxResult findAdmins(Admin admin) {
        List<Admin> adminList = adminMapper.findAdmins(admin);
        return new AjaxResult(adminList);
    }

}
