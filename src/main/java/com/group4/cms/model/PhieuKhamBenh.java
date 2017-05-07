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
@Table(name = "phieu_kham_benh")
public class PhieuKhamBenh {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maPhieuKhamBenh;
	
	@ManyToOne
	@JoinColumn(name = "benh_nhan_id")
	private BenhNhan benhNhan;
	
	@ManyToOne
	@JoinColumn(name = "bac_si_id")
	private User bacSi;
	
	@Column(name = "ngay_kham")
	private Date ngayKham;
	
	@Column(name = "ly_do")
	private String lyDoKham;
	
	@Column(name = "chan_doan")
	private String chanDoan;
	
	@Column(name = "loi_dan")
	private String loiDan;
	
	@Column(name = "tinh_trang_thanh_toan")
	private boolean tinhTrangThanhToan;

	public int getMaPhieuKhamBenh() {
		return maPhieuKhamBenh;
	}

	public void setMaPhieuKhamBenh(int maPhieuKhamBenh) {
		this.maPhieuKhamBenh = maPhieuKhamBenh;
	}

	public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	public User getBacSi() {
		return bacSi;
	}

	public void setBacSi(User bacSi) {
		this.bacSi = bacSi;
	}

	public Date getNgayKham() {
		return ngayKham;
	}

	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}

	public String getLyDoKham() {
		return lyDoKham;
	}

	public void setLyDoKham(String lyDoKham) {
		this.lyDoKham = lyDoKham;
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

	public boolean isTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}

	public void setTinhTrangThanhToan(boolean tinhTrangThanhToan) {
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}
}
