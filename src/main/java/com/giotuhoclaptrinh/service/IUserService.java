package com.giotuhoclaptrinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;


import com.giotuhoclaptrinh.dto.UserDTO;
import com.giotuhoclaptrinh.entity.UserEntity;

public interface IUserService {
	UserDTO save(UserDTO userDTO);
	void delete(long[] ids);
	List<UserDTO> findAll(Pageable pageable);
	List<UserDTO> findAll();
	UserEntity getUser(Long id);
	int totalItem();
}
