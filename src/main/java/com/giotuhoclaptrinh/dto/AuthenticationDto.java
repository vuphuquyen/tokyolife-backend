package com.giotuhoclaptrinh.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AuthenticationDto {
	String userName;
	String password;
	String fullName;
	Integer status;
	String roleCode;
}
