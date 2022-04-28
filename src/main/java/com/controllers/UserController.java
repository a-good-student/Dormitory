package com.controllers;

import com.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping(value="/login",method={RequestMethod.POST})
    @ResponseBody
    public int searchUser(HttpSession session, String user, String password) {
        return administratorService.searchUser(user,password,session);
    }
}
