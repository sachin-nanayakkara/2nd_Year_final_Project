package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jwt.model.PatientDiet;

@Repository
public class PatientDietDAOImpl implements PatientDietDAO {


	@Autowired
	private SessionFactory sessionFactory1;

	@Override
	public void addPatientDiet(PatientDiet patientDiet) {
		sessionFactory1.getCurrentSession().saveOrUpdate(patientDiet);
		
	}

	@SuppressWarnings("unchecked")
	public List<PatientDiet> getAllPatientDiets() {
		return sessionFactory1.getCurrentSession().createQuery("from PatientDiet")
				.list();
	}

	@Override
	public void deletePatientDiets(Integer PatientDietId) {
		
		PatientDiet patientDiet  = (PatientDiet) sessionFactory1.getCurrentSession().load(
				PatientDiet.class,PatientDietId);
		if (null != patientDiet) {
			this.sessionFactory1.getCurrentSession().delete(patientDiet);
		}
		
	}

	@Override
	public PatientDiet getPatientDiets(int PatientDietId) {
		return (PatientDiet) sessionFactory1.getCurrentSession().get(
				PatientDiet.class, PatientDietId);
	}

	@Override
	public PatientDiet updatePatientDiet(PatientDiet patientDiet) {
		sessionFactory1.getCurrentSession().update(patientDiet);
		return patientDiet;
	}

	
	
}
