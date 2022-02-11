package com.derya.sbes.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derya.sbes.dto.UserCreateDTO;
import com.derya.sbes.dto.UserUpdateDTO;
import com.derya.sbes.dto.UserViewDTO;
import com.derya.sbes.service.UserService;
import com.derya.sbes.sharedutil.GenericResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi {
	
	private final UserService userService;
	
	@GetMapping("v1/user/{id}")
	public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){

		final UserViewDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("v1/user")
	public ResponseEntity<?>createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
		userService.createUser(userCreateDTO);
		return ResponseEntity.ok(new GenericResponse("User created"));
		
	}
	
	@GetMapping("v1/user")
	public ResponseEntity<List<UserViewDTO>>getUsers(){
		final List<UserViewDTO> users= userService.getUsers();
		return ResponseEntity.ok(users);
	}
	@PutMapping("v1/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id,@RequestBody UserUpdateDTO userUpdateDTO){
		final UserViewDTO user = userService.updateUser(id,userUpdateDTO);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("v1/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok(new GenericResponse("User deleted!"));
		
	}
	@GetMapping("v1/user/slice")
	public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
		final List<UserViewDTO> users =userService.slice(pageable);
		return ResponseEntity.ok(users);
	}

}
