package com.wadi.server;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wadi.dto.userDto;

public interface userServiceInterface {

	public userDto registerService(userDto dto);

	public List<userDto> getAllUsers();

	public userDto modifyUser(String id, userDto dto);

	public userDto findUserById(String id);

	public String DeleteUserById(String id);

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
