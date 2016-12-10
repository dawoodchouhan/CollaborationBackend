package com.niit.collaborationbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.BlogComment;



@Repository("blogCommentDAO")
public interface BlogCommentDAO {
	public boolean save(BlogComment blogComment);
	public List<BlogComment> list();
	public BlogComment get(int id); 
	
}
