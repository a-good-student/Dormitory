package com.dao;

import com.beans.StudentHealth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentHealthMapper {
    //分页查询
    public List<StudentHealth> Import(@Param("num")Integer num, @Param("count")int count, @Param("sno") String sno, @Param("sname") String sname, @Param("dormId") String dormId);
    //总记录数
    public int Mount(@Param("sno") String sno, @Param("sname") String sname, @Param("dormId") String dormId);

    //添加
    public void addStudentHealth(@Param("id") Integer ID, @Param("sno") String sno, @Param("sname") String sname, @Param("studentHealth") String studentHealth, @Param("classId") String classId, @Param("dormId") String dormId, @Param("createTime") String createTime, @Param("updateTime") String updateTime);

    //因为添加需要最后的那个信息
    public int lastStudentHealth();

    //删除
    public void deleteStudentHealth(@Param("id") Integer ID);

    //修改信息
    public void modStudentHealth(@Param("id") Integer ID, @Param("sno") String sno, @Param("sname") String sname, @Param("studentHealth") String studentHealth, @Param("classId") String classId, @Param("dormId") String dormId, @Param("createTime") String createTime, @Param("updateTime") String updateTime);

}
