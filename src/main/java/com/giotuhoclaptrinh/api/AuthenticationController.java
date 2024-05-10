package com.giotuhoclaptrinh.api;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giotuhoclaptrinh.dto.ApiResponse;
import com.giotuhoclaptrinh.dto.AuthenticationDto;
import com.giotuhoclaptrinh.dto.IntrospectDTO;
import com.giotuhoclaptrinh.dto.reponse.AuthencationReponse;
import com.giotuhoclaptrinh.dto.reponse.IntrospectReponse;
import com.giotuhoclaptrinh.service.impl.AuthenticationService;
import com.nimbusds.jose.JOSEException;

import lombok.experimental.var;

@CrossOrigin
@RestController
@RequestMapping("/authen")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenService;

	@PostMapping("/token")
	ApiResponse<AuthencationReponse> authenticate(@RequestBody AuthenticationDto authenDto) {
		var result = authenService.autheticate(authenDto);
		return ApiResponse.<AuthencationReponse>builder().result(result).build();
	}

	@PostMapping("/introspect")
	ApiResponse<IntrospectReponse> authenticate(@RequestBody IntrospectDTO request)
			throws ParseException, JOSEException {
		var result = authenService.introspect(request);
		return ApiResponse.<IntrospectReponse>builder().result(result).build();
	}
}
