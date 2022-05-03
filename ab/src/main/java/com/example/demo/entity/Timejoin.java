package com.example.demo.entity;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Timejoin {
	private int id;
	private String name;
	private LocalTime inTime;
	private LocalTime outTime;

}
