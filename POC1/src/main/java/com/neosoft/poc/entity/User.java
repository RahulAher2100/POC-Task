package com.neosoft.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@NotEmpty
	@Size(min = 4, message = "First Name must contain atleast 4 characters")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@Size(min = 4, message = "Last Name must contain atleast 4 characters")
	@Column(name = "last_name")
	private String lastName;

	@Email(message = "Email address is not valid")
	@Column(name = "email_id")
	private String email;

	@NotEmpty
	@Size(min = 5, message = "UserName must contain atleast 5 characters")
	@Column(name = "user_name")
	private String userName;

	@NotEmpty
	@Column(name = "password")
	// @Pattern(regexp = "^[a-zA-Z0-9{8}]")
	@Size(min = 5, message = "Password must contain atleast 5 characters")
	private String password;

	@NotEmpty
	@Size(min = 6, max = 6, message = "Pin Code must contain 6 digits")
	@Column(name = "pin_code")
	private String pincode;

	@NotNull(message = "Must Enter Birth Date")
	@Column(name = "birth_date")
	private String birthDate;

	@NotNull(message = "Must Enter Joining Date")
	@Column(name = "join_Date")
	private String joinDate;

	private boolean isActive = true;

}
