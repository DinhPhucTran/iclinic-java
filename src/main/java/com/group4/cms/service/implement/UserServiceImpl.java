package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.UserDao;
import com.group4.cms.model.User;
import com.group4.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		try {
			list = userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User save(User user) {
		try {
			return userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public Integer getImageId(Integer userId) {
		try {
			return userDao.getImageId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getProfileImageIdByUserName(String userName) {
		try {
			return userDao.getProfileImageIdByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<User> findByBoPhan(int boPhanId) {
		List<User> result = userDao.findUsersByBoPhan(boPhanId);
		return result;
	}

	@Override
	public Integer countUser() {
		try {
			return userDao.countUser();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer countBacSi() {
		try{
			return userDao.countBacSi();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer countYta() {
		try {
			return userDao.counYta();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
}
