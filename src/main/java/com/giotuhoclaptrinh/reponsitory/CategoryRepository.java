package com.giotuhoclaptrinh.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giotuhoclaptrinh.entity.CategoryEntity;



public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
      // Spring data jpa:
	  // lấy lên 1 cái dùng findOne, lấy code: findOneByCode()
	  // lay 1 list: findBy()
	CategoryEntity findOneByCode(String code);
	
}
