package com.dao;

import com.beans.Administrator;
import com.beans.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorMapper {
    //分页查询
    public List<Administrator> Import(@Param("num")Integer num, @Param("count")int count, @Param("adminName") String adminName, @Param("rank") String rank);
    //总记录数
    public int Mount(@Param("adminName") String adminName, @Param("rank") String rank);

    //添加
    public void addAdmin(@Param("id") Integer ID, @Param("adminName") String adminName, @Param("password") String password, @Param("name") String name, @Param("adminPhone") String adminPhone, @Param("rank") String rank, @Param("adminTime") String adminTime);

    //因为添加需要最后的那个信息
    public int lastAdmin();

    //删除
    public void deleteAdmin(@Param("id") Integer ID);

    //修改信息
    public void modAdmin(@Param("id") Integer ID, @Param("adminName") String adminName, @Param("name") String name, @Param("adminPhone") String adminPhone, @Param("rank") String rank, @Param("adminTime") String adminTime);


    //登录
    public User searchUser(@Param("adminName") String adminName, @Param("password") String password);
}
