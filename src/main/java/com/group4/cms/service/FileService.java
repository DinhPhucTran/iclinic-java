package com.group4.cms.service;

import com.group4.cms.model.FileWrapper;

public interface FileService {
	
	public FileWrapper save(FileWrapper file);
        
        public FileWrapper findById(Integer id);
        
        public byte[] getFileContent(Integer fileId);
}
