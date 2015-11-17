package org.pradip.pet.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.EmailOwner;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EmailOwnerDAOImpl implements EmailOwnerDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveEmailRecord(EmailOwner emailOwner) {
		Session session = sessionFactory.getCurrentSession();
		emailOwner.setEmailRequested(new Date());
		session.save(emailOwner);
	}

	@Override
	public List<EmailOwner> getUnSentRecords() {
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from EmailOwner WHERE hasEmailSent = 0");
		return query.list();
	}

	@Override
	public void updateEmailRecord(EmailOwner emailOwner) {
		Session session = sessionFactory.getCurrentSession();
		session.update(emailOwner);
	}

}
