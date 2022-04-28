package com.service;

import com.beans.Dorm;
import com.dao.DormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormService {
    public static int counts=6;

    @Autowired
    private DormMapper dormMapper;
    //分页查询
    public List<Dorm> Import(Integer num, String dormId, String dormName, String admin){
        List<Dorm> dorm=dormMapper.Import((num-1)*counts, counts,dormId,dormName,admin);
        return dorm;
    }
    //总记录数
    public int Mount(String dormId, String dormName, String admin){
        return dormMapper.Mount(dormId,dormName,admin);
    }
    //添加学生
    public int addDorm(String dormId, String dormName, String bedNum, String bedUse, String admin){
        int id=(dormMapper.lastDorm()+1);
        dormMapper.addDorm(id,dormId,dormName,bedNum,bedUse,admin);
        return id;
    }
    //删除学生
    public void deleteDorm(int id){
        dormMapper.deleteDorm(id);
    }
    //修改学生信息
    public int modClass(int id, String dormId, String dormName, String bedNum, String bedUse, String admin){
        dormMapper.modDorm(id,dormId,dormName,bedNum,bedUse,admin);
        return id;
    }
}
