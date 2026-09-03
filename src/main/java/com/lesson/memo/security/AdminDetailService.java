package com.lesson.memo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;

@Service
public class AdminDetailService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<Admin> optAdmin = adminRepository.findByEmail(username);
		
		if(optAdmin.isEmpty()) {
			throw new UsernameNotFoundException("存在しないユーザー情報です");
		}
		
		Admin admin = optAdmin.get();
		
		return User.builder()
				.username(admin.getEmail())
				.password(admin.getPassword())
				.roles("ADMIN")
				.build();
		
		
	}

}