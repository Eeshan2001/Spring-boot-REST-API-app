package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.dao;

import java.util.List;

import com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.entity.Vaccine;


public interface VaccineDAO {

	public List<Vaccine> findAll();
	public Vaccine  getCitizenByID(int id);
	public void addCitizen(Vaccine citizen);
	public void updateCitizen(Vaccine citizen);
	public void deleteCitizen(int id); 
}
