package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.User;

public interface UserService {

	public List<User> findAll();

	public User save(User user);

	public User findById(Integer id);
        
    public Integer getImageId(Integer userId);
    
    public Integer getProfileImageIdByUserName(String userName);
	
	public List<User> findByBoPhan(int boPhanId);
	
	public int countUser();
	
	public int countBacSi();
	
	public int countYta();

	public void delete(int id);
	
	public String getFullName(String userName);
}
