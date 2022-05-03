package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size
private String password;
}
