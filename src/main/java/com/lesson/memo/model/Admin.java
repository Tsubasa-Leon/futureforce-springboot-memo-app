package com.lesson.memo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "last_name", nullable = false)
	@NotBlank(message = "名字を入力してください")
	private String lastName;
	
	@Column(name = "first_name", nullable = false)
	@NotBlank(message = "名前を入力してください")
	private String firstName;
	
	@Column(name = "email" , nullable = false, unique = true)
	@NotBlank(message = "メールアドレスを入力してください")
	private String email;
	
	@Column (name = "password", nullable = false)
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	
	@Column(name = "created_at")
	private  LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	

}