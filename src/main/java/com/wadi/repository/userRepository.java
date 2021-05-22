package com.wadi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wadi.bo.userDataBo;


@Repository
public interface userRepository extends CrudRepository<userDataBo, Long> {

	userDataBo findUserByEmail(String email);

	userDataBo findByUserId(String id);

	userDataBo deleteUserById(String id);

}
