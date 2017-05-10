package com.group4.cms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/benh-nhan/luu", method = RequestMethod.POST)
	public void save(@ModelAttribute("benhNhan") BenhNhan benhNhan, HttpServletResponse response) {
		benhNhan.setNgayTiepNhan(new Date());
		benhNhanService.save(benhNhan);
		try {
			response.sendRedirect("/Clinic/tiep-nhan");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/benh-nhan", method = RequestMethod.GET)
	public String get(Model model){
		List<BenhNhan> dsBenhNhan = benhNhanService.findAll();
		model.addAttribute("dsBenhNhan", dsBenhNhan);
		return "ds-benh-nhan";
	}
}
