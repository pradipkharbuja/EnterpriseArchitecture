package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.CommentDAO;
import org.pradip.pet.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	public void addComment(Comment comment) {
		commentDAO.addComment(comment);
	}

	@Override
	public List<Comment> getCommentsByPetId(int petId) {
		return commentDAO.getCommentsByPetId(petId);
	}

}
