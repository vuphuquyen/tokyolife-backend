package com.giotuhoclaptrinh.api.output;

import java.util.ArrayList;
import java.util.List;

import com.giotuhoclaptrinh.dto.NewProductDTO;



public class ProductOutput {
	private int page;
	private int totalPage;
	private List<NewProductDTO> listResult = new ArrayList<>();
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<NewProductDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<NewProductDTO> listResult) {
		this.listResult = listResult;
	}
}
