package com.jwt.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Appoinment;



@Repository
public class AppoinmentDAOImpl implements AppoinmentDAO {

	@Autowired
	private SessionFactory sessionFactory1;

	@Override
	public void addAppoinments(Appoinment appoinment) {
		sessionFactory1.getCurrentSession().saveOrUpdate(appoinment);
		
	}

	@SuppressWarnings("unchecked")
	public List<Appoinment> getAllAppoinment() {
		return sessionFactory1.getCurrentSession().createQuery("from Appoinment")
				.list();
	}

	@Override
	public void deleteAppoinment(Integer AppoinmentID) {
		
		Appoinment appoinment  = (Appoinment) sessionFactory1.getCurrentSession().load(
				Appoinment.class, AppoinmentID);
		if (null != appoinment) {
			this.sessionFactory1.getCurrentSession().delete(appoinment);
		}
		
	}

	@Override
	public Appoinment getAppoinment(int AppoinmentID) {
		return (Appoinment) sessionFactory1.getCurrentSession().get(
				Appoinment.class, AppoinmentID);
	}

	@Override
	public Appoinment updateAppoinment(Appoinment appoinment) {
		sessionFactory1.getCurrentSession().update(appoinment);
		return appoinment;
	}


}
