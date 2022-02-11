package com.derya.sbes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.derya.sbes.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	private final UserRepository userRepository;
	
	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		
		return !userRepository.existsUserByUserName(userName);
	}

}
