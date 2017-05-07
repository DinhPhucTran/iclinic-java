package com.group4.cms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "giay_chuyen_vien")
public class GiayChuyenVien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maGiayChuyenVien;
	
	@ManyToOne
	@JoinColumn(name = "phieu_kham_benh_id")
	private PhieuKhamBenh phieuKhamBenh;
	
	@ManyToOne
	@JoinColumn(name = "bac_si_id")
	private User bacSi;
	
	@ManyToOne
	@JoinColumn(name = "giay_nhap_vien_id")
	private GiayNhapVien giayNhapVien;
	
	@Column(name = "ngay_chuyen")
	private Date ngayChuyenVien;
	
	@Column(name = "chan_doan")
	private String chanDoan;
	
	@Column(name = "tinh_trang")
	private String tinhTrang;
	
	@Column(name = "ly_do")
	private String lyDo;
	
	@Column(name = "benh_vien_den")
	private String benhVienDen;
	
	@Column(name = "ghi_chu")
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

	public User getBacSi() {
		return bacSi;
	}

	public void setBacSi(User bacSi) {
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
