package com.group4.cms.model;

import java.util.Calendar;
import java.util.Date;

public class BenhNhan {
	private int maBenhNhan;
	private String tenBenhNhan;
	private String gioiTinh;
	private Date ngaySinh;
	private String ngheNghiep;
	private String diaChi;
	private String soDienThoai;
	private String tienSuBenh;
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
