package com.wadi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wadi.dto.userDto;
import com.wadi.server.userServiceInterface;
import com.wadi.vo.userDataVo;
import com.wadi.vo.userResponse;

@RestController
public class userController {

	@Autowired
	private userServiceInterface service;

	@PostMapping("/adduser")
	public userResponse registerUser(@RequestBody userDataVo vo) {

		userDto userData = new userDto();

		BeanUtils.copyProperties(vo, userData);

		userDto uservalue = service.registerService(userData);

		userResponse resValue = new userResponse();
		BeanUtils.copyProperties(uservalue, resValue);
		return resValue;
	}

	@GetMapping("/userlist")
	public List<userResponse> getUsesList() {
		List<userDto> listDto = service.getAllUsers();

		List<userResponse> resValue = new ArrayList<>();
		for (userDto dto : listDto) {
			userResponse res = new userResponse();
			BeanUtils.copyProperties(dto, res);

			resValue.add(res);
		}

		return resValue;

	}

	@GetMapping("/user/{id}")
	public userResponse getUsesById(@PathVariable String id) {

		userDto resdto = service.findUserById(id);

		userResponse resUser = new userResponse();

		BeanUtils.copyProperties(resdto, resUser);

		return resUser;

	}

	@PutMapping("/modifyUser/{id}")
	public userResponse modifyUser(@PathVariable String id, @RequestBody userDataVo vo) {

		userDto dto = new userDto();
		BeanUtils.copyProperties(vo, dto);

		userDto resdto = service.modifyUser(id, dto);

		userResponse resUser = new userResponse();

		BeanUtils.copyProperties(resdto, resUser);

		return resUser;

	}

	@DeleteMapping("/delete/{id}")
	public String DeleteUser(@PathVariable String id) {

		String resdto = service.DeleteUserById(id);

		return resdto;

	}

}
