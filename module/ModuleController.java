package com.zjf.demo.module;

import com.zjf.demo.module.impl.ModuleServiceImpl;
import com.zjf.demo.utils.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Resource
    ModuleServiceImpl moduleService;

    @ResponseBody
    @RequestMapping("/addModule")
    public AjaxResult addModule(Module module){
        return moduleService.addModule(module);
    }

    @ResponseBody
    @RequestMapping("/deleteModule")
    public AjaxResult deleteModule(Module module){
        return moduleService.deleteModule(module.getModuleId());
    }

    @ResponseBody
    @RequestMapping("/editModule")
    public AjaxResult editModule(Module module){
        return moduleService.editModule(module);
    }

    @ResponseBody
    @RequestMapping("/findModules")
    public AjaxResult findModules(Module module){
        return moduleService.findModules(module);
    }

}
