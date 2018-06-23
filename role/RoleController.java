package com.zjf.demo.role;

import com.zjf.demo.role.impl.RoleServiceImpl;
import com.zjf.demo.utils.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    RoleServiceImpl roleService;

    @ResponseBody
    @RequestMapping("/addRole")
    public AjaxResult addRole(Role role, List<Integer> moduleIds) {
        return roleService.addRole(role, moduleIds);
    }

    @ResponseBody
    @RequestMapping("/deleteRole")
    public AjaxResult deleteRole(Role role) {
        return roleService.deleteRole(role.getRoleId());
    }

    @ResponseBody
    @RequestMapping("/editRole")
    public AjaxResult editRole(Role role, List<Integer> moduleIds) {
        return roleService.editRole(role, moduleIds);
    }

    @ResponseBody
    @RequestMapping("/findRoles")
    public AjaxResult findRoles(Role role) {
        return roleService.findRoles(role.getRoleId());
    }

}
