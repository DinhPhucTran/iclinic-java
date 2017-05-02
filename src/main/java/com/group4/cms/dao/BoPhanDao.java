package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.BoPhan;

@Repository
public interface BoPhanDao extends JpaRepository<BoPhan, Integer> {

}
