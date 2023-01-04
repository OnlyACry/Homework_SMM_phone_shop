package org.xja.phonedemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xja.phonedemo.domain.Admin;
import org.xja.phonedemo.mapper.AdminMapper;
import org.xja.phonedemo.service.AdminService;
import org.xja.phonedemo.utils.MD5Util;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(String name, String pwd){
        return adminMapper.findByNameAndPwd(name, MD5Util.MD5ToString(pwd));
    }
}
