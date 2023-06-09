package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="citizens")
@SequenceGenerator(name="MySequence", sequenceName="my_sequence", initialValue=1, allocationSize=1)
public class Vaccine {
	@Id	
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MySequence")
	@Column(name="citizen_id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="contact")
	private int contact;
	@Column(name="vaccine_type")
	private String vaccine_type;
	@Column(name="status")
	private int status;
	@Column(name="lastvaccinated")
	private Date lastVaccinated;
	
	
	

	public Vaccine() {
		
	}

	public Vaccine(int id, String name, int age, int contact, String vaccine_type, int status, Date lastVaccinated) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.vaccine_type = vaccine_type;
		this.status = status;
		this.lastVaccinated=lastVaccinated;
	}

	public Date getLastVaccinated() {
		return lastVaccinated;
	}

	public void setLastVaccinated(Date lastVaccinated) {
		this.lastVaccinated = lastVaccinated;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getVaccine_type() {
		return vaccine_type;
	}

	public void setVaccine_type(String vaccine_type) {
		this.vaccine_type = vaccine_type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CitizenInfo [id=" + id + "," + ", name=" + name + ", contact=" + contact + ", age="
				+ age + ", vaccineType=" + vaccine_type + ", doses=" + status + ", Last Vaccination Date="+ lastVaccinated+"]";
	}
}

