package com.group4.model;

import java.util.Date;

public class DonThuoc {
	private int maDonThuoc;
	private Date ngayKeDon;
	private double tongTien;
	private PhieuKhamDangCho phieuKham;
	private NhanVien duocSi;

	public int getMaDonThuoc() {
		return maDonThuoc;
	}

	public void setMaDonThuoc(int maDonThuoc) {
		this.maDonThuoc = maDonThuoc;
	}

	public Date getNgayKeDon() {
		return ngayKeDon;
	}

	public void setNgayKeDon(Date ngayKeDon) {
		this.ngayKeDon = ngayKeDon;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public PhieuKhamDangCho getPhieuKham() {
		return phieuKham;
	}

	public void setPhieuKham(PhieuKhamDangCho phieuKham) {
		this.phieuKham = phieuKham;
	}

	public NhanVien getDuocSi() {
		return duocSi;
	}

	public void setDuocSi(NhanVien duocSi) {
		this.duocSi = duocSi;
	}
}
