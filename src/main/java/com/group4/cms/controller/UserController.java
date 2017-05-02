package com.group4.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.group4.cms.model.FileWrapper;
import com.group4.cms.model.User;
import com.group4.cms.model.UserRole;
import com.group4.cms.service.FileService;
import com.group4.cms.service.UserRoleService;
import com.group4.cms.service.UserService;
import com.group4.cms.util.Util;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleService roleService;
	
	@Autowired
	FileService fileService;
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	@RequestMapping(value = "/user-list", method = RequestMethod.GET)
	public String userList(Model model){
		List<User> users = new ArrayList<User>();		
		users = userService.findAll();
		
		List<UserRole> roles = new ArrayList<UserRole>();
		roles = roleService.findAll();
		
		model.addAttribute("userList", users);
		model.addAttribute("roleList", roles);
		
		return "user-list";		
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User user, 
			@RequestParam(value = "image1", required = false) CommonsMultipartFile image, 
			BindingResult result){
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			return "redirect:/user-list";
		}
		String pass = user.getPassword();
		String hashed = encodePassword(pass);
		if(!"".equals(hashed)){
			user.setPassword(hashed);
		}
		
		user.setEnabled(true);
		
		FileWrapper file = new FileWrapper();
		if(Util.isValidImageFile(image.getContentType())){
			String name = "profile-img-" + user.getUserName() +  "." + Util.getFileExtension(image.getOriginalFilename());
			file.setName(name);
			file.setContent(image);
			fileService.save(file);
			
			user.setProfileImage(file);
		}
		
		userService.save(user);
		
		return "redirect:/user-list";
	}
	
	private String encodePassword(String password){
		String hashedPassword = "";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
}
