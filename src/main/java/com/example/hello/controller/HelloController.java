package com.example.hello.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.model.Person;
import com.example.hello.service.HelloService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	private HelloService service;

	public HelloController(HelloService service) {
		this.service = service;
	}
	
	@GetMapping("/greet")
	public String greet(HttpServletRequest request) {
		return "Welcome "+request.getSession().getId();
		
	}
	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getPersons(){
		
		return ResponseEntity.ok().body(service.getPerson());
	}

	@GetMapping
	public String getMessage() {
		return "Hello Priyanka!!";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Person> savePerson(@RequestBody Person p){
		Person p1 = service.createPerson(p);
		return ResponseEntity.ok().body(p1);
	}
}
