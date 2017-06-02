package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.group4.cms.model.Thuoc;
import com.group4.cms.service.ThuocService;

public class StringToThuocConverter implements Converter<String, Thuoc>{
	
	@Autowired
	ThuocService thuocService;

//	@Override
	public Thuoc convert(String maThuoc) {
		try{
			return thuocService.findById(Integer.parseInt(maThuoc));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}