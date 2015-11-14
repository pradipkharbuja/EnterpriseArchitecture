package org.pradip.pet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.Owner;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class OwnerDAOImpl implements OwnerDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOwner(Owner owner) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(owner);
	}

	@Override
	public void udpateOwner(Owner owner) {
		Session session = sessionFactory.getCurrentSession();
		session.update(owner);
	}

	@Override
	public List<Owner> listOwners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidUser(Owner owner) {
		Session session = this.sessionFactory.getCurrentSession();

		String hql = "from Owner WHERE userName = :userName AND password = :password";
		Query query = session.createQuery(hql);
		query.setString("userName", owner.getUserName());
		query.setString("password", owner.getPassword());

		List<Owner> o = query.list();
		System.out.println("Size: " + o.size());
		
		return (! o.isEmpty());
	}
}
