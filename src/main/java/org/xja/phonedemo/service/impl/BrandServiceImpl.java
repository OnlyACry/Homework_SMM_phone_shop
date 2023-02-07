package org.xja.phonedemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xja.phonedemo.domain.Brands;
import org.xja.phonedemo.mapper.BrandMapper;
import org.xja.phonedemo.service.BrandService;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brands> showBrand(Brands brands) {
        return brandMapper.find(brands);
    }

    @Override
    public void saveBrands(Brands brands) {
        brandMapper.save(brands);
    }

    @Override
    public void deleteBrand(Integer brandId) {
        brandMapper.delete(brandId);
    }

    @Override
    public void updateBrand(Brands brands) {
        brandMapper.update(brands);
    }

    @Override
    public Brands brandDetails(Integer brandId) {
        return brandMapper.get(brandId);
    }
}
