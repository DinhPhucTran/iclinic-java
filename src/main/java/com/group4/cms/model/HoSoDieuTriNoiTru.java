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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ho_so_dieu_tri_noi_tru")
public class HoSoDieuTriNoiTru {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maHoSo;
	
	
	@ManyToOne
	@JoinColumn(name = "benh_nhan_id")
	private BenhNhan benhNhan;
	
	@ManyToOne
	@JoinColumn(name = "bac_si_id")
	private User bacSi;
	
	@ManyToOne
	@JoinColumn(name = "y_ta_id")
	private User yTa;
	
	@ManyToOne
	@JoinColumn(name = "phong_id")
	private Phong phong;
	
	@OneToOne
	private GiayNhapVien giayNhapVien;
	
	@Column(name = "ngay_bat_dau")
	private Date ngayBatDauDieuTri;
	
	@Column(name = "ngay_ket_thuc")
	private Date ngayKetThucDieuTri;
	
	@Column(name = "chan_doan")
	private String chanDoan;
	
	@OneToMany
	private List<ChiTietDieuTri> dsChiTietDieuTri;

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

	public User getBacSi() {
		return bacSi;
	}

	public void setBacSi(User bacSi) {
		this.bacSi = bacSi;
	}

	public User getyTa() {
		return yTa;
	}

	public void setyTa(User yTa) {
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

	public List<ChiTietDieuTri> getDsChiTietDieuTri() {
		return dsChiTietDieuTri;
	}

	public void setDsChiTietDieuTri(List<ChiTietDieuTri> dsChiTietDieuTri) {
		this.dsChiTietDieuTri = dsChiTietDieuTri;
	}
}
