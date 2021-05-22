package com.wadi.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wadi.bo.userDataBo;
import com.wadi.dto.userDto;
import com.wadi.repository.userRepository;
import com.wadi.share.utils;

@Service
public class userServiceImp implements userServiceInterface {

	@Autowired
	private userRepository repository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	utils util;

	@Override
	public userDto registerService(userDto dto) {
		// TODO Auto-generated method stub
		if (repository.findUserByEmail(dto.getEmail()) != null)
			throw new RuntimeException("Record already exist");

		userDataBo bo = new userDataBo();

		BeanUtils.copyProperties(dto, bo);

		bo.setEncryptpassword(bCryptPasswordEncoder.encode(dto.getPassword()));

		String publicUserId = util.generateUserId(30);

		bo.setUserid(publicUserId);

		bo = repository.save(bo);

		userDto userdto = new userDto();
		BeanUtils.copyProperties(bo, userdto);

		return userdto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		userDataBo userBo = repository.findUserByEmail(email);

		if (userBo == null)
			throw new UsernameNotFoundException(email);

		return new User(userBo.getEmail(), userBo.getEncryptpassword(), new ArrayList<>());
	}

	@Override
	public List<userDto> getAllUsers() {
		// TODO Auto-generated method stub

		List<userDataBo> bolist = (List<userDataBo>) repository.findAll();

		List<userDto> dtolist = new ArrayList<>();

		for (userDataBo bo : bolist) {
			userDto dto = new userDto();

			dto.setId(bo.getId());
			dto.setFname(bo.getFname());
			dto.setEmail(bo.getEmail());
			dto.setPassword(bo.getEncryptpassword());

			dtolist.add(dto);

		}

		return dtolist;
	}

	@Override
	public userDto modifyUser(String id, userDto dto) {
		// TODO Auto-generated method stub
		userDataBo bo = repository.findByUserId(id);

		dto.setUserid(bo.getUserid());
		BeanUtils.copyProperties(dto, bo);
		userDataBo resbo = repository.save(bo);

		userDto resdto = new userDto();
		BeanUtils.copyProperties(resbo, resdto);

		return resdto;
	}

	@Override
	public userDto findUserById(String id) {
		// TODO Auto-generated method stub
		userDataBo resbo = repository.findByUserId(id);

		userDto resdto = new userDto();

		BeanUtils.copyProperties(resdto, resbo);

		return resdto;
	}

	@Override
	public String DeleteUserById(String id) {
		// TODO Auto-generated method stub

		userDataBo resbo = repository.deleteUserById(id);

		return "Success";
	}

}
