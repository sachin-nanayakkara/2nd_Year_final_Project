package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;






import com.jwt.model.BiochemistryTest;
import com.jwt.model.Stock;

@Repository

public class BiochemistryTestDAOImpl implements BiochemistryTestDAO {

	@Autowired
	private SessionFactory sessionFactory1;

	@Override
	public void addBiochemistryTest(BiochemistryTest biochemistryTest) {
		sessionFactory1.getCurrentSession().saveOrUpdate(biochemistryTest);
		
	}

	@SuppressWarnings("unchecked")
	public List<BiochemistryTest> getAllBiochemistryTests() {
		return sessionFactory1.getCurrentSession().createQuery("from BiochemistryTest")
				.list();
	}

	@Override
	public void deleteBiochemistryTest(Integer BiochemistryTestId) {
		
		BiochemistryTest biochemistryTest  = (BiochemistryTest) sessionFactory1.getCurrentSession().load(
				BiochemistryTest.class, BiochemistryTestId);
		if (null != biochemistryTest) {
			this.sessionFactory1.getCurrentSession().delete(biochemistryTest);
		}
		
	}

	@Override
	public BiochemistryTest getBiochemistryTest(int BiochemistryTestid) {
		return (BiochemistryTest) sessionFactory1.getCurrentSession().get(
				Stock.class, BiochemistryTestid);
	}

	@Override
	public BiochemistryTest updateBiochemistryTest(
			BiochemistryTest biochemistryTest) {
		sessionFactory1.getCurrentSession().update(biochemistryTest);
		return biochemistryTest;
	}    

	
	
}