package org.xja.phonedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/to")
public class ToController {
    @RequestMapping("/{path}/{file}")
    public String path(
            @PathVariable("path")String path,
            @PathVariable("file")String file){
        return path + File.separator + file;
    }
    @RequestMapping("/{path1}/{path2}/{file}")
    public String path2(
        @PathVariable("path1")String path1,
        @PathVariable("path2")String path2,
        @PathVariable("file")String file){
        return path1 + File.separator + path2 + File.separator + file;
    }
    @RequestMapping("/{file}")
    public String file(@PathVariable("file")String file){
        return file;
    }
}
