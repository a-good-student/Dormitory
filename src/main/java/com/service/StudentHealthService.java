package com.service;

import com.beans.StudentHealth;
import com.dao.StudentHealthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentHealthService {
    public static int counts=6;

    @Autowired
    private StudentHealthMapper studentHealthMapper;
    //分页查询
    public List<StudentHealth> Import(Integer num, String sno,String sname, String dormId){
        List<StudentHealth> studentHealth=studentHealthMapper.Import((num-1)*counts, counts,sno,sname,dormId);
        return studentHealth;
    }
    //总记录数
    public int Mount(String sno,String sname, String dormId){
        return studentHealthMapper.Mount(sno,sname,dormId);
    }
    //添加学生
    public int addStudentHealth(String sno,String sname,String studentHealth,String classId,String dormId, String createTime, String updateTime){
        int id=(studentHealthMapper.lastStudentHealth()+1);
        studentHealthMapper.addStudentHealth(id,sno,sname,studentHealth,classId,dormId,createTime,updateTime);
        return id;
    }
    //删除学生
    public void deleteStudentHealth(int id){
        studentHealthMapper.deleteStudentHealth(id);
    }
    //修改学生信息
    public int modStudentHealth(int id, String sno,String sname,String studentHealth,String classId,String dormId, String createTime, String updateTime){
        studentHealthMapper.modStudentHealth(id,sno,sname,studentHealth,classId,dormId,createTime,updateTime);
        return id;
    }
}
