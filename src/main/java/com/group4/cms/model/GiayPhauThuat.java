package com.group4.cms.model;

import java.util.Date;

public class GiayPhauThuat {
	private int maGiayPhauThuat;
	private NhanVien bacSi;
	private BenhNhan benhNhan;
	private DichVu dichVu;
	private Date thoiGianThucHien;

	public int getMaGiayPhauThuat() {
		return maGiayPhauThuat;
	}

	public void setMaGiayPhauThuat(int maGiayPhauThuat) {
		this.maGiayPhauThuat = maGiayPhauThuat;
	}

	public NhanVien getBacSi() {
		return bacSi;
	}

	public void setBacSi(NhanVien bacSi) {
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
