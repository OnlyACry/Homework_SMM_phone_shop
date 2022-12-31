package org.xja.phonedemo.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.xja.phonedemo.domain.Funs;

import java.util.List;
@MapperScan
public interface FunMapper {
    public List<Funs> showFuns();

}
