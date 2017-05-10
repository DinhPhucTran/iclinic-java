package com.group4.cms.dao.impl;

//@Repository("benhNhanDao")
//public class BenhNhanDaoImpl implements BenhNhanDao {
//
//	@Autowired
//	private EntityManager entityManager;
//
//	@SuppressWarnings("unchecked")
//	public List<BenhNhan> findAll() {
//		List<BenhNhan> result = entityManager.createNativeQuery("select * from benh_nhan").getResultList();
//		return result;
//	}
//
//	@Transactional
//	public BenhNhan save(BenhNhan benhNhan) {
//		Query query = entityManager.createNativeQuery(
//				"INSERT INTO benh_nhan (dia_chi, gioi_tinh, ngay_sinh, ngay_tiep_nhan, nghe_nghiep, sdt, ten, tien_su_benh) "
//						+ " VALUES(?,?,?,?,?,?,?,?)");
//		query.setParameter(1, benhNhan.getDiaChi());
//		query.setParameter(2, benhNhan.getGioiTinh());
//		query.setParameter(3, benhNhan.getNgaySinh());
//		query.setParameter(4, benhNhan.getNgayTiepNhan());
//		query.setParameter(5, benhNhan.getNgheNghiep());
//		query.setParameter(6, benhNhan.getSoDienThoai());
//		query.setParameter(7, benhNhan.getTenBenhNhan());
//		query.setParameter(8, benhNhan.getTienSuBenh());
//		query.executeUpdate();
//		return benhNhan;
//	}
//}
