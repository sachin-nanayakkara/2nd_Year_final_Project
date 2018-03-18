package com.jwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_TBL")

public class Item implements Serializable {

	private static final long serialVersionUID = -344571707458636847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String emailx;

	@Column
	private String addressx;

	@Column
	private String telephone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailx() {
		return emailx;
	}

	public void setEmailx(String emailx) {
		this.emailx = emailx;
	}

	public String getAddressx() {
		return addressx;
	}

	public void setAddressx(String addressx) {
		this.addressx = addressx;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	
}
