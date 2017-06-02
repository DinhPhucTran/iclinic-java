/* PhieuKhamBenhController - Add by Hang - 31/05/2017 */
package com.group4.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.User;
import com.group4.cms.model.BenhNhan;
import com.group4.cms.model.ChiTietDonThuoc;
import com.group4.cms.model.DichVu;
import com.group4.cms.model.DonThuoc;
import com.group4.cms.model.HoSoDieuTriNoiTru;
import com.group4.cms.model.ListChiTietDonThuoc;
import com.group4.cms.model.ListPhieuYeuCauDichVu;
import com.group4.cms.model.PhieuKhamBenh;
import com.group4.cms.model.PhieuKhamDangCho;
import com.group4.cms.model.PhieuYeuCauDichVu;
import com.group4.cms.model.Phong;
import com.group4.cms.model.Thuoc;
import com.group4.cms.service.BenhNhanService;
import com.group4.cms.service.ChiTietDonThuocService;
import com.group4.cms.service.DichVuService;
import com.group4.cms.service.DonThuocService;
import com.group4.cms.service.HoSoDieuTriService;
import com.group4.cms.service.PhieuKhamBenhService;
import com.group4.cms.service.PhieuKhamDangChoService;
import com.group4.cms.service.PhieuYeuCauDichVuService;
import com.group4.cms.service.PhongService;
import com.group4.cms.service.ThuocService;
import com.group4.cms.service.UserService;

@Controller
public class PhieuKhamBenhController {
	@Autowired
	private PhieuKhamBenhService phieuKhamBenhService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	BenhNhanService benhNhanService;
	
	@Autowired
	DichVuService dvService;
	
	@Autowired 
	PhieuKhamBenhService pkbService;
	
	@Autowired 
	PhongService phongService;
	
	@Autowired 
	PhieuYeuCauDichVuService pycDichVuService;
	
	@Autowired 
	private PhieuKhamDangChoService pkdcService;
	
	@Autowired 
	private ChiTietDonThuocService ctdtService;
	
	@Autowired 
	private ThuocService thuocService;
	
	@Autowired 
	private DonThuocService donThuocService;
	
	@Autowired
	private HoSoDieuTriService hoSoDieuTriService;
	
	@ModelAttribute("phieuKhamBenh")
	public PhieuKhamBenh getPhieuKhamBenh(){
		return new PhieuKhamBenh();
	}
	@ModelAttribute("phieuYeuCauDichVu")
	public PhieuYeuCauDichVu getPhieuYeuCauDichVu(){
		return new PhieuYeuCauDichVu();
	}
	
	@ModelAttribute("hoSoDieuTri")
	public HoSoDieuTriNoiTru getHoSoDieuTriNoiTru() {
		return new HoSoDieuTriNoiTru();
	}

	@ModelAttribute("donThuoc")
	public DonThuoc getDonThuoc(){
		return new DonThuoc();
	}
	
	@ModelAttribute("chiTietDonThuoc")
	public ChiTietDonThuoc getChiTietDonThuoc(){
		return new ChiTietDonThuoc();
	}
	
	@ModelAttribute("listChiTietDonThuoc")
	public ListChiTietDonThuoc getListChiTietDonThuoc(){
		return new ListChiTietDonThuoc();
	}
	
	@RequestMapping(value = "/phieu-kham-benh/get-phong-by-ma-dich-vu",method = RequestMethod.POST)
	@ResponseBody
	public List<Phong> getPhongByMaDichVu(@RequestParam("maDichVu") String maDichVu){
		int i = Integer.parseInt(maDichVu);
		List<Phong> result = phongService.findByDichVu(i);
		return result;
	}

	@RequestMapping(value = "/kham-benh",method = RequestMethod.GET)
	
	public String addPhieuKhamBenh(Model model){
		List<User> users = new ArrayList<User>();		
		users = userService.findAll();
		
		List<BenhNhan> benhNhan = new ArrayList<BenhNhan>();		
		benhNhan = benhNhanService.findAll();
		
		List<DichVu> dsDichVu = new ArrayList<DichVu>();
		dsDichVu = dvService.findAll();
		
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		dsThuoc = thuocService.findAll();
		
		ListPhieuYeuCauDichVu listPYCDichVu = new ListPhieuYeuCauDichVu();
		listPYCDichVu.setPhieuYeuCauDichVu(new ArrayList<PhieuYeuCauDichVu>(pycDichVuService.findAll()));
		
		ListChiTietDonThuoc listChiTietDonThuoc = new ListChiTietDonThuoc();
		listChiTietDonThuoc.setChiTietDonThuoc(new ArrayList<ChiTietDonThuoc>(ctdtService.findAll()));
		
		List<PhieuKhamBenh> dsPhieuKhamBenh = new ArrayList<PhieuKhamBenh>();
		dsPhieuKhamBenh = pkbService.findAll();
		
		model.addAttribute("dsDichVu", dsDichVu);
		model.addAttribute("dsUser", users);
		model.addAttribute("dsBenhNhan", benhNhan);
		model.addAttribute("dsPhieuKhamBenh", dsPhieuKhamBenh);
		model.addAttribute("listPYCDichVu", listPYCDichVu);
		model.addAttribute("listChiTietDonThuoc", listChiTietDonThuoc);
		model.addAttribute("dsThuoc", dsThuoc);
		return "kham-benh";
		//return "test";
	}
	
	@RequestMapping(value = "/phieu-kham-benh/luu", method = RequestMethod.POST)
	public String savePhieuKhamBenh(@ModelAttribute("phieuKhamBenh") PhieuKhamBenh phieuKhamBenhModel, @Valid PhieuKhamBenh phieuKhamBenh,
						BindingResult phieuKhamBenhResult,
						RedirectAttributes redirectAttributes, Model model){
		if (phieuKhamBenhResult.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			phieuKhamBenh.setNgayKham(new Date());
			phieuKhamBenhService.save(phieuKhamBenh);
		}
		return "redirect:/kham-benh";
	}
	
	@RequestMapping(value = "/phieu-kham-benh/cap-nhat",  method = RequestMethod.POST)
	@ResponseBody
	public String updatePhieuKhamBenh(@RequestParam("maPhieuKhamBenh") String maPhieuKhamBenh,
			@RequestParam("benhNhan") String benhNhanId,@RequestParam("bacSi") String bacsiId,
			@RequestParam("lyDoKham") String lyDoKham,	@RequestParam("chanDoan") String chanDoan,
			@RequestParam("loiDan") String loiDan,RedirectAttributes redirectAttributes){
		     PhieuKhamBenh phieuKhamBenh = new PhieuKhamBenh();
		     phieuKhamBenh.setMaPhieuKhamBenh(Integer.parseInt(maPhieuKhamBenh));
		     System.out.println(maPhieuKhamBenh);
		     System.out.println(loiDan);
		     System.out.println(chanDoan);
		     BenhNhan benhNhan = new BenhNhan();
		     benhNhan.setMaBenhNhan(Integer.parseInt(benhNhanId));
		     phieuKhamBenh.setBenhNhan(benhNhan);
		     
		     User bacsi = new User();
		     bacsi.setId(Integer.parseInt(bacsiId));
		     phieuKhamBenh.setBacSi(bacsi);
		     phieuKhamBenh.setChanDoan(chanDoan);
		     phieuKhamBenh.setLoiDan(loiDan);
		     phieuKhamBenh.setLyDoKham(lyDoKham);
		     
		     pkbService.save(phieuKhamBenh);
	      return "success";
	   }
	
	@RequestMapping(value = "/phieu-yeu-cau-dich-vu/luu", method = RequestMethod.POST)
	public String savePhieuYeuCauDichVu(@ModelAttribute("listPYCDichVu") @Valid ListPhieuYeuCauDichVu listPYCDichVu) {
		List<PhieuYeuCauDichVu> yeuCauDichVu = listPYCDichVu.getPhieuYeuCauDichVu();
		for (PhieuYeuCauDichVu phieuYeuCauDichVu : yeuCauDichVu) {
			pycDichVuService.save(phieuYeuCauDichVu);
		}
		return "redirect:/kham-benh";
	}
	
	// lưu đơn thuốc và chi tiết đơn thuốc
	@RequestMapping(value = "/don-thuoc/luu", method = RequestMethod.POST)
	public String saveDonThuoc(@ModelAttribute("listChiTietDonThuoc") @Valid ListChiTietDonThuoc listChiTietDonThuoc, BindingResult resultChiTiet,
					@ModelAttribute("donThuoc") @Valid DonThuoc donThuoc, BindingResult resultDonThuoc) {
		List<ChiTietDonThuoc> chiTietDonThuocList = listChiTietDonThuoc.getChiTietDonThuoc();
		double tongTien = 0;
		for (ChiTietDonThuoc chiTietDonThuoc : chiTietDonThuocList) {
			ctdtService.save(chiTietDonThuoc);
			tongTien += chiTietDonThuoc.getThuoc().getDonGia();
		}
		donThuoc.setNgayKeDon(new Date());
		donThuoc.setTongTien(tongTien);
		donThuoc.setDsThuoc(chiTietDonThuocList);
		donThuocService.save(donThuoc);
		
		return "redirect:/kham-benh";
	}
	
	// lập phiếu khám bệnh khi bệnh nhân đã có trong danh sách
		@RequestMapping(value = "/phieu-kham-benh/lap-phieu-kham-benh", method = RequestMethod.POST)
		@ResponseBody
		public String lapPhieuKhamBenh(@RequestParam("maBenhNhan") String maBenhNhan,RedirectAttributes redirectAttributes){
			int i = Integer.parseInt(maBenhNhan);
			PhieuKhamBenh phieuKhamBenh = new PhieuKhamBenh();
			
			BenhNhan benhNhan = new BenhNhan();
			benhNhan.setMaBenhNhan(i);
			
			phieuKhamBenh.setBenhNhan(benhNhan);
			pkbService.save(phieuKhamBenh);
			
			// Insert PhieuKhamDangCho
			List<PhieuKhamBenh> dsPhieuKhamBenh = pkbService.findAll();
			PhieuKhamBenh phieuKhamBenhCur = dsPhieuKhamBenh.get(dsPhieuKhamBenh.size()-1);
			PhieuKhamDangCho phieuKhamDangCho = new PhieuKhamDangCho();
			phieuKhamDangCho.setPhieuKhamBenh(phieuKhamBenhCur);
			
			int countPhieuKhamDangCho;
			if(pkdcService.findAll().isEmpty()){
				countPhieuKhamDangCho = 1;
			}
			else{
				countPhieuKhamDangCho= pkdcService.findAll().size()+1;
			}
			phieuKhamDangCho.setSoThuTu(countPhieuKhamDangCho);
			pkdcService.save(phieuKhamDangCho);
			redirectAttributes.addFlashAttribute("message", "Bệnh nhân nhập viện thành công.");
			redirectAttributes.addFlashAttribute("msgType", "success");
			return "redirect:/benh-nhan";
			
	}
}
