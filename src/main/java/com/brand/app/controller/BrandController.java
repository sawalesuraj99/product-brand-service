package com.brand.app.controller;

import com.brand.app.entity.Brand;
import com.brand.app.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.addBrand(brand));
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(brandService.getBrandById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Long id, @RequestBody Brand brandDetails) {
        return ResponseEntity.ok(brandService.updateBrand(id, brandDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Brand deleted successfully.");
    }
    
    @GetMapping("/product/{productId}")
    public ResponseEntity<Brand> getBrandByProductId(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(brandService.getBrandByProductId(productId));
    }

}

