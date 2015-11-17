package org.pradip.pet.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pradip.pet.model.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CommentDAOImpl implements CommentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		comment.setCommentDate(new Date());
		session.persist(comment);
	}

	@Override
	public List<Comment> getCommentsByPetId(int petId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Comment WHERE petId = " + petId + " ORDER BY commentDate ASC";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
