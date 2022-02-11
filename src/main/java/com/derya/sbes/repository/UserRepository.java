package com.derya.sbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derya.sbes.model.User;

@Repository  //no need to write this because we extend from JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsUserByUserName(String userName);

}
