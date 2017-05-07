package com.group4.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chi_tiet_don_thuoc")
public class ChiTietDonThuoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maChiTiet;
	
	//private DonThuoc donThuoc;
	
	@ManyToOne
	@JoinColumn(name = "thuoc_id")
	private Thuoc thuoc;
	
	@Column(name = "don_gia")
	private double donGia;
	
	@Column(name = "so_luong")
	private int soLuong;
	
	@Column(name ="sang")
	private int sang;
	
	@Column(name = "trua")
	private int trua;
	
	@Column(name = "chieu")
	private int chieu;
	
	@Column(name = "toi")
	private int toi;
	
	@Column(name = "loi_dan")
	private String loiDan;

	public int getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(int maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	/*public DonThuoc getDonThuoc() {
		return donThuoc;
	}

	public void setDonThuoc(DonThuoc donThuoc) {
		this.donThuoc = donThuoc;
	}*/

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
