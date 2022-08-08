package com.neosoft.poc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

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
public class Project {
	
	@Id
	@Column(name="project_id")
	private int projId;
	
	@NotEmpty
	@Column(name="project_name")
	private String projName;
	
	@NotEmpty
	@Column(name="project_duration")
	private String projDuration;
	

	
}
