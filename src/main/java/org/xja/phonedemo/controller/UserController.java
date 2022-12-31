package org.xja.phonedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xja.phonedemo.domain.User;
import org.xja.phonedemo.service.UserService;
import org.springframework.beans.factory.BeanCreationException;
import org.xja.phonedemo.utils.MD5Util;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(String name, String pwd, HttpSession session)
    {
        User user = userService.login(name, pwd);
        if(user != null){
            session.setAttribute("user", user);
            ModelAndView mv=new ModelAndView("redirect:../fun/list");
            return mv;
        }else{
            ModelAndView mv=new ModelAndView("index");
            mv.getModel().put("error","登陆失败!");
            return mv;
        }
        /*System.out.println(name+"\t"+pwd);*/
    }
}
