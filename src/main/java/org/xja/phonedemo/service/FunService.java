package org.xja.phonedemo.service;

import org.xja.phonedemo.domain.Funs;

import java.util.List;

public interface FunService {
    public List<Funs> showFuns(Funs fun);
    public void deleteFuns(Integer funId);
    public void saveFuns(Funs fun);
    public List<Funs> showLevel1(Integer funLevel);
    //修改页展示详情
    public Funs funDetails(Integer funId);
    //修改
    public void updateFun(Funs fun);
}
