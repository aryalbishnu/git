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

import com.example.demo.entity.Plus;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Controller
public class DemoController {
	@Autowired
	UserMapper userMapper;
	@GetMapping("/web")
	public String formby(Model model) {   //he
		model.addAttribute("user", new User());
		return "form";
	}
	@PostMapping("/goto")
	public String top(@ModelAttribute User user , Model model) {
		return "loging";
	}

	
	@PostMapping("/out")
	public String form(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "form";
		}
		userMapper.doinsert(user);
		return "loging";
	}

	
	@PostMapping("/log")
	public String logingby(@ModelAttribute User user, Model model) {
		int result=userMapper.dologing(user);
		if(result>0) {
			List<Plus>userlist=userMapper.doselect(user);
			model.addAttribute("userlist", userlist);
			return"result";
		}else {
			model.addAttribute("msg", "input error-------");
			return"loging";
		}
		
	}
	
	@PostMapping("/delete")
	public String dodelete(@ModelAttribute User user, Model model) {
		userMapper.dodelete(user);
		List<Plus>userlist=userMapper.doselect(user);
		model.addAttribute("userlist", userlist);
		return"result";
	}
	@PostMapping("/doadd")
	public String addby(@ModelAttribute User user, Model model) {
		return"add";
	}
	@PostMapping("/add")
	public String addedby(@Valid User user,  BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add";
		}
		userMapper.doinsert(user);
		List<Plus>userlist=userMapper.doselect(user);
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

		List<Plus> userlist = userMapper.doselect(user);

		model.addAttribute("userlist", userlist);
	
		return"result";
	}
	@PostMapping("/tosearch")
	public String searchby(@ModelAttribute User user, Model model) {
		List<Plus>userlist=userMapper.dosearch(user);
		model.addAttribute("userlist", userlist);
		return "result";
	}
	@PostMapping("/doreturn")
	public String returnby(@ModelAttribute User user, Model model) {
	   List<Plus>userlist=userMapper.doselect(user);
	   model.addAttribute("userlist", userlist);
	   return "result";
	}
}


