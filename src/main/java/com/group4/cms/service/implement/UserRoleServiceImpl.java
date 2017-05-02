package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.UserRoleDao;
import com.group4.cms.model.UserRole;
import com.group4.cms.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	UserRoleDao roleDao;
	
	public List<UserRole> findAll(){
		List<UserRole> roles = new ArrayList<UserRole>();
		roles = roleDao.findAll();
		return roles;
	}
	
	public UserRole findById(int id){
		try{
			return roleDao.findOne(id);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
