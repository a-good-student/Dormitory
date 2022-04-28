package com.controllers;

import com.beans.MessType;
import com.beans.Rexp;
import com.beans.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    //导入学生表数据
    @RequestMapping(value="/import",method={RequestMethod.POST})
    @ResponseBody
    public List Import(int num,String sname,String sno,String classId,String className) {
        return studentService.Import(num,sname,sno,classId,className);
    }

    //总记录数
    @RequestMapping(value="/mount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String sname,String sno,String classId,String className) {
        return studentService.Mount(sname,sno,classId,className);
    }

    //总记录数
    @RequestMapping(value="/addStudent",method={RequestMethod.POST})
    @ResponseBody
    public int addStudent(String sno, String sname, String ssex, String sage, String sphone, String classId, String className, String dormitory) {
        return studentService.addStudent(sno,sname,ssex,sage,sphone,classId,className,dormitory);
    }

    //删除
    @RequestMapping(value="/deleteStudent",method={RequestMethod.POST})
    @ResponseBody
    public int deleteStudent(int id) {
        studentService.deleteStudent(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modStudent",method={RequestMethod.POST})
    @ResponseBody
    public int modStudent(int id, String sno, String sname, String ssex, String sage, String sphone, String classId, String className, String dormitory) {
        return studentService.modStudent(id,sno,sname,ssex,sage,sphone,classId,className,dormitory);
    }
}
