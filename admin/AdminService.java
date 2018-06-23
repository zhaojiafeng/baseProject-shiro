package com.zjf.demo.admin;

import com.zjf.demo.utils.AjaxResult;

import java.util.List;

public interface AdminService {

    AjaxResult addAdmin(Admin admin, List<Integer> roleIds);

    AjaxResult deleteAdmin(Admin admin);

    AjaxResult editAdmin(Admin admin, List<Integer> roleIds);

    AjaxResult findAdmins(Admin admin);


}
