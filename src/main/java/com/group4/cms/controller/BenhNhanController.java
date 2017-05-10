package com.group4.cms.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group4.cms.model.BenhNhan;
import com.group4.cms.service.BenhNhanService;

@Controller
public class BenhNhanController {
	
	@Autowired
	private BenhNhanService benhNhanService; 
	
	@RequestMapping("/tiep-nhan")
	public String addPatient(){
		return "add-patient";
	}
	
	@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/benhnhan/luu", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute("benhNhan") BenhNhan benhNhan, HttpServletRequest request) {
		benhNhan.setNgayTiepNhan(new Date());
		String data = benhNhanService.save(benhNhan).getTenBenhNhan();
		return data;
	}
}
