package com.group4.cms.model;

import java.util.Date;

public class HoaDon {
	private int maHoaDon;
	private PhieuKhamDangCho phieuKham;
	private Date ngayThanhToan;
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
