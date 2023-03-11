package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.dao;

import java.util.List;

import com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.entity.Vaccine;


public interface VaccineDAO {
	public List<Vaccine> findAll();
	public Vaccine findById(int theid);
	public void save(Vaccine theemployee);
	public void deleteCitizen(int theId);
}
