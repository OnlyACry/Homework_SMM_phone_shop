package org.xja.phonedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xja.phonedemo.domain.Admin;
import org.xja.phonedemo.domain.Funs;
import org.xja.phonedemo.service.AdminService;
import org.xja.phonedemo.service.FunService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private FunService funService;
    @RequestMapping("/login")
    public String login(String adminName, String adminPass, HttpSession session, Map<String, Object> model)
    {
        Admin admin = adminService.login(adminName, adminPass);
        if(admin != null)   //登录成功
        {
            session.setAttribute("admin", admin);
            List<Funs> funList=funService.showLevel1(1);
            session.setAttribute("funList",funList);
            return "admin/main";
        }
        else{
            model.put("error", "登陆失败");
            return "/adminlogin";  //登录失败
        }
    }
}
