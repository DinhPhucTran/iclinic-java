package com.group4.model;

import java.util.Date;

public class PhieuKhamBenh {
	private int maPhieuKhamBenh;
	private BenhNhan benhNhan;
	private NhanVien bacSi;
	private Date ngayKham;
	private String lyDoKham;
	private String chanDoan;
	private String loiDan;
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

	public NhanVien getBacSi() {
		return bacSi;
	}

	public void setBacSi(NhanVien bacSi) {
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
