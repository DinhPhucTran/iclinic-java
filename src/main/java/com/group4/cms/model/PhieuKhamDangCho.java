package com.group4.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phieu_kham_dang_cho")
public class PhieuKhamDangCho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "stt")
	private int soThuTu;
	
	@ManyToOne
	@JoinColumn(name = "phieu_kham_id")
	private PhieuKhamBenh phieuKhamBenh;

	public int getSoThuTu() {
		return soThuTu;
	}

	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}

	public PhieuKhamBenh getPhieuKhamBenh() {
		return phieuKhamBenh;
	}

	public void setPhieuKhamBenh(PhieuKhamBenh phieuKhamBenh) {
		this.phieuKhamBenh = phieuKhamBenh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
