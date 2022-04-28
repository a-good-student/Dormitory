package com.dao;

import com.beans.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {
    //分页查询
    public List<Student> Import(@Param("num")Integer num, @Param("count")int count, @Param("sname") String sname,
                                @Param("sno") String sno, @Param("classId") String classId, @Param("className") String className);
    //总记录数
    public int Mount(@Param("sname") String sname, @Param("sno") String sno, @Param("classId") String classId, @Param("className") String className);

    //添加学生
    public void addStudent(@Param("id") Integer ID,@Param("sno") String sno, @Param("sname") String sname, @Param("ssex")String ssex, @Param("sage")String sage, @Param("sphone")String sphone, @Param("classId")String classId, @Param("className")String className, @Param("dormitory")String dormitory);

    //因为添加需要最后的那个学生信息
    public int lastStudent();

    //删除
    public void deleteStudent(@Param("id") Integer ID);

    //修改学生
    public void modStudent(@Param("id") Integer ID,@Param("sno") String sno, @Param("sname") String sname, @Param("ssex")String ssex, @Param("sage")String sage, @Param("sphone")String sphone, @Param("classId")String classId, @Param("className")String className, @Param("dormitory")String dormitory);

}
