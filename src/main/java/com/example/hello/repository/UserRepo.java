package com.example.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello.model.Users;


public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
