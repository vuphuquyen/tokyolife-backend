package com.giotuhoclaptrinh.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giotuhoclaptrinh.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	  UserEntity findOneById(Long id);
	 boolean existsByUserName(String username);
	 Optional<UserEntity> findByUserName(String userName);
}
