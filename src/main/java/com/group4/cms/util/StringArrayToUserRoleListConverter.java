package com.group4.cms.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.group4.cms.model.UserRole;
import com.group4.cms.service.UserRoleService;

@Component
public class StringArrayToUserRoleListConverter implements Converter<String[], List<UserRole>>{

	@Autowired
	UserRoleService roleService;
	
//	@Override
	public List<UserRole> convert(String[] ids) {
		List<UserRole> result = new ArrayList<UserRole>();
		
		for(String id : ids){
			try{
				result.add(roleService.findById(Integer.parseInt(id)));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
