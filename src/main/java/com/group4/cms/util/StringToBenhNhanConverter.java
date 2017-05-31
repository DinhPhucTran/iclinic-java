/* StringToBenhNhanConverter - Add by Hang - 31/05/2017 */
package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.group4.cms.model.BenhNhan;
import com.group4.cms.service.BenhNhanService;

public class StringToBenhNhanConverter implements Converter<String, BenhNhan>{
	
	@Autowired
	BenhNhanService benhNhanService;

//	@Override
	public BenhNhan convert(String maBenhNhan) {
		try{
			return benhNhanService.findById(Integer.parseInt(maBenhNhan));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
