package com.giotuhoclaptrinh.converter;

import org.springframework.stereotype.Component;

import com.giotuhoclaptrinh.dto.NewProductDTO;
import com.giotuhoclaptrinh.entity.ProductEntity;



@Component
public class ProductConverter {
      // chuyển dữ liệu từ dto qua entity
	public ProductEntity toEntity(NewProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setCode(dto.getCode());
		entity.setImage(dto.getImage());
		entity.setImg(dto.getImg());
		entity.setNameProduct(dto.getNameProduct());
		entity.setQuantity(dto.getQuantity());
		entity.setOldPrice(dto.getOldPrice());
		entity.setOriginalPrice(dto.getOriginalPrice());
		entity.setSale(dto.getSale());
		entity.setSize(dto.getSize());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	// chuyển ngược lại từ entity qua dto 
	public NewProductDTO toDTO(ProductEntity entity) {
		NewProductDTO dto = new NewProductDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setImage(entity.getImage());
		dto.setImg(entity.getImg());
		dto.setNameProduct(entity.getNameProduct());
		dto.setQuantity(entity.getQuantity());
		dto.setOldPrice(entity.getOldPrice());
		dto.setOriginalPrice(entity.getOriginalPrice());
		dto.setSale(entity.getSale());
		dto.setSize(entity.getSize());
		dto.setStatus(entity.getStatus());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	public ProductEntity toEntity(NewProductDTO dto, ProductEntity entity) {
		entity.setCode(dto.getCode());
		entity.setImage(dto.getImage());
		entity.setImg(dto.getImg());
		entity.setNameProduct(dto.getNameProduct());
		entity.setQuantity(dto.getQuantity());
		entity.setOldPrice(dto.getOldPrice());
		entity.setOriginalPrice(dto.getOriginalPrice());
		entity.setSale(dto.getSale());
		entity.setSize(dto.getSize());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}