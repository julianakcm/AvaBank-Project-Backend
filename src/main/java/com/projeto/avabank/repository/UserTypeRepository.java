package com.projeto.avabank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.UserType;


public interface UserTypeRepository extends JpaRepository <UserType, Long> {
	UserType findByName (String userTypeName);
	Optional<UserType> findByRoleName(String userType); // celio colocou hoje
}
