package com.neosoft.microservice.entity;

public class Contact {
	
	private int cid;
	private String email;
	private String contactPerson;
	private int userId;
	
	
	public Contact() {
		
		
	}
	
	
	public Contact(int cid, String email, String contactPerson, int userId) {
		super();
		this.cid = cid;
		this.email = email;
		this.contactPerson = contactPerson;
		this.userId = userId;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
