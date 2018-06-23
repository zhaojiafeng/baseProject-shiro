package com.zjf.demo.module.impl;

import com.zjf.demo.module.Module;
import com.zjf.demo.module.ModuleMapper;
import com.zjf.demo.module.ModuleService;
import com.zjf.demo.utils.AjaxResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

    @Resource
    ModuleMapper moduleMapper;

    @Override
    public AjaxResult addModule(Module record) {
        moduleMapper.addModule(record);
        return new AjaxResult("添加成功");
    }

    @Override
    public AjaxResult deleteModule(Integer moduleId) {
        moduleMapper.deleteModule(moduleId);
        List<Integer> list = new ArrayList<>();
        list.add(moduleId);
        moduleMapper.deleteRoleIdAndModuleIds(null,list);
        return new AjaxResult("删除成功");
    }

    @Override
    public AjaxResult editModule(Module record) {
        moduleMapper.editModule(record);
        return new AjaxResult("编辑成功");
    }

    @Override
    public AjaxResult findModules(Module record) {
        List<Module> moduleList = moduleMapper.findModules(record);
        return new AjaxResult(moduleList);
    }
}
