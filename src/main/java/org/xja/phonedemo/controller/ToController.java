package org.xja.phonedemo.controller;

import org.xja.phonedemo.domain.Brands;
import org.xja.phonedemo.domain.Funs;
import org.xja.phonedemo.service.BrandService;
import org.xja.phonedemo.service.FunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xja.phonedemo.domain.Funs;
import org.xja.phonedemo.service.FunService;

import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/to")
public class ToController {
    @Autowired
    private FunService funService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("/{path}/{file}")
    public String path(
            @PathVariable("path") String path,
            @PathVariable("file") String file) {
        return path + File.separator + file;
    }

    @RequestMapping("/{path1}/{path2}/{file}")
    public String path2(
            @PathVariable("path1") String path1,
            @PathVariable("path2") String path2,
            @PathVariable("file") String file,
            Map<String, Object> model,
            Integer funId) {
        if ("funs".equals(path2) && "save".equals(file))//admin/funs/save
        {
            //查询一级菜单
            List<Funs> funsList = funService.showLevel1(1);
            model.put("funsList", funsList);
        }
        if ("funs".equals(path2) && "update".equals(file))//admin/funs/save
        {
            //查询一级菜单
            List<Funs> funsList = funService.showLevel1(1);
            model.put("funsList", funsList);
            Funs fun = funService.funDetails(funId);
            model.put("fun",fun);
        }
        if("brands".equals(path2) && "update".equals(file))
        {
            Brands brands = brandService.brandDetails(funId);
            model.put("brand", brands);
        }
        return path1 + File.separator + path2 + File.separator + file;
    }

    @RequestMapping("/{file}")
    public String file(@PathVariable("file") String file) {
        return file;
    }
}
