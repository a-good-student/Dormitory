package com.dao;

import com.beans.Repair;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RepairMapper {
    //分页查询
    public List<Repair> Import(@Param("num")Integer num, @Param("count")int count, @Param("dormId") String dormId, @Param("dormName") String dormName);
    //总记录数
    public int Mount(@Param("dormId") String dormId, @Param("dormName") String dormName);

    //添加
    public void addRepair(@Param("id") Integer ID, @Param("dormId") String dormId, @Param("dormName") String dormName, @Param("repairMan") String repairMan, @Param("repairName") String repairName, @Param("repairTime") String repairTime, @Param("updateTime") String updateTime);

    //因为添加需要最后的那个信息
    public int lastRepair();

    //删除
    public void deleteRepair(@Param("id") Integer ID);

    //修改信息
    public void modRepair(@Param("id") Integer ID, @Param("dormId") String dormId, @Param("dormName") String dormName,@Param("repairMan") String repairMan,@Param("repairName") String repairName, @Param("repairTime") String repairTime, @Param("updateTime") String updateTime);

}
