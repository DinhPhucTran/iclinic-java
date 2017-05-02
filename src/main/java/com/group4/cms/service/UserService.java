package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User save(User user);
}
