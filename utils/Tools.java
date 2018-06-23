package com.zjf.demo.utils;

import com.zjf.demo.module.Module;
import com.zjf.demo.role.Role;

import java.util.LinkedList;
import java.util.List;

public class Tools {

    public static List<Integer> addList(List<Integer> oldList,List<Integer> newList){
        List<Integer> addList = new LinkedList<>();
        for (Integer id : newList){
            if (!oldList.contains(id)){
                addList.add(id);
            }
            continue;
        }
        return addList;
    }

    public static List<Integer> deleteList(List<Integer> oldList,List<Integer> newList){
        List<Integer> deleteList = new LinkedList<>();
        for (Integer id : oldList){
            if (!newList.contains(id)){
                deleteList.add(id);
            }
            continue;
        }
        return deleteList;
    }

    public static List<Integer> getRoleIds(List<Role> roleList){
        List<Integer> roleIds = new LinkedList<>();

        for (Role role : roleList){
            roleIds.add(role.getRoleId());
        }

        return roleIds;
    }

    public static List<Integer> getModuleIds(List<Module> moduleList){
        List<Integer> roleIds = new LinkedList<>();

        for (Module module : moduleList){
            roleIds.add(module.getModuleId());
        }

        return roleIds;
    }
}
