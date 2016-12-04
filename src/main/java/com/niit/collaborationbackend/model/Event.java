package com.niit.collaborationbackend.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Event extends BaseDomain{

	@Id
	private String event_Id;
	private String event_Name;
	private String event_Venue;
	private String event_Description;
	private Date dateTime;
	public String getEvent_Id() {
		return event_Id;
	}
	public void setEvent_Id(String event_Id) {
		this.event_Id = event_Id;
	}
	public String getEvent_Name() {
		return event_Name;
	}
	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}
	public String getEvent_Venue() {
		return event_Venue;
	}
	public void setEvent_Venue(String event_Venue) {
		this.event_Venue = event_Venue;
	}
	public String getEvent_Description() {
		return event_Description;
	}
	public void setEvent_Description(String event_Description) {
		this.event_Description = event_Description;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
}