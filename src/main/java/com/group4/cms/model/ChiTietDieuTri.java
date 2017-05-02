package com.group4.cms.model;

import java.util.Date;

public class ChiTietDieuTri {
	private int maChiTietDieuTri;
	private HoSoDieuTriNoiTru hoSoDieuTriNoiTru;
	private Date thoiGianDieuTri;
	private String tinhTrang;
	private String ghiChu;

	public int getMaChiTietDieuTri() {
		return maChiTietDieuTri;
	}

	public void setMaChiTietDieuTri(int maChiTietDieuTri) {
		this.maChiTietDieuTri = maChiTietDieuTri;
	}

	public HoSoDieuTriNoiTru getHoSoDieuTriNoiTru() {
		return hoSoDieuTriNoiTru;
	}

	public void setHoSoDieuTriNoiTru(HoSoDieuTriNoiTru hoSoDieuTriNoiTru) {
		this.hoSoDieuTriNoiTru = hoSoDieuTriNoiTru;
	}

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
