package com.group4.cms.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group4.cms.model.BenhNhan;
import com.group4.cms.service.BenhNhanService;

@Controller
public class BenhNhanController {
	
	@Autowired
	private BenhNhanService benhNhanService; 
	
	@ModelAttribute("benhNhan")
	public BenhNhan getBenhNhan(){
		return new BenhNhan();
	}
	
	@RequestMapping("/tiep-nhan")
	public String addPatient(){
		return "add-patient";
	}
	
	@RequestMapping(value = "/benh-nhan/luu", method = RequestMethod.POST)
	public String save(BenhNhan benhNhan, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			benhNhan.setNgayTiepNhan(new Date());
			benhNhanService.save(benhNhan);
		}
		return "redirect:/tiep-nhan";
	}
	
	@RequestMapping(value = "/benh-nhan", method = RequestMethod.GET)
	public String get(Model model){
		List<BenhNhan> dsBenhNhan = benhNhanService.findAll();
		model.addAttribute("dsBenhNhan", dsBenhNhan);
		return "patients";
	}
	
	@RequestMapping(value="/tao-ho-so-dieu-tri", method=RequestMethod.POST)
	public String save(@ModelAttribute("benhNhan") @Valid BenhNhan benhNhan, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("error");
		}
		System.out.println("benhNhan.getMaBenhNhan(): " + benhNhan.getMaBenhNhan());
		// TODO
		return "redirect:/benh-nhan";
	}
}
