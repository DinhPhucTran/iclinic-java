package com.group4.model;

import java.util.Date;

public class GiayNhapVien {
	private int maGiayNhapVien;
	private BenhNhan benhNhan;
	private NhanVien nhanVienTiepNhan;
	private String chanDoan;
	private Date ngayNhapVien;
	private String ghiChu;

	public NhanVien getNhanVienTiepNhan() {
		return nhanVienTiepNhan;
	}

	public void setNhanVienTiepNhan(NhanVien nhanVienTiepNhan) {
		this.nhanVienTiepNhan = nhanVienTiepNhan;
	}

	public int getMaGiayNhapVien() {
		return maGiayNhapVien;
	}

	public void setMaGiayNhapVien(int maGiayNhapVien) {
		this.maGiayNhapVien = maGiayNhapVien;
	}

	public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	public String getChanDoan() {
		return chanDoan;
	}

	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}

	public Date getNgayNhapVien() {
		return ngayNhapVien;
	}

	public void setNgayNhapVien(Date ngayNhapVien) {
		this.ngayNhapVien = ngayNhapVien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
