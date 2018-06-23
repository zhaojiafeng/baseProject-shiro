package com.zjf.demo.admin;

import com.zjf.demo.utils.AjaxResult;
import com.zjf.demo.admin.impl.AdminServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

//    @Value("${mineDefine.name}")
//    private String name;
//
//    @RequestMapping("/hello")
//    public String hello() {
//        return name + " : " + "hello world!";
//    }

    @Resource
    AdminServiceImpl adminService;

//    注解的使用
    @ResponseBody
    @RequiresRoles("manager")
    @RequiresPermissions("manage")
    @RequestMapping("/addAdmin")
    public AjaxResult addAdmin(Admin admin, List<Integer> roleIds) {
        return adminService.addAdmin(admin, roleIds);
    }

    @ResponseBody
    @RequestMapping("/deleteAdmin")
    public AjaxResult deleteAdmin(Admin admin) {
        return adminService.deleteAdmin(admin);
    }

    @ResponseBody
    @RequestMapping("/editAdmin")
    public AjaxResult editAdmin(Admin admin, List<Integer> roleIds) {
        return adminService.editAdmin(admin, roleIds);
    }

    @ResponseBody
    @RequestMapping("/findAdmins")
    public AjaxResult findAdmins(Admin admin) {
        return adminService.findAdmins(admin);
    }


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //post登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody Map map){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                map.get("username").toString(),
                map.get("password").toString());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "error ok!";
    }


}
