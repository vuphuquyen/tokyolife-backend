package com.giotuhoclaptrinh.mapper;

import com.giotuhoclaptrinh.dto.UserDTO;
import com.giotuhoclaptrinh.entity.UserEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T15:41:08+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserEntity toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userName( dto.getUserName() );
        userEntity.password( dto.getPassword() );
        userEntity.fullName( dto.getFullName() );
        userEntity.status( dto.getStatus() );

        return userEntity.build();
    }

    @Override
    public UserEntity toEntity(UserDTO dto, UserEntity entity) {
        if ( dto == null ) {
            return entity;
        }

        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setCreatedDate( dto.getCreatedDate() );
        entity.setModifiedBy( dto.getModifiedBy() );
        entity.setModifiedDate( dto.getModifiedDate() );
        entity.setUserName( dto.getUserName() );
        entity.setPassword( dto.getPassword() );
        entity.setFullName( dto.getFullName() );
        entity.setStatus( dto.getStatus() );

        return entity;
    }

    @Override
    public UserDTO toDTO(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.userName( entity.getUserName() );
        userDTO.password( entity.getPassword() );
        userDTO.fullName( entity.getFullName() );
        userDTO.status( entity.getStatus() );

        return userDTO.build();
    }
}
