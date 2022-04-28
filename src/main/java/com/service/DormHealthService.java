package com.service;

import com.beans.DormHealth;
import com.dao.DormHealthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormHealthService {
    public static int counts=6;

    @Autowired
    private DormHealthMapper dormHealthMapper;
    //分页查询
    public List<DormHealth> Import(Integer num, String dormId, String dormName){
        List<DormHealth> dormHealth=dormHealthMapper.Import((num-1)*counts, counts,dormId,dormName);
        return dormHealth;
    }
    //总记录数
    public int Mount(String dormId, String dormName){
        return dormHealthMapper.Mount(dormId,dormName);
    }
    //添加学生
    public int addDormHealth(String dormId, String dormName, String dormHealth, String createTime, String updateTime){
        int id=(dormHealthMapper.lastDormHealth()+1);
        dormHealthMapper.addDormHealth(id,dormId,dormName,dormHealth,createTime,updateTime);
        return id;
    }
    //删除学生
    public void deleteDormHealth(int id){
        dormHealthMapper.deleteDormHealth(id);
    }
    //修改学生信息
    public int modDormHealth(int id, String dormId, String dormName, String dormHealth, String createTime, String updateTime){
        dormHealthMapper.modDormHealth(id,dormId,dormName,dormHealth,createTime,updateTime);
        return id;
    }
}
