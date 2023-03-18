package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

	public VaccineRestController(VaccineDAO thevaccineDAO) {
		this.vaccineDAO = thevaccineDAO;
	}
	
		@GetMapping("/Citizens")
		public List<Vaccine> displayCitizen()
		{
				return vaccineDAO.findAll();
				
		}
		 
		@GetMapping("/Citizens/{id}")
		public Vaccine getCitizen(@PathVariable int id)
		{
			return vaccineDAO.getCitizenByID(id);
		    
		}

		@PostMapping("/Citizens")
		public String addCitizen(@RequestBody Vaccine citi)
		{
			if(citi.getAge()>=18)
			{
				citi.setId(0);;
				//citi.setVaccine_type("none");
				citi.setStatus(0);
				citi.setLastVaccinated(new Date());
				vaccineDAO.addCitizen(citi);	
				return "Registration Completed!!!";
			}
			else {
				return "Age must be greater than or equal to 18 for registration.";
			}
			
		}
		

		@PutMapping("/Citizens")
		public String updateCitizen(@RequestBody Vaccine citi)
		{
			int prev_DoseStatus = vaccineDAO.getCitizenByID(citi.getId()).getStatus();
			int curr_DoseStatus = citi.getStatus();
			System.out.println(prev_DoseStatus);
			System.out.println(curr_DoseStatus);
			if(prev_DoseStatus == 0 && curr_DoseStatus == 1) {
				vaccineDAO.updateCitizen(citi);
				return citi.getName()+" vaccinated with "+
				citi.getVaccine_type()	+" Dose no: "+citi.getStatus();
			}
			else if((prev_DoseStatus==1 && curr_DoseStatus==2) || (prev_DoseStatus==2 && curr_DoseStatus==3))
			{
				String prevVaccineName = vaccineDAO.getCitizenByID(citi.getId()).getVaccine_type();
				String currVaccineName = citi.getVaccine_type();
				//System.out.println(prevVaccineName);
				//System.out.println(currVaccineName);
				Date prev_VaccineDate = vaccineDAO.getCitizenByID(citi.getId()).getLastVaccinated();	
				Date curr_VaccineDate= citi.getLastVaccinated();
				
				long diff_In_Millies = Math.abs(curr_VaccineDate.getTime() - prev_VaccineDate.getTime());
			    long diff_In_Days = TimeUnit.DAYS.convert(diff_In_Millies, TimeUnit.MILLISECONDS);
			    
			    if(diff_In_Days<120)
			    	return "There should be a gap of 120 days between two consecutive vaccine doses";
				if(!(prevVaccineName.equalsIgnoreCase(currVaccineName)))
						return "vaccine should be same as the previous vaccine.";
			    if(prevVaccineName.equalsIgnoreCase(currVaccineName) && diff_In_Days>=120)
			    {
			    	vaccineDAO.updateCitizen(citi);
			    	return citi.getName()+" vaccinated with "+
					   citi.getVaccine_type()	+" Dose no: "+citi.getStatus();
			    }
			}
			else {    
				if(prev_DoseStatus+1 != curr_DoseStatus)
					return "Cannot give dose "+curr_DoseStatus+" for the second time.";
			}
			return "";
		}
		
		@DeleteMapping("/Citizens/{citizen_id}")
		public String deleteCitizen(@PathVariable int citizen_id)
		{
			int prev_DoseStatus = vaccineDAO.getCitizenByID(citizen_id).getStatus();
			if(prev_DoseStatus==3)
			{
				vaccineDAO.deleteCitizen(citizen_id);
				return "Vaccination completed with Booster Dose. Clearing the record!"; 
			}
			else
				return "You are still not fully vaccinated.";
		}
		

}
