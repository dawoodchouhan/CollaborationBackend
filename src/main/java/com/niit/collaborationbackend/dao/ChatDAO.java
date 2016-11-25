package com.niit.collaborationbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Chat;

@Repository
public interface ChatDAO {


		public boolean save(Chat chat);
		public boolean update(Chat chat);
		public boolean delete(Chat chat);
		public List<Chat> list();
	
}
