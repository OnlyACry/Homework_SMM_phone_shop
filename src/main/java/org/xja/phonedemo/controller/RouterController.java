package org.xja.phonedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xja.phonedemo.domain.Funs;
import org.xja.phonedemo.service.FunService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rout")
public class RouterController {
    @Autowired
    private FunService funService;
    @RequestMapping("/{file}")
    public String to(@PathVariable("file")String file, Integer id,Map<String,Object> model)
    {
        if("saveFun".equals(file))
        {
            List<Funs> list=funService.showLevel1(1);
            model.put("list", list);
        }
        if("updateFun".equals(file))
        {
            List<Funs> list=funService.showLevel1(1);
            Funs fun = funService.funDetails(id);
            model.put("list", list);
            model.put("fun", fun);
        }
        return file;
    }
}
