package com.group4.cms.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group4.cms.dao.BenhNhanDao;
import com.group4.cms.model.BenhNhan;

@Repository("benhNhanDao")
public class BenhNhanDaoImpl implements BenhNhanDao {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<BenhNhan> findAll() {
		List<BenhNhan> result = entityManager.createQuery("select c from BenhNhan c").getResultList();
		return result;
	}

	@Transactional
	public BenhNhan save(BenhNhan benhNhan) {
//		benhNhan = new BenhNhan();
//		benhNhan.setTenBenhNhan("abc");
//		benhNhan.setDiaChi("quận 1");
//		benhNhan.setGioiTinh("nam");
//		benhNhan.setNgaySinh(new Date());
//		benhNhan.setNgayTiepNhan(new Date());
//		benhNhan.setNgheNghiep("bacsi");
//		benhNhan.setSoDienThoai("09090909099");
//		benhNhan.setTienSuBenh("tiền sử bệnh");
		Query query = entityManager.createNativeQuery(
				"INSERT INTO benh_nhan (dia_chi, gioi_tinh, ngay_sinh, ngay_tiep_nhan, nghe_nghiep, sdt, ten, tien_su_benh) "
						+ " VALUES(?,?,?,?,?,?,?,?)");
		query.setParameter(1, benhNhan.getDiaChi());
		query.setParameter(2, benhNhan.getGioiTinh());
		query.setParameter(3, benhNhan.getNgaySinh());
		query.setParameter(4, benhNhan.getNgayTiepNhan());
		query.setParameter(5, benhNhan.getNgheNghiep());
		query.setParameter(6, benhNhan.getSoDienThoai());
		query.setParameter(7, benhNhan.getTenBenhNhan());
		query.setParameter(8, benhNhan.getTienSuBenh());
		query.executeUpdate();
		return benhNhan;
	}

	public void delete(int id) {
	}

	public BenhNhan findById(int id) {
		return null;
	}

}
