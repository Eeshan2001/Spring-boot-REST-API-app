package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.dao.VaccineDAO;
import com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.entity.Vaccine;

@RestController
@RequestMapping("/api")
public class VaccineRestController {
	private VaccineDAO vaccineDAO;
	private Vaccine vaccine;
	public VaccineRestController(VaccineDAO thevaccineDAO) {
		this.vaccineDAO = thevaccineDAO;
	}
	
	@GetMapping("/vaccination")
	public List<Vaccine> findAll(){
		return vaccineDAO.findAll();
	}
	
	@GetMapping("/vaccination/{citizen_id}")
	public Vaccine getECitizen(@PathVariable int citizenID){
		return vaccineDAO.findById(citizenID);
	}
	
	@PostMapping("/vaccination")
	public Vaccine addCitizen(@RequestBody Vaccine thevaccine) {
		thevaccine.setId(0);
		vaccineDAO.save(thevaccine);
		return thevaccine;
	}
	@PutMapping("/vaccination")
	public Vaccine updateEmployee(@RequestBody Vaccine thevaccine) {
		
		vaccineDAO.save(thevaccine);
		
		return thevaccine;
	}
	
	@DeleteMapping("/vaccination/{citizen_id}")
	public String deleteCitizen(@PathVariable int citizen_id) {
		if(vaccine.getStatus() <= 1) {
			return "Citizen cannot be deleted until two doses are complete";
		}
		else {
		vaccineDAO.deleteCitizen(citizen_id);
		return "Deleted the employee with id "+ citizen_id;
	
		}
	}
}
