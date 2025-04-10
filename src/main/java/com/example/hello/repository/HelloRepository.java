package com.example.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hello.model.Person;

@Repository
public interface HelloRepository extends JpaRepository<Person, Integer>{

}
