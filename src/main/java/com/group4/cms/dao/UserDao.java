package com.group4.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, UserRepository {
    @Query(value = "select image_id from user where id = :userId", nativeQuery = true)
    public Integer getImageId(@Param("userId") Integer userId);
    
    @Query(value = "select image_id from user where username like :userName", nativeQuery = true)
    public Integer getProfileImageIdByUserName(@Param("userName") String userName);

    @Query(value = "select * from user where bo_phan_id = :boPhanId", nativeQuery = true)
	public List<User> findUsersByBoPhan(@Param("boPhanId") Integer boPhanId);
    
    @Query(value = "select count(*) from user", nativeQuery = true)
    public Integer countUser();
    
    @Query(value = "select count(*) from user_user_roles where roles_id = 2", nativeQuery = true)
    public Integer countBacSi();
    
    @Query(value = "select count(*) from user_user_roles where roles_id = 3", nativeQuery = true)
    public Integer counYta();
}
