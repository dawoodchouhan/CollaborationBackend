package com.niit.collaborationbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Forum;


@Repository
public interface ForumDAO {

	
	
		
		public boolean saveOrUpdate(Forum forum);
		public boolean update(Forum forum);
		public boolean delete(Forum forum);
		/*public void saveOrUpdate(Forum forum);
		
		public void delete(int id);*/
		
		public List<Forum> list();
	
}