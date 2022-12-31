package org.xja.phonedemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.xja.phonedemo.domain.User;

import java.util.List;
@MapperScan
public interface UserMapper {

    public List<User> find();

    public User findByNameAndPwd(@Param("name") String name,@Param("pwd") String pwd);

    public User get(Integer userId);

    public void save(User user);

    public void delete(Integer userId);

    public void update(User user);
}
