package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jwt.model.PatientDiagnosis;



@Repository


public class PatientDiagnosisImpl implements PatientDiagnosisDAO {


	@Autowired
	private SessionFactory sessionFactory1;

	
	public void addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
		sessionFactory1.getCurrentSession().saveOrUpdate(patientDiagnosis);
		
	}

	@SuppressWarnings("unchecked")
	public List<PatientDiagnosis> getAllPatientDiagnosis() {
		return sessionFactory1.getCurrentSession().createQuery("from PatientDiagnosis")
				.list();
	}

	
	public void deletePatientDiagnosis(Integer PatientDiagnosisId) {
		PatientDiagnosis patientDiagnosis  = (PatientDiagnosis) sessionFactory1.getCurrentSession().load(
				PatientDiagnosis.class, PatientDiagnosisId);
		if (null != patientDiagnosis) {
			this.sessionFactory1.getCurrentSession().delete(patientDiagnosis);
		}
		
	}

	
	public PatientDiagnosis getPatientDiagnosis(int PatientDiagnosisId) {
		return (PatientDiagnosis) sessionFactory1.getCurrentSession().get(
				PatientDiagnosis.class, PatientDiagnosisId);
	}

	
	public PatientDiagnosis updatePatientDiagnosis(
			PatientDiagnosis patientDiagnosis) {
		sessionFactory1.getCurrentSession().update(patientDiagnosis);
		return patientDiagnosis;
	}

	


}
