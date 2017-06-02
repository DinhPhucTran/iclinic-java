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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.BoPhan;
import com.group4.cms.model.Thuoc;
import com.group4.cms.service.BoPhanService;
import com.group4.cms.service.ThuocService;

@Controller
public class ThuocController {
	
	@Autowired
	ThuocService thuocService;
	
	@ModelAttribute("thuoc")
	public Thuoc geThuoc(){
		return new Thuoc();
	}
	
	@RequestMapping("/ds-thuoc")
	public String thuocPage(Model model){
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		dsThuoc = thuocService.findAll();
		model.addAttribute("dsThuoc", dsThuoc);
		return "ds-thuoc";
	}
	
	@RequestMapping(value = "/them-thuoc", method = RequestMethod.POST)
	public String themThuoc(@ModelAttribute("thuoc") @Valid Thuoc thuoc, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			thuocService.save(thuoc);
		}
		return "redirect:/ds-thuoc";
	}
	
	@RequestMapping(value = "/xoa-thuoc", method = RequestMethod.POST)
	public String xoaThuoc(@ModelAttribute("thuoc") @Valid Thuoc thuoc, BindingResult result, Model model,
			RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
			redirectAttributes.addFlashAttribute("msgType", "error");
		} else {
			try{
				thuocService.delete(thuoc.getMaThuoc());
				model.addAttribute("message", "Đã xóa bộ phận " + thuoc.getTenThuoc());
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");		
				redirectAttributes.addFlashAttribute("msgType", "error");			
			}			
		}
		
		return "redirect:/ds-thuoc";
	}
}
