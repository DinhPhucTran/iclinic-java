package com.group4.cms.model;

public class ChiTietDonThuoc {
	private int maChiTiet;
	private DonThuoc donThuoc;
	private Thuoc thuoc;
	private double donGia;
	private int soLuong;
	private int sang;
	private int trua;
	private int chieu;
	private int toi;
	private String loiDan;

	public int getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(int maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public DonThuoc getDonThuoc() {
		return donThuoc;
	}

	public void setDonThuoc(DonThuoc donThuoc) {
		this.donThuoc = donThuoc;
	}

	public Thuoc getThuoc() {
		return thuoc;
	}

	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getSang() {
		return sang;
	}

	public void setSang(int sang) {
		this.sang = sang;
	}

	public int getTrua() {
		return trua;
	}

	public void setTrua(int trua) {
		this.trua = trua;
	}

	public int getChieu() {
		return chieu;
	}

	public void setChieu(int chieu) {
		this.chieu = chieu;
	}

	public int getToi() {
		return toi;
	}

	public void setToi(int toi) {
		this.toi = toi;
	}

	public String getLoiDan() {
		return loiDan;
	}

	public void setLoiDan(String loiDan) {
		this.loiDan = loiDan;
	}
}
