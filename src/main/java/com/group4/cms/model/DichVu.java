package com.group4.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dich_vu")
public class DichVu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maDichVu;
	
	@Column(name = "ten_dv")
	private int tenDichVu;
	
	@Column(name = "don_gia")
	private int donGia;

	public int getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}

	public int getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(int tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
}
