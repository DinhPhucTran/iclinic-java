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
@Table(name = "giay_phau_thuat")
public class GiayPhauThuat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maGiayPhauThuat;
	
	@ManyToOne
	@JoinColumn(name = "bac_si_id")
	private User bacSi;
	
	@ManyToOne
	@JoinColumn(name = "benh_nhan_id")
	private BenhNhan benhNhan;
	
	@ManyToOne
	@JoinColumn(name = "dv_id")
	private DichVu dichVu;
	
	@Column(name = "thoi_gian_thuc_hien")
	private Date thoiGianThucHien;

	public int getMaGiayPhauThuat() {
		return maGiayPhauThuat;
	}

	public void setMaGiayPhauThuat(int maGiayPhauThuat) {
		this.maGiayPhauThuat = maGiayPhauThuat;
	}

	public User getBacSi() {
		return bacSi;
	}

	public void setBacSi(User bacSi) {
		this.bacSi = bacSi;
	}

	public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public Date getThoiGianThucHien() {
		return thoiGianThucHien;
	}

	public void setThoiGianThucHien(Date thoiGianThucHien) {
		this.thoiGianThucHien = thoiGianThucHien;
	}
}
