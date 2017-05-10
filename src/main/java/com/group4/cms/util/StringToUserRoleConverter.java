package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.group4.cms.model.UserRole;
import com.group4.cms.service.UserRoleService;

@Component
public class StringToUserRoleConverter implements Converter<String, UserRole> {

	@Autowired
	UserRoleService roleService;
	
//	@Override
	public UserRole convert(String id) {
		try{
			return roleService.findById(Integer.parseInt(id));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
