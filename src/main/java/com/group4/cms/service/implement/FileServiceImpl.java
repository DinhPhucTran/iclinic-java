package com.group4.cms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.FileDao;
import com.group4.cms.model.FileWrapper;
import com.group4.cms.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	FileDao fileDao;
	
	public FileWrapper save(FileWrapper file){
		try{
			return fileDao.save(file);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public FileWrapper findById(Integer id) {
        return fileDao.findOne(id);
    }

    @Override
    public byte[] getFileContent(Integer fileId) {
        return fileDao.getFileContent(fileId);
    }
}
