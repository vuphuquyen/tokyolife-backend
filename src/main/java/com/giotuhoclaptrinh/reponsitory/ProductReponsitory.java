package com.giotuhoclaptrinh.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giotuhoclaptrinh.entity.ProductEntity;

public interface ProductReponsitory extends JpaRepository<ProductEntity, Long>{
       ProductEntity findOneById(Long id);
       boolean existsByNameProduct(String nameProduct);
}
