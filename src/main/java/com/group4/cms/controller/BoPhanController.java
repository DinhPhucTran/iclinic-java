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

import com.group4.cms.model.BoPhan;
import com.group4.cms.service.BoPhanService;

@Controller
public class BoPhanController {
	
	@Autowired
	BoPhanService bpService;
	
	@ModelAttribute("boPhan")
	public BoPhan getBoPhan(){
		return new BoPhan();
	}
	
	@RequestMapping("/bo-phan")
	public String boPhanPage(Model model){
		List<BoPhan> dsBoPhan = new ArrayList<BoPhan>();
		dsBoPhan = bpService.findAll();
		model.addAttribute("dsBp", dsBoPhan);
		return "ds-bo-phan";
	}
	
	@RequestMapping(value = "/them-bo-phan", method = RequestMethod.POST)
	public String themBoPhan(@ModelAttribute("boPhan") @Valid BoPhan boPhan, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			bpService.save(boPhan);
		}
		return "redirect:/bo-phan";
	}
	
	@RequestMapping(value = "/xoa-bo-phan", method = RequestMethod.POST)
	public String xoaBoPhan(@ModelAttribute("boPhan") @Valid BoPhan boPhan, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			try{
				bpService.delete(boPhan.getId());
				model.addAttribute("message", "Đã xóa bộ phận " + boPhan.getTenBoPhan());
			} catch (Exception e) {
				model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");				
			}			
		}
		
		return "redirect:/bo-phan";
	}
}
