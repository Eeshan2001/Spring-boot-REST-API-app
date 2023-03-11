package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="citizens")
@SequenceGenerator(name="MySequence", sequenceName="citizen_seq", initialValue=1, allocationSize=1)
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
	
	public Vaccine() {
		
	}

	public Vaccine(int id, String name, int age, int contact, String vaccine_type, int status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.vaccine_type = vaccine_type;
		this.status = status;
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
}

