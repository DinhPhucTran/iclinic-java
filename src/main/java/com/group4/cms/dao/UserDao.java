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

    @Query(value = "select * from user where bo_phan_id = :boPhanId", nativeQuery = true)
	public List<User> findUsersByBoPhan(@Param("boPhanId") Integer boPhanId);
}
