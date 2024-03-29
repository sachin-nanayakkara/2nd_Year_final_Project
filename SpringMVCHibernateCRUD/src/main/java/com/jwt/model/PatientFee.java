package com.jwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_fee")


public class PatientFee implements Serializable {
	
	private static final long serialVersionUID = -3462817274585301247L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipt_no;
	
	@Column
	private int registration_no;
	
	@Column
	private String date;
	
	@Column
	private int total_fee;
	
	@Column
	private int recipy_name;
	
	@Column
	private int dgnosios_charge;
	
	@Column
	private int xray_charge;
	
	@Column
	private int ecg_charge;
	
	@Column	
	private int labtest_charge;
	
	@Column
	private int injection_charge;
	
	@Column	
	private int colonoscopy_charge;

	public int getRecipt_no() {
		return recipt_no;
	}

	public void setRecipt_no(int recipt_no) {
		this.recipt_no = recipt_no;
	}

	public int getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(int registration_no) {
		this.registration_no = registration_no;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRecipy_name() {
		return recipy_name;
	}

	public void setRecipy_name(int recipy_name) {
		this.recipy_name = recipy_name;
	}

	public int getDgnosios_charge() {
		return dgnosios_charge;
	}

	public void setDgnosios_charge(int dgnosios_charge) {
		this.dgnosios_charge = dgnosios_charge;
	}

	public int getXray_charge() {
		return xray_charge;
	}

	public void setXray_charge(int xray_charge) {
		this.xray_charge = xray_charge;
	}

	public int getEcg_charge() {
		return ecg_charge;
	}

	public void setEcg_charge(int ecg_charge) {
		this.ecg_charge = ecg_charge;
	}

	public int getLabtest_charge() {
		return labtest_charge;
	}

	public void setLabtest_charge(int labtest_charge) {
		this.labtest_charge = labtest_charge;
	}

	public int getInjection_charge() {
		return injection_charge;
	}

	public void setInjection_charge(int injection_charge) {
		this.injection_charge = injection_charge;
	}

	public int getColonoscopy_charge() {
		return colonoscopy_charge;
	}

	public void setColonoscopy_charge(int colonoscopy_charge) {
		this.colonoscopy_charge = colonoscopy_charge;
	}
	
	
}
