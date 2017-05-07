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
@Table(name = "giay_nhap_vien")
public class GiayNhapVien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maGiayNhapVien;
	
	@ManyToOne
	@JoinColumn(name = "benh_nhan_id")
	private BenhNhan benhNhan;
	
	@ManyToOne
	@JoinColumn(name = "nhan_vien_tiep_nhan_id")
	private User nhanVienTiepNhan;
	
	@Column(name = "chan_doan")
	private String chanDoan;
	
	@Column(name = "ngay_nhap_vien")
	private Date ngayNhapVien;
	
	@Column(name = "ghi_chu")
	private String ghiChu;

	public User getNhanVienTiepNhan() {
		return nhanVienTiepNhan;
	}

	public void setNhanVienTiepNhan(User nhanVienTiepNhan) {
		this.nhanVienTiepNhan = nhanVienTiepNhan;
	}

	public int getMaGiayNhapVien() {
		return maGiayNhapVien;
	}

	public void setMaGiayNhapVien(int maGiayNhapVien) {
		this.maGiayNhapVien = maGiayNhapVien;
	}

	public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	public String getChanDoan() {
		return chanDoan;
	}

	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}

	public Date getNgayNhapVien() {
		return ngayNhapVien;
	}

	public void setNgayNhapVien(Date ngayNhapVien) {
		this.ngayNhapVien = ngayNhapVien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
