package com.giotuhoclaptrinh.service.impl;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.giotuhoclaptrinh.dto.AuthenticationDto;
import com.giotuhoclaptrinh.dto.IntrospectDTO;
import com.giotuhoclaptrinh.dto.reponse.AuthencationReponse;
import com.giotuhoclaptrinh.dto.reponse.IntrospectReponse;
import com.giotuhoclaptrinh.entity.UserEntity;
import com.giotuhoclaptrinh.exception.AppException;
import com.giotuhoclaptrinh.exception.ErrorCode;
import com.giotuhoclaptrinh.reponsitory.UserRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

	UserRepository userRepository;

	@NonFinal
	@Value("${jwt.signerKey}")
	protected String SIGNER_KEY;

	public IntrospectReponse introspect(IntrospectDTO request) throws JOSEException, ParseException {
		var token = request.getToken();

		JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

		SignedJWT signedJWT = SignedJWT.parse(token);

		Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

		var verified = signedJWT.verify(verifier);

		return IntrospectReponse.builder().valid(verified && expiryTime.after(new Date())).build();
	}

	public AuthencationReponse autheticate(AuthenticationDto authenDTO) {
		UserEntity user = userRepository.findByUserName(authenDTO.getUserName())
				.orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		boolean authenticated = passwordEncoder.matches(authenDTO.getPassword(), user.getPassword());

		if (!authenticated)
			throw new AppException(ErrorCode.UNAUTHENTICATED);
		var token = generateToken(authenDTO.getUserName());

		return AuthencationReponse.builder().token(token).authenticated(true).build();

	}

	private String generateToken(String username) {
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS512); // Thuật toán để tạo token HS512

		JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder() // Body: nội dung gửi đi trong token
				.subject(username) // Tên của user
				.issuer("giotuhoclaptrinh.com") // định danh khởi tạo, phát hành
				.issueTime(new Date()) // thời gian khởi tạo
				.expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli() // Hết hạn sau 1 giờ
				)).claim("customClaim", "Custom").build();
		Payload payload = new Payload(jwtClaimsSet.toJSONObject()); // Khởi tạo payload

		JWSObject jwsObject = new JWSObject(header, payload); // Tạo Jwt từ header và payload

		try {
			jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes())); // Ký
			return jwsObject.serialize();
		} catch (JOSEException e) {
			log.error("Cannot create token", e);
			throw new RuntimeException(e);
		}
	}
}
