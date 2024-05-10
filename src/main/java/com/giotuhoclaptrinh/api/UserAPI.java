package com.giotuhoclaptrinh.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giotuhoclaptrinh.api.output.UserOutput;
import com.giotuhoclaptrinh.dto.ApiResponse;
import com.giotuhoclaptrinh.dto.UserDTO;
import com.giotuhoclaptrinh.entity.UserEntity;
import com.giotuhoclaptrinh.service.IUserService;

@CrossOrigin
@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/user")
	public UserOutput showuser(@RequestParam(value = "page", required = false) Integer page,
							 @RequestParam(value = "limit", required = false) Integer limit) {
		UserOutput result = new UserOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit);
			result.setListResult(userService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
		} else {
			result.setListResult(userService.findAll());
		}
		return result;
	}
    @GetMapping(value="/user/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
    	return userService.getUser(id);
    }
    
//	@PostMapping(value = "/user")
//	public ApiResponse<UserDTO> createNew(@RequestBody @Valid UserDTO model) {
//		ApiResponse<UserDTO> apiReponse = new ApiResponse<>();
//		apiReponse.setResult(userService.save(model));
//		return apiReponse;
//	}
    @PostMapping(value = "/user")
    public ApiResponse<UserDTO> createNew(@RequestBody @Valid UserDTO model) {
        ApiResponse<UserDTO> apiResponse = ApiResponse.<UserDTO>builder()
                                                .result(userService.save(model))
                                                .build();
        return apiResponse;
    }
	@PutMapping(value = "/user/{id}")
	public UserDTO updateNew(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return userService.save(model);
	}
	@DeleteMapping(value = "/user")
	public void deleteNew(@RequestBody long[] ids) {
		userService.delete(ids);
	}

}
