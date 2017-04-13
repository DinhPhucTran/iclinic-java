package com.group4.model;

import java.util.Date;

public class HoSoDieuTriNoiTru {
	private int maHoSo;
	private BenhNhan benhNhan;
	private NhanVien bacSi;
	private NhanVien yTa;
	private Phong phong;
	private GiayNhapVien giayNhapVien;
	private Date ngayBatDauDieuTri;
	private Date ngayKetThucDieuTri;
	private String chanDoan;

	public int getMaHoSo() {
		return maHoSo;
	}

	public void setMaHoSo(int maHoSo) {
		this.maHoSo = maHoSo;
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

	public NhanVien getyTa() {
		return yTa;
	}

	public void setyTa(NhanVien yTa) {
		this.yTa = yTa;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public GiayNhapVien getGiayNhapVien() {
		return giayNhapVien;
	}

	public void setGiayNhapVien(GiayNhapVien giayNhapVien) {
		this.giayNhapVien = giayNhapVien;
	}

	public Date getNgayBatDauDieuTri() {
		return ngayBatDauDieuTri;
	}

	public void setNgayBatDauDieuTri(Date ngayBatDauDieuTri) {
		this.ngayBatDauDieuTri = ngayBatDauDieuTri;
	}

	public Date getNgayKetThucDieuTri() {
		return ngayKetThucDieuTri;
	}

	public void setNgayKetThucDieuTri(Date ngayKetThucDieuTri) {
		this.ngayKetThucDieuTri = ngayKetThucDieuTri;
	}

	public String getChanDoan() {
		return chanDoan;
	}

	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}
}
