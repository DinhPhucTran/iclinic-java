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
@Table(name = "hoa_don")
public class HoaDon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maHoaDon;
	
	@ManyToOne
	@JoinColumn(name = "phieu_kham_dang_cho_id")
	private PhieuKhamDangCho phieuKham;
	
	@Column(name = "ngay_thanh_toan")
	private Date ngayThanhToan;
	
	@Column(name = "tong_tien")
	private double tongTien;

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public PhieuKhamDangCho getPhieuKham() {
		return phieuKham;
	}

	public void setPhieuKham(PhieuKhamDangCho phieuKham) {
		this.phieuKham = phieuKham;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
}
