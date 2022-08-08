package com.neosoft.poc.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	
	@NotEmpty
	@Size(min=4, message = "First Name must contain atleast 4 characters")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
	@Size(min=4, message = "last Name must contain atleast 4 characters")
	@Column(name="last_name")
	private String lastName;
	
	@NotEmpty
	@Size(min=10,max=10, message = "Mobile Number must contain 10 digits")
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@NotEmpty
	@Email
	@Column(name="email_id")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_stud", referencedColumnName = "student_id")
	private List<Project>project=new ArrayList<>() ;

	
}
