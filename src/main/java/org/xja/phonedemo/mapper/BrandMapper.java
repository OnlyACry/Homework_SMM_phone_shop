package org.xja.phonedemo.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.xja.phonedemo.domain.Brands;

import java.util.List;

@MapperScan
public interface BrandMapper {
    public List<Brands> find(Brands brands);
    public Brands get(Integer brandId);
    public void save(Brands brands);
    public void delete(Integer brandId);
    public void update(Brands brands);
}
