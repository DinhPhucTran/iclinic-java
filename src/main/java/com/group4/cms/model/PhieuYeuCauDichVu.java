package com.group4.cms.model;

import java.util.Date;

public class PhieuYeuCauDichVu {
	private int maPhieuYeuCauDichVu;
	private PhieuKhamBenh phieuKham;
	private NhanVien nhanVien;
	private DichVu dichVu;
	private Date ngayLap;
	private Date thoiGianThucHien;
	private double donGia;
	private String chiSo;
	private String ketQua;
	private boolean tinhTrangKham;

	public int getMaPhieuYeuCauDichVu() {
		return maPhieuYeuCauDichVu;
	}

	public void setMaPhieuYeuCauDichVu(int maPhieuYeuCauDichVu) {
		this.maPhieuYeuCauDichVu = maPhieuYeuCauDichVu;
	}

	public PhieuKhamBenh getPhieuKham() {
		return phieuKham;
	}

	public void setPhieuKham(PhieuKhamBenh phieuKham) {
		this.phieuKham = phieuKham;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getThoiGianThucHien() {
		return thoiGianThucHien;
	}

	public void setThoiGianThucHien(Date thoiGianThucHien) {
		this.thoiGianThucHien = thoiGianThucHien;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getChiSo() {
		return chiSo;
	}

	public void setChiSo(String chiSo) {
		this.chiSo = chiSo;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	public boolean isTinhTrangKham() {
		return tinhTrangKham;
	}

	public void setTinhTrangKham(boolean tinhTrangKham) {
		this.tinhTrangKham = tinhTrangKham;
	}
}
