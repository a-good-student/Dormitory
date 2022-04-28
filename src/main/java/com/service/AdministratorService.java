package com.service;

import com.beans.Administrator;
import com.beans.StudentHealth;
import com.beans.User;
import com.dao.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdministratorService {
    public static int counts=6;

    @Autowired
    private AdministratorMapper administratorMapper;
    //分页查询
    public List<Administrator> Import(Integer num, String adminName, String rank){
        List<Administrator> admin=administratorMapper.Import((num-1)*counts, counts,adminName,rank);
        return admin;
    }
    //总记录数
    public int Mount(String adminName, String rank){
        return administratorMapper.Mount(adminName,rank);
    }
    //添加学生
    public int addAdmin(String adminName,String name,String adminPhone,String rank,String adminTime){
        int id=(administratorMapper.lastAdmin()+1);
        administratorMapper.addAdmin(id,adminName,"",name,adminPhone,rank,adminTime);
        return id;
    }
    //删除学生
    public void deleteAdmin(int id){
        administratorMapper.deleteAdmin(id);
    }
    //修改学生信息
    public int modAdmin(int id,String adminName,String name,String adminPhone,String rank,String adminTime){
        administratorMapper.modAdmin(id,adminName,name,adminPhone,rank,adminTime);
        return id;
    }

    //登录
    public int searchUser(String adminName,String password,HttpSession session){
        User user=administratorMapper.searchUser(adminName,password);
        System.out.println(user);
        if(user==null){
            return 1;
        }
        else{
            if(session.getAttribute(adminName)!=null){
                return 2;
            }
        }
        session.setAttribute("admin",user);
        session.setAttribute("user",user.getName());
        return 0;
    }
    //注册

}
