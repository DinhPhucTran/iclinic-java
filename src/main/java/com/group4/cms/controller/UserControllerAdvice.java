package com.group4.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.group4.cms.service.UserService;

@ControllerAdvice
public class UserControllerAdvice {
	
	@Autowired
	UserService userService;
	
	@ModelAttribute
	public void getUserName(Model model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("username", userName);
	}
	
	@ModelAttribute
	public void getFullName(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		String fullName = userService.getFullName(userName);
		model.addAttribute("fullname", fullName);
	}
}
