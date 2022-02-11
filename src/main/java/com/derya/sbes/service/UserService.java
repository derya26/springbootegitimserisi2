package com.derya.sbes.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.derya.sbes.dto.UserCreateDTO;
import com.derya.sbes.dto.UserUpdateDTO;
import com.derya.sbes.dto.UserViewDTO;

public interface UserService {
	
	UserViewDTO getUserById(Long id);

	UserViewDTO createUser(UserCreateDTO userCreateDTO);

	List<UserViewDTO> getUsers();

	UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

	void deleteUser(Long id);

	List<UserViewDTO> slice(Pageable pageable);

}
