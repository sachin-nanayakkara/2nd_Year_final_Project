package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.PatientFee;



@Repository
public class PatientFeeDAOImpl implements PatientFeeDAO {

	@Autowired
	private SessionFactory sessionFactory1;

	@Override
	public void addPatientFee(PatientFee patientFee) {
		sessionFactory1.getCurrentSession().saveOrUpdate(patientFee);
		
	}

	@SuppressWarnings("unchecked")
	public List<PatientFee> getAllPatientFee() {
		return sessionFactory1.getCurrentSession().createQuery("from PatientFee")
				.list();
	}

	@Override
	public void deletePatientFee(Integer PatientFeeID) {
		PatientFee patientFee  = (PatientFee) sessionFactory1.getCurrentSession().load(
				PatientFee.class, PatientFeeID );
		if (null != patientFee) {
			this.sessionFactory1.getCurrentSession().delete(patientFee);
		}
		
	}

	@Override
	public PatientFee getPatientFee(int PatientFeeID) {
		return (PatientFee) sessionFactory1.getCurrentSession().get(
				PatientFee.class, PatientFeeID);
	}

	@Override
	public PatientFee updatePatientFee(PatientFee patientFee) {
		sessionFactory1.getCurrentSession().update(patientFee);
		return patientFee;
	}   

}
