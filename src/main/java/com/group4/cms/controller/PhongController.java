package com.group4.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group4.cms.model.DichVu;
import com.group4.cms.model.Phong;
import com.group4.cms.service.PhongService;

public class PhongController {

	@Autowired
	PhongService phongService;
	
	@ModelAttribute("phong")
	public Phong getPhong(){
		return new Phong();
	}
	
	@RequestMapping("/phong")
	public String phongPage(Model model){
		List<Phong> dsPhong = new ArrayList<Phong>();
		dsPhong = phongService.findAll();
		model.addAttribute("dsPhong", dsPhong);
		return "ds-phong";
	}
	
	@RequestMapping(value = "/them-phong", method = RequestMethod.POST)
	public String themPhong(@ModelAttribute("phong") @Valid Phong phong, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			phongService.save(phong);
		}
		return "redirect:/phong";
	}
	
	@RequestMapping(value = "/xoa-phong", method = RequestMethod.POST)
	public String xoaPhong(@ModelAttribute("phong") @Valid Phong phong, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			try{
				phongService.delete(phong.getMaPhong());
				model.addAttribute("message", "Đã xóa phòng " + phong.getTenPhong());
			} catch (Exception e) {
				model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");				
			}			
		}
		
		return "redirect:/phong";
	}

}
