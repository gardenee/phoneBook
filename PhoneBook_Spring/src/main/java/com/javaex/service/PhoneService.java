package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {

	
	@Autowired
	private PhoneDao phoneDao;
	
	
	public List<PersonVo> getPersonList() {
		List<PersonVo> personList = phoneDao.getPersonList();
		return personList;
	}
	
	
	public void personInsert(PersonVo personVo) {
		phoneDao.personInsert(personVo);
	}
	
	public void personDelete(int id) {
		phoneDao.personDelete(id);
	}
	
	public PersonVo getPerson(int id) {
		return phoneDao.getPerson(id);
	}
	
	public void personUpdate(PersonVo personVo) {
		phoneDao.personUpdate(personVo);
	}
}
