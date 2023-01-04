package org.xja.phonedemo.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.xja.phonedemo.domain.Funs;

import java.util.List;
@MapperScan
public interface FunMapper {
    public List<Funs> showFuns();
    public void delete(Integer funId);
    public void save(Funs fun); //添加
    public List<Funs> findFunByLevel(Integer funLevel);
    public List<Funs> findFunByPid(Integer funPid);
    public void deleteByPid(Integer pid);
    public Funs get(Integer funId);
    public void update(Funs fun);
}
