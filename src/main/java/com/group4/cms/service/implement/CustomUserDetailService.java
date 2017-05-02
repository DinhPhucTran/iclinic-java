package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.cms.dao.UserDao;	
import com.group4.cms.model.UserRole;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.group4.cms.model.User user = userDao.findByUserName(username);
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		
		return buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(com.group4.cms.model.User user, List<GrantedAuthority> authorities){
		return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles){
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		for (UserRole role : userRoles){
			setAuths.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
		
		return result;
	}
	
}
