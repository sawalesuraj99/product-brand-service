package com.brand.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brand.app.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}

