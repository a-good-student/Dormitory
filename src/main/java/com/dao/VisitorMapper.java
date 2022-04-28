package com.dao;

import com.beans.Visitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VisitorMapper {
    //分页查询
    public List<Visitor> Import(@Param("num")Integer num, @Param("count")int count, @Param("vname") String vname, @Param("vphone") String vphone);
    //总记录数
    public int Mount(@Param("vname") String vname, @Param("vphone") String vphone);

    //添加
    public void addVisitor(@Param("id") Integer ID, @Param("vname") String vname, @Param("vphone") String vphone, @Param("dormId") String dormId, @Param("dormName") String dormName, @Param("visitTime") String visitTime);

    //因为添加需要最后的那个信息
    public int lastVisitor();

    //删除
    public void deleteVisitor(@Param("id") Integer ID);

    //修改信息
    public void modVisitor(@Param("id") Integer ID, @Param("vname") String vname, @Param("vphone") String vphone, @Param("dormId") String dormId, @Param("dormName") String dormName, @Param("visitTime") String visitTime);

}
