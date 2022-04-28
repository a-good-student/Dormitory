package com.service;

import com.beans.Visitor;
import com.dao.VisitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    public static int counts=6;

    @Autowired
    private VisitorMapper visitorMapper;
    //分页查询
    public List<Visitor> Import(Integer num, String vname, String vphone){
        List<Visitor> visitors=visitorMapper.Import((num-1)*counts, counts,vname,vphone);
        return visitors;
    }
    //总记录数
    public int Mount(String vname, String vphone){
        return visitorMapper.Mount(vname,vphone);
    }
    //添加学生
    public int addVisitor(String vname, String vphone, String dormId, String dormName, String visitTime){
        int id=(visitorMapper.lastVisitor()+1);
        visitorMapper.addVisitor(id,vname,vphone,dormId,dormName,visitTime);
        return id;
    }
    //删除学生
    public void deleteVisitor(int id){
        visitorMapper.deleteVisitor(id);
    }
    //修改学生信息
    public int modVisitor(int id, String vname, String vphone, String dormId, String dormName, String visitTime){
        visitorMapper.modVisitor(id,vname,vphone,dormId,dormName,visitTime);
        return id;
    }
}
