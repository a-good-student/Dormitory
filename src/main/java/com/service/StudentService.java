package com.service;

import com.beans.Student;
import com.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public static int counts=6;

    @Autowired
    private StudentMapper studentMapper;
    //分页查询
    public List<Student> Import(Integer num,String sname,String sno,String classId,String className){
        List<Student> students=studentMapper.Import((num-1)*counts, counts,sname,sno,classId,className);
        return students;
    }
    //总记录数
    public int Mount(String sname,String sno,String classId,String className){
        return studentMapper.Mount(sname,sno,classId,className);
    }
    //添加学生
    public int addStudent(String sno, String sname, String ssex, String sage, String sphone, String classId, String className, String dormitory){
        int id=(studentMapper.lastStudent()+1);
        studentMapper.addStudent(id,sno,sname,ssex,sage,sphone,classId,className,dormitory);
        return id;
    }
    //删除学生
    public void deleteStudent(int id){
        studentMapper.deleteStudent(id);
    }
    //修改学生信息
    public int modStudent(int id,String sno, String sname, String ssex, String sage, String sphone, String classId, String className, String dormitory){
        studentMapper.modStudent(id,sno,sname,ssex,sage,sphone,classId,className,dormitory);
        return id;
    }
}
