package com.jwt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_tbl")


public class Doctor implements Serializable {

	private static final long serialVersionUID = -3499252052454502841L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DID;
	
	@Column
	private String name;
	
	@Column
	private String speciality;
	
	@Column
	private String mbbs_no;

	

	public int getDID() {
		return DID;
	}

	public void setDID(int dID) {
		DID = dID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getMbbs_no() {
		return mbbs_no;
	}

	public void setMbbs_no(String mbbs_no) {
		this.mbbs_no = mbbs_no;
	}
	
	

}
