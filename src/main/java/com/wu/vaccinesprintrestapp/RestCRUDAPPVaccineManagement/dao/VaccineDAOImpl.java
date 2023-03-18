package com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.wu.vaccinesprintrestapp.RestCRUDAPPVaccineManagement.entity.Vaccine;

@Repository
public class VaccineDAOImpl implements VaccineDAO {
	private EntityManager entityManager;

	public VaccineDAOImpl(EntityManager theEntityManager) {
		// here entityManager is created by spring framework
		// we are just injecting it to in EmployeeDAOImpl using constructor
		this.entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Vaccine> findAll()
	{
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Vaccine> query=currentSession.createQuery("from Vaccine",Vaccine.class);
		List<Vaccine> citi=query.getResultList();
		return citi;
	}

	@Override
	@Transactional
	public Vaccine getCitizenByID(int id) {
		// TODO Auto-generated method stub
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Vaccine citi=currentSession.get(Vaccine.class,id);
		return citi;
	}
	@Override
	@Transactional
	public void addCitizen(Vaccine citizen)
	{
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(citizen);
	}
	@Override
	@Transactional
	public void updateCitizen(Vaccine citizen)
	{
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.merge(citizen);
	}
	

	
	@Transactional
	public void deleteCitizen(int id)
	{
		Session currentSession=entityManager.unwrap(Session.class);

	    Query theQuery=currentSession.createQuery("delete from Vaccine where citizen_id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}
}
