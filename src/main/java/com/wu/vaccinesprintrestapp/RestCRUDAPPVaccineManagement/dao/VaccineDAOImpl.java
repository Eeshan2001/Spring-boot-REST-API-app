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
	public List<Vaccine> findAll() {
		// getting current session of hibernate using EntityManager object
		Session currentSession = entityManager.unwrap(Session.class);

		// creating query using creatQuery() method of session class
		Query<Vaccine> theQuery = currentSession.createQuery("from citizens", Vaccine.class);

		// executing query and getting result
		List<Vaccine> vaccine = theQuery.getResultList();
		return vaccine;
	}

	@Override
	@Transactional
	public Vaccine findById(int theid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Vaccine vaccine= currentSession.get(Vaccine.class, theid);
		
		return vaccine;
	}

	@Override
	@Transactional
	public void save(Vaccine thevaccine) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(thevaccine);

	}

	@Override
	@Transactional
	public void deleteCitizen(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Citizen where id=:citizenId");
		theQuery.setParameter("citizenId", theId);
		theQuery.executeUpdate();

	}

}
