package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.model.Comment;

public interface CommentService {

	public void addComment(Comment comment);

	public List<Comment> getCommentsByPetId(int petId);
}
