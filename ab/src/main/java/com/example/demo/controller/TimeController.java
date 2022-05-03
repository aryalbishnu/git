package com.example.demo.controller;

import java.time.LocalTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Time;
import com.example.demo.model.User;

@Controller
public class TimeController {
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/gotime")
	public String timeby(Model model) {
		model.addAttribute("time", new Time());
		return "usertime";
	}
	@PostMapping("intime")
	public String intimeby(@Valid Time time, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:gotime";
		}
		int resultType=userMapper.timeloging(time);
		if(resultType>0) {
			LocalTime a=LocalTime.now();
			time.setInTime(a);
			userMapper.timeinsert(time);
			model.addAttribute("msg", "出勤しました............");
			return "usertime";	
		} else {
			model.addAttribute("ms", "input id and name error.......");
			return "usertime";
		}
	}
		@PostMapping("outtime")
		public String outtimeby(@Valid Time time, BindingResult result, Model model) {
			if(result.hasErrors()) {
				return "redirect:gotime";
			}
			int resultType=userMapper.timeloging(time);
			if(resultType>0) {
				LocalTime a=LocalTime.now();
				time.setOutTime(a);
				userMapper.timeupdate(time);
				model.addAttribute("mssg", "退勤しました............");
				return "usertime";
			}else {
				model.addAttribute("msgg", "input id and name error.........");
				return "usertime";
			}
		}
		@PostMapping("/detailby")
         public String bydetail(@ModelAttribute User user, Model model) {
		return"timeloging";
}
		@PostMapping("/timelog")
		public String logingtime(@ModelAttribute User user,Time time,  Model model) {
			int result=userMapper.dologing(user);
			if(result>0) {
			//	List<Timejoin>listuser=userMapper.timeselect(time);
			//	model.addAttribute("listuser", listuser);
				return "timelist";
			}
			model.addAttribute("msg", "owner email and password eroor......");
			return "timeloging";
		}
		
		
}


