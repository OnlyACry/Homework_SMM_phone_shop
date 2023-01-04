package org.xja.phonedemo.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.xja.phonedemo.domain.Admin;

@MapperScan
public interface AdminMapper {


    public Admin findByNameAndPwd(@Param("name") String name,@Param("pwd") String pwd);
}
