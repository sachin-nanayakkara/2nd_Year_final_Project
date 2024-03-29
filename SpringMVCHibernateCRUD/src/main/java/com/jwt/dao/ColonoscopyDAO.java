package com.jwt.dao;

import java.util.List;

import com.jwt.model.Colonoscopy;

public interface ColonoscopyDAO {

	public void addColonoscopy(Colonoscopy colonoscopy);

	public List<Colonoscopy> getAllColonoscopy();

	public void deleteColonoscopy(Integer colonoscopyID);

	public Colonoscopy getColonoscopy(int colonoscopyID);

	public Colonoscopy updateColonoscopy(Colonoscopy colonoscopy);
	
}
