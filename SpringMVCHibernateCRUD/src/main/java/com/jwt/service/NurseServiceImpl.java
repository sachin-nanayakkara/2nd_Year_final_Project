package com.jwt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jwt.dao.NurseDAO;

import com.jwt.model.Nurse;



@Service
@Transactional

public class NurseServiceImpl implements NurseService {

	@Autowired
	private NurseDAO nurseDAO;

	@Transactional
	public void addNurses(Nurse nurse) {
		nurseDAO.addNurses(nurse);
		
	}

	@Transactional
	public List<Nurse> getAllNurse() {
		return nurseDAO.getAllNurse();
	}

	@Transactional
	public void deleteNurse(Integer NurseID) {
		nurseDAO.deleteNurse(NurseID);
		
	}

	
	public Nurse getNurse(int NurseID) {
		return nurseDAO.getNurse(NurseID);
	}

	
	public Nurse updateNurse(Nurse nurse) {
		return nurseDAO.updateNurse(nurse);
	}
	
	public void setPatientMedicine(NurseDAO nurseDAO) {
		this.nurseDAO = nurseDAO;
	}
	
	

}
