package org.xja.phonedemo.service;

import org.xja.phonedemo.domain.Brands;
import org.xja.phonedemo.mapper.BrandMapper;

import java.util.List;

public interface BrandService {
    public List<Brands> showBrand(Brands brands);
    public void saveBrands(Brands brands);
    public void deleteBrand(Integer brandId);
    public void updateBrand(Brands brands);
    public Brands brandDetails(Integer brandId);
}
