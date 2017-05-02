package com.group4.cms.dao;

import com.group4.cms.model.User;

public interface UserRepository {
	public User findByUserName(String username);
}
