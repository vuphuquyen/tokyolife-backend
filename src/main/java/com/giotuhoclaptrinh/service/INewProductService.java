package com.giotuhoclaptrinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.giotuhoclaptrinh.dto.NewProductDTO;


public interface INewProductService {
	NewProductDTO save(NewProductDTO newProductDTO);
	void delete(long[] ids);
	List<NewProductDTO> findAll(Pageable pageable);
	List<NewProductDTO> findAll();
	int totalItem();
}
