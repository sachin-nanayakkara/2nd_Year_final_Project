package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.PatientFeeDAO;
import com.jwt.model.PatientFee;


@Service
@Transactional

public class PatientFeeServiceImpl implements PatientFeeService {

	@Autowired
	private PatientFeeDAO patientFeeDAO;

	@Transactional
	public void addPatientFee(PatientFee patientFee) {
		patientFeeDAO.addPatientFee(patientFee);
		
	}

	@Transactional
	public List<PatientFee> getAllPatientFee() {
		return patientFeeDAO.getAllPatientFee();
	}

	@Transactional
	public void deletePatientFee(Integer PatientFeeID) {
		patientFeeDAO.deletePatientFee(PatientFeeID);
		
	}

	@Override
	public PatientFee getPatientFee(int PatientFeeID) {
		return patientFeeDAO.getPatientFee(PatientFeeID);
	}

	@Override
	public PatientFee updatePatientFee(PatientFee patientFee) {
		return patientFeeDAO.updatePatientFee(patientFee);
	}
	
	public void setPatientFee(PatientFeeDAO patientFeeDAO) {
		this.patientFeeDAO = patientFeeDAO;
	}
	
}
