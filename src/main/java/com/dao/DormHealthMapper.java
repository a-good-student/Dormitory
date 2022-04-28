package com.dao;

import com.beans.DormHealth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DormHealthMapper {
    //分页查询
    public List<DormHealth> Import(@Param("num")Integer num, @Param("count")int count, @Param("dormId") String dormId, @Param("dormName") String dormName);
    //总记录数
    public int Mount(@Param("dormId") String dormId, @Param("dormName") String dormName);

    //添加
    public void addDormHealth(@Param("id") Integer ID, @Param("dormId") String dormId, @Param("dormName") String dormName, @Param("dormHealth") String dormHealth, @Param("createTime") String createTime, @Param("updateTime") String updateTime);

    //因为添加需要最后的那个信息
    public int lastDormHealth();

    //删除
    public void deleteDormHealth(@Param("id") Integer ID);

    //修改信息
    public void modDormHealth(@Param("id") Integer ID, @Param("dormId") String dormId, @Param("dormName") String dormName, @Param("dormHealth") String dormHealth, @Param("createTime") String createTime, @Param("updateTime") String updateTime);

}
