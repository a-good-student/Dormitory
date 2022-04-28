package com.controllers;

import com.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    //导入学生表数据
    @RequestMapping(value="/visitorImport",method={RequestMethod.POST})
    @ResponseBody
    public List Import(Integer num, String vname, String vphone) {
        return visitorService.Import(num,vname,vphone);
    }

    //总记录数
    @RequestMapping(value="/visitorMount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String vname, String vphone) {
        return visitorService.Mount(vname,vphone);
    }

    //添加
    @RequestMapping(value="/addVisitor",method={RequestMethod.POST})
    @ResponseBody
    public int addVisitor(String vname, String vphone, String dormId, String dormName, String visitTime) {
        return visitorService.addVisitor(vname,vphone,dormId,dormName,visitTime);
    }
}
