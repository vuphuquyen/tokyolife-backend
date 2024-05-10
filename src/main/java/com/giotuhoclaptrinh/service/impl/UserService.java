package com.giotuhoclaptrinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.giotuhoclaptrinh.converter.UserConverter;
import com.giotuhoclaptrinh.dto.UserDTO;
import com.giotuhoclaptrinh.entity.RoleEntity;
import com.giotuhoclaptrinh.entity.UserEntity;
import com.giotuhoclaptrinh.exception.AppException;
import com.giotuhoclaptrinh.exception.ErrorCode;
import com.giotuhoclaptrinh.reponsitory.RoleRepository;
import com.giotuhoclaptrinh.reponsitory.UserRepository;
import com.giotuhoclaptrinh.service.IUserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService implements IUserService{

	@Autowired
	 UserConverter userConverter;
	@Autowired
	 UserRepository userRepository;
	@Autowired
     RoleRepository roleRepository;
	

	
	
	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		
		if(userDTO.getId() != null) {
			UserEntity oldUserEntity = userRepository.findOneById(userDTO.getId());
			userEntity = userConverter.toEntity(userDTO, oldUserEntity);
		}else {
			// Chuyển đổi UserDTO thành UserEntity
		     userEntity = userConverter.toEntity(userDTO);
		}
		if(userRepository.existsByUserName(userDTO.getUserName()))
			throw new AppException(ErrorCode.USER_EXISTED);
	    
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
	    userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
	    
	    // Tìm vai trò tương ứng với mã vai trò từ userDTO
	    RoleEntity roleEntity = roleRepository.findOneByCode(userDTO.getRoleCode());
	    
	    // Tạo một danh sách mới để lưu trữ vai trò của người dùng
	    List<RoleEntity> roles = new ArrayList<>();
	    
	    // Nếu vai trò tìm được không null, thêm vào danh sách vai trò
	    if (roleEntity != null) {
	        roles.add(roleEntity);
	    }
	    
	    // Gán danh sách vai trò cho người dùng
	    userEntity.setRoles(roles);
	    
	    // Lưu người dùng vào cơ sở dữ liệu
	    userEntity = userRepository.save(userEntity);
	    
	    // Chuyển đổi UserEntity đã lưu thành UserDTO và trả về
	    return userConverter.toDTO(userEntity);
	}


	@Override
	public void delete(long[] ids) {
		for(Long item: ids) {
			userRepository.deleteById(item);
		}
		
	}


	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDTO(item);
			results.add(userDTO);
		}
		return results;
	}


	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDTO(item);
			results.add(userDTO);
		}
		return results;
		
	}



	@Override
	public int totalItem() {
		return (int) userRepository.count();
	}


	@Override
	public UserEntity getUser(Long id) {
	    UserEntity user = userRepository.findOneById(id);
	    if (user == null) {
	        throw new RuntimeException("User not found with ID: " + id);
	    }
	    return user;
	}

}
