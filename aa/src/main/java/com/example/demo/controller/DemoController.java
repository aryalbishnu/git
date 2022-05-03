package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Join;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Controller
public class DemoController {
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/show")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return"form";
	}
	@PostMapping("/out")
	public String formby(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msg", "please submit ");
			return "form";
		}
		userMapper.doinsert(user);
		//List<Join>userlist=userMapper.doselect(user);
		//model.addAttribute("userlist", userlist);
            return "loging";
	}
	@PostMapping("/log")
	public String logingby(@ModelAttribute User user, Model model) {
		int result=userMapper.dologing(user);
		if(result>0) {
			List<Join>userlist=userMapper.doselect(user);
			model.addAttribute("userlist", userlist);
			return "result";
		}
		model.addAttribute("msg", "error--------");
		return "loging";
	}
	@PostMapping("/delete")
	public String deleteby(@ModelAttribute User user, Model model) {
		userMapper.dodelete(user);
		List<Join>userlist=userMapper.doselect(user);
		model.addAttribute("userlist", userlist);
		return "result";
	}
	@PostMapping("/edit")
	public String editby(@ModelAttribute User user, Model model) {
		return "edit";
	}
	@PostMapping("/doedit")
	public String doeditby(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit";
		}
		userMapper.doupdate(user);
		List<Join>userlist=userMapper.doselect(user);
		model.addAttribute("userlist", userlist);
		return "result";
	}
	@PostMapping("/search")
	public String searchby(@ModelAttribute User user, Model model) {
		userMapper.dosearch(user);
		List<Join>userlist=userMapper.dosearch(user);
		model.addAttribute("userlist", userlist);
		return "result";
	}

}
