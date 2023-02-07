package org.xja.phonedemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xja.phonedemo.domain.Brands;
import org.xja.phonedemo.service.BrandService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    @Autowired
    private BrandService brandService;
    @RequestMapping("/list")
    public String list(Brands brands, Integer pageNum, Map<String, Object> model)
    {
        if(pageNum == null) pageNum = 1;
        PageHelper.startPage(pageNum, 10);
        List<Brands> list = brandService.showBrand(brands);
        PageInfo<Brands> pv = new PageInfo<>(list);
        model.put("pv", pv);
        model.put("keyBrand", brands);
        return "/admin/brands/show";
    }
    @RequestMapping("/delete")
    public String delete(Integer brandId){
        brandService.deleteBrand(brandId);
        return "redirect:../brands/list";
    }
    @RequestMapping("/save")
    public String save(Brands brands)
    {
        brandService.saveBrands(brands);
        return "redirect:../brands/list";
    }
}
