package com.group4.cms.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "benh_nhan")
public class BenhNhan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maBenhNhan;

	@Column(name = "ten")
	private String tenBenhNhan;

	@Column(name = "gioi_tinh")
	private String gioiTinh;

	@Column(name = "ngay_sinh")
	private Date ngaySinh;

	@Column(name = "nghe_nghiep")
	private String ngheNghiep;

	@Column(name = "dia_chi")
	private String diaChi;

	@Column(name ="sdt")
	private String soDienThoai;

	@Column(name = "tien_su_benh")
	private String tienSuBenh;

	@Column(name = "ngay_tiep_nhan")
	private Date ngayTiepNhan;

	public int age() {
		Calendar ngaySinhCalendar = Calendar.getInstance();
		ngaySinhCalendar.setTime(ngaySinh);
		return Calendar.getInstance().get(Calendar.YEAR) - ngaySinhCalendar.get(Calendar.YEAR);
	}

	public int getMaBenhNhan() {
		return maBenhNhan;
	}

	public void setMaBenhNhan(int maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}

	public String getTenBenhNhan() {
		return tenBenhNhan;
	}

	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTienSuBenh() {
		return tienSuBenh;
	}

	public void setTienSuBenh(String tienSuBenh) {
		this.tienSuBenh = tienSuBenh;
	}

	public Date getNgayTiepNhan() {
		return ngayTiepNhan;
	}

	public void setNgayTiepNhan(Date ngayTiepNhan) {
		this.ngayTiepNhan = ngayTiepNhan;
	}
}
