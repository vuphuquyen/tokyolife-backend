package com.giotuhoclaptrinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giotuhoclaptrinh.api.output.ProductOutput;
import com.giotuhoclaptrinh.dto.NewProductDTO;
import com.giotuhoclaptrinh.service.INewProductService;
//import com.giotuhoclaptrinh.service.impl.newProductService;





@CrossOrigin
@RestController
public class NewProductAPI {
	
	
	@Autowired
	private INewProductService newProductService;
	
	@GetMapping(value = "/product")
	public ProductOutput showproduct(@RequestParam(value = "page", required = false) Integer page,
							 @RequestParam(value = "limit", required = false) Integer limit) {
		ProductOutput result = new ProductOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit);
			result.setListResult(newProductService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newProductService.totalItem()) / limit));
		} else {
			result.setListResult(newProductService.findAll());
		}
		return result;
	}
	
	@PostMapping(value = "/product")
	public NewProductDTO createNew(@RequestBody NewProductDTO model) {
		return newProductService.save(model);
	}
	@PutMapping(value = "/product/{id}")
	public NewProductDTO updateNew(@RequestBody NewProductDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newProductService.save(model);
	}
	
	@DeleteMapping(value = "/product")
	public void deleteNew(@RequestBody long[] ids) {
		newProductService.delete(ids);
	}
 
}
