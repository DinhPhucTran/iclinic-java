package com.group4.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "giay_ra_vien")
public class GiayRaVien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maGiay;
	
	@ManyToOne
	@JoinColumn(name = "benh_nhan_id")
	private BenhNhan benhNhan;
	
	@ManyToOne
	@JoinColumn(name = "giay_nhap_vien_id")
	private GiayNhapVien giayNhapVien;
	
	@ManyToOne
	@JoinColumn(name = "nhan_vien_id")
	private User bacSiDeNghi;
	
	@Column(name = "chan_doan")
	private String chanDoan;
	
	@Column(name = "loi_dan")
	private String loiDan;

	public int getMaGiay() {
		return maGiay;
	}

	public void setMaGiay(int maGiay) {
		this.maGiay = maGiay;
	}

	public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	public GiayNhapVien getGiayNhapVien() {
		return giayNhapVien;
	}

	public void setGiayNhapVien(GiayNhapVien giayNhapVien) {
		this.giayNhapVien = giayNhapVien;
	}

	public User getBacSiDeNghi() {
		return bacSiDeNghi;
	}

	public void setBacSiDeNghi(User bacSiDeNghi) {
		this.bacSiDeNghi = bacSiDeNghi;
	}

	public String getChanDoan() {
		return chanDoan;
	}

	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}

	public String getLoiDan() {
		return loiDan;
	}

	public void setLoiDan(String loiDan) {
		this.loiDan = loiDan;
	}
}
