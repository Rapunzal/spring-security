package com.example.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hello.model.Person;
import com.example.hello.repository.HelloRepository;

@Service
public class HelloService {

	private HelloRepository repo;

	public HelloService(HelloRepository repo) {
		this.repo = repo;
	}
	
	public List<Person> getPerson(){
		return repo.findAll();
	}
	
	public Person createPerson(Person p) {
		return repo.save(p);
	}

}
