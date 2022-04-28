package com.dao;

import com.beans.Classes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClassMapper {
    //分页查询
    public List<Classes> Import(@Param("num")Integer num, @Param("count")int count, @Param("classId") String classId, @Param("className") String className, @Param("teacher") String teacher);
    //总记录数
    public int Mount(@Param("classId") String classId, @Param("className") String className, @Param("teacher") String teacher);

    //添加班级
    public void addClass(@Param("id") Integer ID, @Param("classId")String classId, @Param("className")String className, @Param("teacher")String teacher);

    //因为添加需要最后的那个班级信息
    public int lastClass();

    //删除
    public void deleteClass(@Param("id") Integer ID);

    //修改班级信息
    public void modClass(@Param("id") Integer ID, @Param("classId")String classId, @Param("className")String className, @Param("teacher")String teacher);

}
