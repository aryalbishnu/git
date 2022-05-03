package com.example.demo.model;

import java.time.LocalTime;

import lombok.Data;
@Data
public class Time {
	private int id;
	private String name;
	private LocalTime inTime;
	private LocalTime outTime;
	

}
