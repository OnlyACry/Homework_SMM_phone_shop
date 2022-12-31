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

        SqlSession session = MyBatisUtil.createSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findByNameAndPwd(name, MD5Util.MD5ToString(pwd));
        MyBatisUtil.closeSqlSession(session);
        return user;
    }

    @Override
    public void reg(User user){
        SqlSession session = MyBatisUtil.createSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        userMapper.save(user);
        session.commit();
    }

    @Override
    public List<User> showUsers(){
        SqlSession session = MyBatisUtil.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.find();
        MyBatisUtil.closeSqlSession(session);
        return list;
    }
}
