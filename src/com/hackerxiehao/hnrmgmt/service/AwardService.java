package com.hackerxiehao.hnrmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerxiehao.hnrmgmt.dao.AwardDao;
import com.hackerxiehao.hnrmgmt.entities.Award;

@Service
public class AwardService {
	@Autowired
	private AwardDao awardDao = new AwardDao();

	public List<Award> getAll() {
		return awardDao.getAll();
	}

	public Award get(String id) {
		return awardDao.get(id);
	}

	public void save(Award award) {
		awardDao.save(award);
	}

	public void delete(String awdID) {
		awardDao.delete(awdID);
	}

	public void modify(Award award) {
		awardDao.modify(award);
	}
}
