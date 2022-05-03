package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class User {
	@NotNull
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String password;

}
