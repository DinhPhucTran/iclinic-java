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
@Table(name = "phong")
public class Phong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maPhong;
	
	@Column(name = "ten_phong")
	private String tenPhong;
	
	@ManyToOne
	@JoinColumn(name = "dich_vu_id")
	private DichVu dichVu;

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
}
