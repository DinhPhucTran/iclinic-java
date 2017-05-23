package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.HoSoDieuTriNoiTru;

public interface HoSoDieuTriService {

	public List<HoSoDieuTriNoiTru> findAll();

	public HoSoDieuTriNoiTru save(HoSoDieuTriNoiTru hoSoDieuTriNoiTru);

	public void delete(int id);

	public HoSoDieuTriNoiTru findById(int id);
}
