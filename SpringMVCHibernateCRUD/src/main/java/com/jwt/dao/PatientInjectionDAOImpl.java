package com.jwt.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jwt.model.PatientInjection;

@Repository
public class PatientInjectionDAOImpl implements PatientInjectionDAO {


	@Autowired
	private SessionFactory sessionFactory1;

	@Override
	public void addPatientInjection(PatientInjection patientInjection) {
		sessionFactory1.getCurrentSession().saveOrUpdate(patientInjection);
		
	}

	@SuppressWarnings("unchecked")
	public List<PatientInjection> getAllPatientInjections() {
		return sessionFactory1.getCurrentSession().createQuery("from PatientInjection")
				.list();
	}

	@Override
	public void deletePatientInjection(Integer PatientInjectionId) {
		
		PatientInjection patientInjection  = (PatientInjection) sessionFactory1.getCurrentSession().load(
				PatientInjection.class, PatientInjectionId);
		if (null != patientInjection) {
			this.sessionFactory1.getCurrentSession().delete(patientInjection);
		}
		
	}

	@Override
	public PatientInjection getPatientInjection(int PatientInjectionId) {
		return (PatientInjection) sessionFactory1.getCurrentSession().get(
				PatientInjection.class, PatientInjectionId);
	}

	@Override
	public PatientInjection updatePatientInjection(
			PatientInjection patientInjection) {
		sessionFactory1.getCurrentSession().update(patientInjection);
		return patientInjection;
	}

	
}
