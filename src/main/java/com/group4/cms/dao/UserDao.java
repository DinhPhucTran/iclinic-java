package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, UserRepository {
    @Query(value = "select image_id from user where id = :userId", nativeQuery = true)
    public Integer getImageId(@Param("userId") Integer userId);
}
