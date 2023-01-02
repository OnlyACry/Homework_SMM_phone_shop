package org.xja.phonedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xja.phonedemo.domain.Funs;
import org.xja.phonedemo.service.FunService;

import java.util.List;

@Controller
@RequestMapping("/fun")
public class FunController {
    @Autowired
    private FunService funService;
    @RequestMapping("/list")
    public ModelAndView list()
    {
        List<Funs> list=funService.showFuns();
        ModelAndView mv=new ModelAndView();
        mv.getModel().put("list",list);
        mv.setViewName("main");
        return mv;
    }
    @RequestMapping("/delete")
    public String delete(Integer funId)
    {
        funService.deleteFuns(funId);
        return "redirect:../fun/list";
    }
    @RequestMapping("/save")
    public String save(Funs fun)
    {
        fun.setFunLevel(fun.getFunPid()==null?1:2);
        funService.saveFuns(fun);
        return "redirect:../fun/list";
    }
    @RequestMapping("/update")
    public String update(Funs fun)
    {
        fun.setFunLevel(fun.getFunPid()==null?1:2);
        funService.updateFun(fun);
        return "redirect:../fun/list";
    }
}
