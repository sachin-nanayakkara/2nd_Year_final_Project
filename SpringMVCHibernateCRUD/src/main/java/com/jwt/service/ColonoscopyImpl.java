package com.jwt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.ColonoscopyDAO;
import com.jwt.model.Colonoscopy;


@Service
@Transactional

public class ColonoscopyImpl implements ColonoscopyService {

	@Autowired
	private ColonoscopyDAO colonoscopyDAO;

	@Transactional
	public void addColonoscopy(Colonoscopy colonoscopy) {
		colonoscopyDAO.addColonoscopy(colonoscopy);
		
	}

	@Transactional
	public List<Colonoscopy> getAllColonoscopy() {
		return colonoscopyDAO.getAllColonoscopy();
	}

	@Transactional
	public void deleteColonoscopy(Integer colonoscopyID) {
		colonoscopyDAO.deleteColonoscopy(colonoscopyID);
		
	}

	
	public Colonoscopy getColonoscopy(int colonoscopyID) {
		return colonoscopyDAO.getColonoscopy(colonoscopyID);
	}

	@Override
	public Colonoscopy updateColonoscopy(Colonoscopy colonoscopy) {
		return colonoscopyDAO.updateColonoscopy(colonoscopy);
	}

	public void setColonoscopyDAO(ColonoscopyDAO colonoscopyDAO) {
		this.colonoscopyDAO = colonoscopyDAO;
	}

}
