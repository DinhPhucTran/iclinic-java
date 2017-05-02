package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, UserRepository {

}
