package org.pradip.pet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.PetType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PetTypeDAOImpl implements PetTypeDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<PetType> getAllPetTypes() {
		Session session = sessionFactory.getCurrentSession();

		List<PetType> petTypes = session.createQuery("from PetType").list();

		return petTypes;
	}

}
