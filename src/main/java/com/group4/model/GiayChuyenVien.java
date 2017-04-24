package com.group4.model;

import java.util.Date;

public class GiayChuyenVien {
	private int maGiayChuyenVien;
	private PhieuKhamBenh phieuKhamBenh;
	private NhanVien bacSi;
	private GiayNhapVien giayNhapVien;
	private Date ngayChuyenVien;
	private String chanDoan;
	private String tinhTrang;
	private String lyDo;
	private String benhVienDen;
	private String ghiChu;

	public int getMaGiayChuyenVien() {
		return maGiayChuyenVien;
	}

	public void setMaGiayChuyenVien(int maGiayChuyenVien) {
		this.maGiayChuyenVien = maGiayChuyenVien;
	}

	public PhieuKhamBenh getPhieuKhamBenh() {
		return phieuKhamBenh;
	}

	public void setPhieuKhamBenh(PhieuKhamBenh phieuKhamBenh) {
		this.phieuKhamBenh = phieuKhamBenh;
	}

	public NhanVien getBacSi() {
		return bacSi;
	}

	public void setBacSi(NhanVien bacSi) {
		this.bacSi = bacSi;
	}

	public GiayNhapVien getGiayNhapVien() {
		return giayNhapVien;
	}

	public void setGiayNhapVien(GiayNhapVien giayNhapVien) {
		this.giayNhapVien = giayNhapVien;
	}

	public Date getNgayChuyenVien() {
		return ngayChuyenVien;
	}

	public void setNgayChuyenVien(Date ngayChuyenVien) {
		this.ngayChuyenVien = ngayChuyenVien;
	}

	public String getChanDoan() {
		return chanDoan;
	}

	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public String getBenhVienDen() {
		return benhVienDen;
	}

	public void setBenhVienDen(String benhVienDen) {
		this.benhVienDen = benhVienDen;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
