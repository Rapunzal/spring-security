package com.example.hello.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hello.model.UserPrincipal;
import com.example.hello.model.Users;
import com.example.hello.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private UserRepo repo;
	
	

	public MyUserDetailsService(UserRepo repo) {
		this.repo = repo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUsername(username);
		System.out.println(repo.findAll());
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}

}
