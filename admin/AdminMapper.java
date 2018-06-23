package com.zjf.demo.admin;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdminMapper {
    
    int addAdmin(Admin admin);

    int deleteAdmin(Integer adminId);

    int editAdmin(Admin admin);

    List<Admin> findAdmins(Admin admin);



    
}