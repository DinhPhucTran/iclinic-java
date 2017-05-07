package com.group4.cms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "don_thuoc")
public class DonThuoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maDonThuoc;
	
	@Column(name = "ngay_ke_don")
	private Date ngayKeDon;
	
	@Column(name = "tong_tien")
	private double tongTien;
	
	@ManyToOne
	@JoinColumn(name = "ma_phieu_kham_dang_cho")
	private PhieuKhamDangCho phieuKham;
	
	@ManyToOne
	@JoinColumn(name = "duoc_si_id")
	private User duocSi;
	
	@OneToMany
	private List<ChiTietDonThuoc> dsThuoc;

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

	public User getDuocSi() {
		return duocSi;
	}

	public void setDuocSi(User duocSi) {
		this.duocSi = duocSi;
	}

	public List<ChiTietDonThuoc> getDsThuoc() {
		return dsThuoc;
	}

	public void setDsThuoc(List<ChiTietDonThuoc> dsThuoc) {
		this.dsThuoc = dsThuoc;
	}
	
}
