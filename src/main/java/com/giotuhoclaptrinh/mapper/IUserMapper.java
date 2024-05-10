package com.giotuhoclaptrinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.giotuhoclaptrinh.dto.UserDTO;
import com.giotuhoclaptrinh.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface IUserMapper {
	UserEntity toEntity(UserDTO dto);
	UserEntity toEntity(UserDTO dto, @MappingTarget UserEntity entity);
	UserDTO toDTO(UserEntity entity);
}



