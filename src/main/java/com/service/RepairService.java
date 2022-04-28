package com.service;

import com.beans.Repair;
import com.dao.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    public static int counts=6;

    @Autowired
    private RepairMapper repairMapper;
    //分页查询
    public List<Repair> Import(Integer num, String dormId, String dormName){
        List<Repair> repair=repairMapper.Import((num-1)*counts, counts,dormId,dormName);
        return repair;
    }
    //总记录数
    public int Mount(String dormId, String dormName){
        return repairMapper.Mount(dormId,dormName);
    }
    //添加学生
    public int addRepair(String dormId, String dormName, String repairMan, String repairName, String repairTime, String updateTime){
        int id=(repairMapper.lastRepair()+1);
        repairMapper.addRepair(id,dormId,dormName,repairMan,repairName,repairTime,updateTime);
        return id;
    }
    //删除学生
    public void deleteRepair(int id){
        repairMapper.deleteRepair(id);
    }
    //修改学生信息
    public int modRepair(int id, String dormId, String dormName, String repairMan, String repairName, String repairTime, String updateTime){
        repairMapper.modRepair(id,dormId,dormName,repairMan,repairName,repairTime,updateTime);
        return id;
    }
}
