package com.giotuhoclaptrinh.dto;

import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends AbstractDTO<UserDTO> {
	@Size(min = 5, message = "USERNAME_INVALID")
	 String userName;

	@Size(min = 3, message = "INVALID_PASSWORD")
	 String password;
	 String fullName;
	 Integer status;
	 String roleCode;

}
