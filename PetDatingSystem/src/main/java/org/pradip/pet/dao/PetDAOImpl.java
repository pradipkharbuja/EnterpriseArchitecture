package org.pradip.pet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.Pet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PetDAOImpl implements PetDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Pet> listPets() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pet> petsList = session.createQuery("from Pet").list();
		return petsList;
	}

}
