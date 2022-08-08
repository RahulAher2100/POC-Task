package com.neosoft.poc.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {
	
	private final String jwt;
	
	
   
	
	

}
