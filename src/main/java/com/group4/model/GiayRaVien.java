package com.group4.model;

public class GiayRaVien {
	private int maGiay;
	private BenhNhan benhNhan;
	private GiayNhapVien giayNhapVien;
	private NhanVien nguoiLamThuTuc;
	private String chanDoan;
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

	public NhanVien getNguoiLamThuTuc() {
		return nguoiLamThuTuc;
	}

	public void setNguoiLamThuTuc(NhanVien nguoiLamThuTuc) {
		this.nguoiLamThuTuc = nguoiLamThuTuc;
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
