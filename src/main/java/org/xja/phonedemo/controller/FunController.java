package org.xja.phonedemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public ModelAndView list(Funs fun, Integer pageNum)
    {
        if (pageNum == null) {
            pageNum = 1;//未带页号，默认为第1页
        }
        //查询之前
        PageHelper.startPage(pageNum, 10);//10:每页记录数
        List<Funs> list = funService.showFuns(fun);
        PageInfo<Funs> pv = new PageInfo<>(list);//将查询结果封装到pv中
        //非登陆信息，建议存入request
        ModelAndView mv = new ModelAndView();
        //  mv.getModel().put("list", list);
        mv.getModel().put("pv", pv);
        mv.getModel().put("keyFun", fun);//回显查询条件
        mv.setViewName("/admin/funs/show");
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
