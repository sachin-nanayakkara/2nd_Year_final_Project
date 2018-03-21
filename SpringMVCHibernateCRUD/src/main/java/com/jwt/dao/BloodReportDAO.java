package com.jwt.dao;

import java.util.List;

import com.jwt.model.Blood_Report;

public interface BloodReportDAO {

	public void addBloodReport(Blood_Report blood_Report);

	public List<Blood_Report> getAllBloodReports();

	public void deleteBloodReports(Integer BloodReportId);

	public Blood_Report getBloodReports(int BloodReportId);

	public Blood_Report updateBloodReport(Blood_Report blood_Report);
	
}
