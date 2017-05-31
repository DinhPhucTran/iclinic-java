package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.group4.cms.model.User;
import com.group4.cms.service.UserService;

public class StringToUserConverter implements Converter<String, User>{
	
	@Autowired
	UserService userService;

//	@Override
	public User convert(String id) {
		try{
			return userService.findById(Integer.parseInt(id));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}