package org.xja.phonedemo.service;

import org.xja.phonedemo.domain.User;

import java.util.List;

public interface UserService {
    //登陆
    public User login(String name, String pwd);
    public void reg(User user);
    public List<User> showUsers();
}
