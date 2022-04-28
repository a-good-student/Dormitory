package com.service;

import com.beans.Classes;
import com.dao.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    public static int counts=6;

    @Autowired
    private ClassMapper classMapper;
    //分页查询
    public List<Classes> Import(Integer num, String classId, String className, String teacher){
        List<Classes> classes=classMapper.Import((num-1)*counts, counts,classId,className,teacher);
        return classes;
    }
    //总记录数
    public int Mount(String classId,String className,String teacher){
        return classMapper.Mount(classId,className,teacher);
    }
    //添加学生
    public int addClass(String classId, String className, String teacher){
        int id=(classMapper.lastClass()+1);
        classMapper.addClass(id,classId,className,teacher);
        return id;
    }
    //删除学生
    public void deleteClass(int id){
        classMapper.deleteClass(id);
    }
    //修改学生信息
    public int modClass(int id, String classId, String className, String teacher){
        classMapper.modClass(id,classId,className,teacher);
        return id;
    }
}
