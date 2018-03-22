package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





import com.jwt.model.Stock;
import com.jwt.model.Urine;

@Repository

public class UrineDAOImpl implements UrineDAO {

	@Autowired
	private SessionFactory sessionFactory1;

	
	public void addUrine(Urine urine) {
		sessionFactory1.getCurrentSession().saveOrUpdate(urine);
		
	}

	@SuppressWarnings("unchecked")
	public List<Urine> getAllUrines() {
		return sessionFactory1.getCurrentSession().createQuery("from urine")
				.list();
	}

	
	public void deleteUrine(Integer urineId) {
		Urine urine  = (Urine) sessionFactory1.getCurrentSession().load(
				Urine.class, urineId);
		if (null != urine) {
			this.sessionFactory1.getCurrentSession().delete(urine);
		}
		
	}

	
	public Urine getUrine(int urineid) {
		return (Urine) sessionFactory1.getCurrentSession().get(
				Stock.class, urineid);
	}

	
	public Urine updateUrine(Urine urine) {
		sessionFactory1.getCurrentSession().update(urine);
		return urine;
	}   
	
}