package com.group4.cms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chi_tiet_dieu_tri")
public class ChiTietDieuTri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maChiTietDieuTri;
	
	//@OneToOne
	//private HoSoDieuTriNoiTru hoSoDieuTriNoiTru;
	
	@Column(name = "thoi_gian_dieu_tri")
	private Date thoiGianDieuTri;
	
	@Column(name = "tinh_trang")
	private String tinhTrang;
	
	@Column(name = "ghi_chu")
	private String ghiChu;

	public int getMaChiTietDieuTri() {
		return maChiTietDieuTri;
	}

	public void setMaChiTietDieuTri(int maChiTietDieuTri) {
		this.maChiTietDieuTri = maChiTietDieuTri;
	}

	/*public HoSoDieuTriNoiTru getHoSoDieuTriNoiTru() {
		return hoSoDieuTriNoiTru;
	}

	public void setHoSoDieuTriNoiTru(HoSoDieuTriNoiTru hoSoDieuTriNoiTru) {
		this.hoSoDieuTriNoiTru = hoSoDieuTriNoiTru;
	}*/

	public Date getThoiGianDieuTri() {
		return thoiGianDieuTri;
	}

	public void setThoiGianDieuTri(Date thoiGianDieuTri) {
		this.thoiGianDieuTri = thoiGianDieuTri;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
