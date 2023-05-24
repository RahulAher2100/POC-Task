package com.neosoft.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
	
	@Id
	private int cid;
	private String email;
	private String contactName;
	
	private int userId;

	public Contact(int cid, String email, String contactName) {
		super();
		this.cid = cid;
		this.email = email;
		this.contactName = contactName;
	}
	
	
	

}
