package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.UserRole;

public interface UserRoleService {
	
	public List<UserRole> findAll();
	
	public UserRole findById(int id);
}
