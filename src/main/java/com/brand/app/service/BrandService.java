package com.brand.app.service;

import com.brand.app.entity.Brand;
import com.brand.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found!"));
    }

    public Brand updateBrand(Long id, Brand brandDetails) {
        Brand brand = getBrandById(id);
        brand.setName(brandDetails.getName());
        brand.setDescription(brandDetails.getDescription());
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
    
    public Brand getBrandByProductId(Long productId) {
        return brandRepository.findAll().stream()
                .filter(brand -> productId.equals(brand.getProductId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Brand not found with productId: " + productId));
    }
}
