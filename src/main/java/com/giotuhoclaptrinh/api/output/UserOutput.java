package com.giotuhoclaptrinh.api.output;

import java.util.ArrayList;
import java.util.List;

import com.giotuhoclaptrinh.dto.UserDTO;

public class UserOutput {
	private int page;
	private int totalPage;
	private List<UserDTO> listResult = new ArrayList<>();
	
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

	public List<UserDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<UserDTO> listResult) {
		this.listResult = listResult;
	}
}
