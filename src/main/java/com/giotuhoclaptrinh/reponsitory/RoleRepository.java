package com.giotuhoclaptrinh.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giotuhoclaptrinh.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	 RoleEntity findOneByCode(String code);
}
