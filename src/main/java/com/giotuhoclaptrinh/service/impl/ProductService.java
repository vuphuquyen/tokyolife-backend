package com.giotuhoclaptrinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giotuhoclaptrinh.converter.ProductConverter;
import com.giotuhoclaptrinh.dto.NewProductDTO;
import com.giotuhoclaptrinh.entity.CategoryEntity;
import com.giotuhoclaptrinh.entity.ProductEntity;
import com.giotuhoclaptrinh.exception.AppException;
import com.giotuhoclaptrinh.exception.ErrorCode;
import com.giotuhoclaptrinh.reponsitory.CategoryRepository;
import com.giotuhoclaptrinh.reponsitory.ProductReponsitory;
import com.giotuhoclaptrinh.service.INewProductService;


@Service
public class ProductService implements INewProductService{

	@Autowired
	private ProductReponsitory productReponsitory;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;

//	@Autowired
//	private IProductMapper productMapper;
//	
	@Override
	public NewProductDTO save(NewProductDTO newProductDTO) {
 		ProductEntity productEntity = new ProductEntity();
		if (newProductDTO.getId() != null) {  // id không null
//		// tìm kiếm đối tượng tin tức tương ứng trong cơ sở dữ liệu 
			ProductEntity oldProductEntity = productReponsitory.findOneById(newProductDTO.getId());
			productEntity = productConverter.toEntity(newProductDTO, oldProductEntity);
		} else {
			// Chuyển đổi đối tượng DTO thành đối tượng Entity:
			productEntity = productConverter.toEntity(newProductDTO);
		}				
		if(productReponsitory.existsByNameProduct(newProductDTO.getNameProduct()))
			throw new AppException(ErrorCode.USER_EXISTED);
		
		// Tìm kiếm và lấy dữ liệu loại danh mục (CategoryEntity):
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newProductDTO.getCategoryCode());
//		// Gán loại danh mục cho đối tượng tin tức:
		productEntity.setCategory(categoryEntity);
//		// Lưu đối tượng mới vào cơ sở dữ liệu
		productEntity = productReponsitory.save(productEntity);
//		// Chuyển đổi đối tượng Entity thành DTO và trả về
		return productConverter.toDTO(productEntity);
	}

	@Override
	public void delete(long[] ids) {  // ids: nhận mảng id cần xóa
		for(long item: ids) {         //  lặp qua từng ID trong mảng
			productReponsitory.deleteById(item); // gọi phương thức deleteById của productRepository để xóa sản phẩm có ID tương ứng trong cơ sở dữ liệu
		}
		
	}

	@Override
	public List<NewProductDTO> findAll(Pageable pageable) { // nhận một đối tượng Pageable làm đối số, cho phép chỉ định số lượng trang và kích thước trang.
		List<NewProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productReponsitory.findAll(pageable).getContent();
		for (ProductEntity item: entities) {
			NewProductDTO productDTO = productConverter.toDTO(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) productReponsitory.count();
	}

	@Override
	public List<NewProductDTO> findAll() {
		List<NewProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productReponsitory.findAll();
		for (ProductEntity item: entities) {
			NewProductDTO productDTO = productConverter.toDTO(item);
			results.add(productDTO);
		}
		return results;
		
	}
   
}
