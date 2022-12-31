package org.xja.phonedemo.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.xja.phonedemo.domain.User;
import org.xja.phonedemo.mapper.UserMapper;
import org.xja.phonedemo.service.UserService;
import org.xja.phonedemo.utils.MD5Util;
import org.xja.phonedemo.utils.MyBatisUtil;

import java.util.List;

public class UserServiceimpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String name, String pwd) {
        User user = userMapper.findByNameAndPwd(name, MD5Util.MD5ToString(pwd));
        return user;
    }

    @Override
    public void reg(User user){
        userMapper.save(user);
    }

    @Override
    public List<User> showUsers(){
        List<User> list = userMapper.find();
        return list;
    }
}
