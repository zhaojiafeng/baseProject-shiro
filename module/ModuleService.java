package com.zjf.demo.module;

import com.zjf.demo.utils.AjaxResult;

public interface ModuleService {

    AjaxResult addModule(Module record);

    AjaxResult deleteModule(Integer moduleId);

    AjaxResult editModule(Module record);

    AjaxResult findModules(Module record);
}
