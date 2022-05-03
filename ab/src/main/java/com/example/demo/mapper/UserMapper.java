package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Plus;
import com.example.demo.entity.Timejoin;
import com.example.demo.model.Time;
import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	void doinsert(User user);
	int dologing(User user);
	List<Plus>doselect(User user);
	List<Plus>dosearch(User user);
	
	void dodelete(User user);
	void doupdate(User user);
	
	int  timeloging(Time time);
	void timeinsert(Time time);
	void timeupdate(Time time);
	
	List<Timejoin>timeselect(Time time);


}
