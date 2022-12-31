package org.xja.phonedemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xja.phonedemo.domain.Funs;
import org.xja.phonedemo.mapper.FunMapper;
import org.xja.phonedemo.service.FunService;

import java.util.List;

@Service
public class FunServiceImpl implements FunService {
    @Autowired
    private FunMapper funMapper;
    @Override
    public List<Funs> showFuns(){
        return funMapper.showFuns();
    }
}
