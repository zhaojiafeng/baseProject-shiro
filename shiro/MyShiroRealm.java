package com.zjf.demo.shiro;

import com.zjf.demo.admin.Admin;
import com.zjf.demo.admin.AdminMapper;
import com.zjf.demo.admin.AdminService;
import com.zjf.demo.admin.impl.AdminServiceImpl;
import com.zjf.demo.module.Module;
import com.zjf.demo.module.ModuleMapper;
import com.zjf.demo.module.ModuleService;
import com.zjf.demo.module.impl.ModuleServiceImpl;
import com.zjf.demo.role.Role;
import com.zjf.demo.role.RoleMapper;
import com.zjf.demo.role.RoleService;
import com.zjf.demo.role.impl.RoleServiceImpl;
import com.zjf.demo.utils.Tools;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    ModuleMapper moduleMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();

        Admin admin = new Admin();
        admin.setAdminName(name);
        //查询用户名称
        List<Admin> adminList = adminMapper.findAdmins(admin);
        List<Role> roleList = roleMapper.findRoleIdsInAdminRole(adminList.get(0).getAdminId());
//        不清楚此处的权限是否需要去重
        List<Module> moduleList = moduleMapper.findModuleIdsInRoleModule(Tools.getRoleIds(roleList));
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role:roleList) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (Module module:moduleList) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(module.getModuleName());
            }
        }
        return simpleAuthorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();

        Admin admin = new Admin();
        admin.setAdminName(name);

        List<Admin> adminList = adminMapper.findAdmins(admin);

        if (adminList.isEmpty()) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, adminList.get(0).getPassword(), getName());
            return simpleAuthenticationInfo;
        }
    }

}
