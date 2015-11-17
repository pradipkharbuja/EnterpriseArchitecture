package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.Comment;

public interface CommentDAO {

	public void addComment(Comment comment);

	public List<Comment> getCommentsByPetId(int petId);
}
