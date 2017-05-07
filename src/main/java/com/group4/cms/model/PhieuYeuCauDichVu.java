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
@Table(name = "phieu_yeu_cau_dich_vu")
public class PhieuYeuCauDichVu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maPhieuYeuCauDichVu;
	
	@ManyToOne
	@JoinColumn(name = "phieu_kham_id")
	private PhieuKhamBenh phieuKham;
	
	@ManyToOne
	@JoinColumn(name = "nhan_vien_id")
	private User nhanVien;
	
	@ManyToOne
	@JoinColumn(name = "dich_vu_id")
	private DichVu dichVu;
	
	@Column(name = "ngay_lap")
	private Date ngayLap;
	
	@Column(name = "thoi_gian_thuc_hien")
	private Date thoiGianThucHien;
	
	private double donGia;
	
	@Column(name = "chi_so")
	private String chiSo;
	
	@Column(name = "ket_qua")
	private String ketQua;
	
	@Column(name = "tinh_trang")
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

	public User getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(User nhanVien) {
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
