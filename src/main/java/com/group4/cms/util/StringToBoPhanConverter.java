package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.group4.cms.model.BoPhan;
import com.group4.cms.service.BoPhanService;

@Component
public class StringToBoPhanConverter implements Converter<String, BoPhan>{
	
	@Autowired
	BoPhanService bpService;

//	@Override
	public BoPhan convert(String id) {
		try{
			return bpService.findById(Integer.parseInt(id));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
