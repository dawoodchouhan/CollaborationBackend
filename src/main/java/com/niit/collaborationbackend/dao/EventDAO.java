package com.niit.collaborationbackend.dao;

import com.niit.collaborationbackend.model.Event;

public interface EventDAO {
	public void saveOrUpdate(Event event);
	public Event get(String id);

}
