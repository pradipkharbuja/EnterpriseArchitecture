package org.pradip.pet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.Owner;
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
	public List<Pet> getAllPets() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pet> petsList = session.createQuery("from Pet").list();
		return petsList;
	}

	@Override
	public List<Pet> getOthersPets(Owner owner) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Pet WHERE owner.ownerId <> :ownerId AND owner.city = :city";
		Query query = session.createQuery(hql);
		query.setParameter("ownerId", owner.getOwnerId());
		query.setParameter("city", owner.getCity());

		List<Pet> petsList = query.list();
		return petsList;
	}

	@Override
	public List<Pet> getMyPets(Owner owner) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Pet WHERE ownerId = :ownerId";
		Query query = session.createQuery(hql);
		query.setParameter("ownerId", owner.getOwnerId());

		List<Pet> petsList = query.list();
		return petsList;
	}

	@Override
	public Pet getPetById(int petId) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Pet WHERE petId = :petId";
		Query query = session.createQuery(hql);
		query.setParameter("petId", petId);

		List<Pet> petsList = query.list();
		if (petsList.size() > 0) {
			return petsList.get(0);
		}
		return new Pet();
	}

	@Override
	public void deletePet(Pet pet) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(pet);
	}

	@Override
	public void addPet(Pet pet) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(pet);
	}

	@Override
	public void updatePet(Pet pet) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pet);
	}

}
