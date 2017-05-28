package com.group4.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group4.cms.model.DichVu;
import com.group4.cms.service.DichVuService;

@Controller
public class DichVuController {
	@Autowired
	DichVuService dvService;
	
	@ModelAttribute("dichVu")
	public DichVu getDichVu(){
		return new DichVu();
	}
	
	@RequestMapping("/dich-vu")
	public String boPhanPage(Model model){
		List<DichVu> dsDichVu = new ArrayList<DichVu>();
		dsDichVu = dvService.findAll();
		model.addAttribute("dsDv", dsDichVu);
		return "ds-dich-vu";
	}
	
	@RequestMapping(value = "/them-dich-vu", method = RequestMethod.POST)
	public String themDichVu(@ModelAttribute("dichVu") @Valid DichVu dichVu, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			dvService.save(dichVu);
		}
		return "redirect:/dich-vu";
	}
	@RequestMapping(value = "/xoa-dich-vu", method = RequestMethod.POST)
	public String xoaDichVu(@ModelAttribute("dichVu") @Valid DichVu dichVu, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			try{
				dvService.delete(dichVu.getMaDichVu());
				model.addAttribute("message", "Đã xóa bộ phận " + dichVu.getTenDichVu());
			} catch (Exception e) {
				model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");				
			}			
		}
		
		return "redirect:/dich-vu";
	}
}
