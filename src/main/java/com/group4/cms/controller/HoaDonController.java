package com.group4.cms.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.DichVu;
import com.group4.cms.model.DonThuoc;
import com.group4.cms.model.HoaDon;
import com.group4.cms.model.PhieuKhamBenh;
import com.group4.cms.model.PhieuKhamDangCho;
import com.group4.cms.model.PhieuYeuCauDichVu;
import com.group4.cms.service.DonThuocService;
import com.group4.cms.service.HoaDonService;
import com.group4.cms.service.PhieuKhamBenhService;
import com.group4.cms.service.PhieuKhamDangChoService;
import com.group4.cms.service.PhieuYeuCauDichVuService;

@Controller
public class HoaDonController {
	@Autowired
	private PhieuKhamBenhService pkbService;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private PhieuKhamDangChoService phieuKhamDangChoService;
	
	@Autowired
	private PhieuYeuCauDichVuService pycDichVuService;
	
	@Autowired
	private DonThuocService dtService;
	
	@ModelAttribute("hoaDon")
	public HoaDon getHoaDon(){
		return new HoaDon();
	}
	
	@RequestMapping(value = "/thanh-toan",method = RequestMethod.GET)
	public String addHoaDon(Model model){
		List<PhieuKhamBenh> dsPhieuKhamBenh = new ArrayList<PhieuKhamBenh>();
		dsPhieuKhamBenh = pkbService.findPKBChuaThanhToan();
		
		model.addAttribute("dsPhieuKhamBenh", dsPhieuKhamBenh);
		return "thanh-toan";
	}
	@RequestMapping(value = "/hoa-don/get-dich-vu-by-ma-phieu-kham",method = RequestMethod.POST)
	@ResponseBody
	public List<DichVu> getDichVuByMaPhieuKham(@RequestParam("maPhieuKhamBenh") String maPhieuKhamBenh){
		int i = Integer.parseInt(maPhieuKhamBenh);
		
		List<PhieuYeuCauDichVu> dsPYC = pycDichVuService.findByMaPhieuKham(i);
		List<DichVu> dsDichVu = new ArrayList<DichVu>();
		for (PhieuYeuCauDichVu phieuYeuCauDichVu : dsPYC) {
			DichVu dichVu = phieuYeuCauDichVu.getDichVu();
			dsDichVu.add(dichVu);
		}
		return dsDichVu;
	}
	@RequestMapping(value = "/hoa-don/get-phieu-kham-dang-cho-by-ma-phieu-kham",method = RequestMethod.POST)
	@ResponseBody
	public PhieuKhamDangCho getPhieuKhamDangChoByMaPhieuKham(@RequestParam("maPhieuKhamBenh") String maPhieuKhamBenh){
		int i = Integer.parseInt(maPhieuKhamBenh);
		
		List<PhieuKhamDangCho> dsPKDC = phieuKhamDangChoService.findByMaPhieuKham(i);
		PhieuKhamDangCho phieuKhamDangCho = dsPKDC.get(0);
		return phieuKhamDangCho;
	}
	
	@RequestMapping(value = "/hoa-don/luu", method = RequestMethod.POST)
	public String save(@ModelAttribute("hoaDon") HoaDon hoaDonModel, @Valid HoaDon hoaDon,
						BindingResult hoaDonResult,
						RedirectAttributes redirectAttributes, Model model){
		if (hoaDonResult.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			hoaDon.setNgayThanhToan(new Date());
			int maPhieuKham = hoaDon.getPhieuKham().getPhieuKhamBenh().getMaPhieuKhamBenh();
			int maPhieuKhamDC = phieuKhamDangChoService.findByMaPhieuKham(maPhieuKham).get(0).getId();
			List<DonThuoc> dsDonThuoc = dtService.findByMaPhieuKham(maPhieuKhamDC);
			double tongTienThuoc = 0;
			for (DonThuoc donThuoc : dsDonThuoc) {
				tongTienThuoc += donThuoc.getTongTien();
			}
			hoaDon.setTongTien(hoaDon.getTongTien() + tongTienThuoc);
			hoaDonService.save(hoaDon);
			PhieuKhamBenh p = new PhieuKhamBenh();
			p.setMaPhieuKhamBenh(hoaDon.getPhieuKham().getPhieuKhamBenh().getMaPhieuKhamBenh());
			p.setTinhTrangThanhToan(true);
			pkbService.save(p);
		}
		return "redirect:/thanh-toan";
	}
}
