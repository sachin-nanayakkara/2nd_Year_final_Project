package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Blood_Report;



@Repository

public class BloodReportDAOImpl implements BloodReportDAO {


		@Autowired
		private SessionFactory sessionFactory1;

		@Override
		public void addBloodReport(Blood_Report blood_Report) {
			sessionFactory1.getCurrentSession().saveOrUpdate(blood_Report);
		}

		@SuppressWarnings("unchecked")
		public List<Blood_Report> getAllBloodReports() {
			return sessionFactory1.getCurrentSession().createQuery("from Blood_Report")
					.list();
		}

		@Override
		public void deleteBloodReports(Integer BloodReportId) {
			
			Blood_Report blood_Report  = (Blood_Report) sessionFactory1.getCurrentSession().load(
					Blood_Report.class, BloodReportId);
			if (null != blood_Report) {
				this.sessionFactory1.getCurrentSession().delete(blood_Report);
			}
			
		}

		@Override
		public Blood_Report getBloodReports(int BloodReportId) {
			return (Blood_Report) sessionFactory1.getCurrentSession().get(
					Blood_Report.class, BloodReportId);
		}

		@Override
		public Blood_Report updateBloodReport(Blood_Report blood_Report) {
			sessionFactory1.getCurrentSession().update(blood_Report);
			return blood_Report;
		}    
		
	
}
