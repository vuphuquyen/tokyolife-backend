package com.giotuhoclaptrinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.giotuhoclaptrinh.dto.NewProductDTO;
import com.giotuhoclaptrinh.entity.ProductEntity;


@Mapper
public interface IProductMapper {
	
	ProductEntity toEntity(NewProductDTO dto);
	ProductEntity toEntity(NewProductDTO dto, @MappingTarget ProductEntity entity);
	NewProductDTO toDTO(ProductEntity entity);

}
