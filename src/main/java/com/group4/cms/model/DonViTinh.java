package com.group4.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "don_vi_tinh")
public class DonViTinh {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maDonViTinh;
	
	@Column(name = "ten_dvt")
	private String tenDonViTinh;

	public int getMaDonViTinh() {
		return this.maDonViTinh;
	}

	public void setMaDonViTinh(int maDonViTinh) {
		this.maDonViTinh = maDonViTinh;
	}

	public String getTenDonViTinh() {
		return this.tenDonViTinh;
	}

	public void setTenDonViTinh(String tenDonViTinh) {
		this.tenDonViTinh = tenDonViTinh;
	}
}
