package com.lesson.memo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(authz -> authz
	                .requestMatchers("/admin/signin", "/admin/signup","/css/**").permitAll()
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                .loginPage("/admin/signin") 
	                .loginProcessingUrl("/admin/signin") 
	                .defaultSuccessUrl("/memo", true) 
	                .failureUrl("/signin?error") 
	                .permitAll()
	            )
	            .logout(logout -> logout
	            	.logoutUrl("/logout")	
	                .logoutSuccessUrl("/login?logout")
	                .permitAll()
	            );

	        return http.build();
	    }
	}
