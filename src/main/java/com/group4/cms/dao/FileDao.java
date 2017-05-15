package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.FileWrapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FileDao extends JpaRepository<FileWrapper, Integer> {
    @Transactional
    @Query(value = "select content from files where id = :id", nativeQuery = true)
    public byte[] getFileContent(@Param("id") Integer fileId);
}
