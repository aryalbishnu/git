package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Join;
import com.example.demo.model.User;

@Mapper
public interface UserMapper {

	void doinsert(User user);
	void dodelete(User user);
	void doupdate(User user);
	
	int dologing(User user);
	
	List<Join>doselect(User user);
	List<Join>dosearch(User user);

}
