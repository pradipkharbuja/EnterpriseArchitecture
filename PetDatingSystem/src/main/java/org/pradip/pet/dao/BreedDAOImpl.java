package org.pradip.pet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.Breed;
import org.pradip.pet.model.PetType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BreedDAOImpl implements BreedDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Breed> getAllBreeds() {
		Session session = sessionFactory.getCurrentSession();
		List<Breed> breedLists = session.createQuery("from Breed").list();
		return breedLists;
	}

	@Override
	public List<Breed> getBreedByPetType(PetType petType) {
		// TODO Auto-generated method stub
		return null;
	}

}
