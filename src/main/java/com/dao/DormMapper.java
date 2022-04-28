package com.dao;

import com.beans.Dorm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DormMapper {
    //分页查询
    public List<Dorm> Import(@Param("num")Integer num, @Param("count")int count, @Param("dormId") String dormId, @Param("dormName") String dormName, @Param("admin") String admin);
    //总记录数
    public int Mount(@Param("dormId") String dormId, @Param("dormName") String dormName, @Param("admin") String admin);

    //添加班级
    public void addDorm(@Param("id") Integer ID, @Param("dormId") String dormId, @Param("dormName") String dormName,@Param("bedNum") String bedNum,@Param("bedUse") String bedUse, @Param("admin") String admin);

    //因为添加需要最后的那个班级信息
    public int lastDorm();

    //删除
    public void deleteDorm(@Param("id") Integer ID);

    //修改班级信息
    public void modDorm(@Param("id") Integer ID, @Param("dormId") String dormId, @Param("dormName") String dormName,@Param("bedNum") String bedNum,@Param("bedUse") String bedUse, @Param("admin") String admin);

}
