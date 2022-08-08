package com.neosoft.poc.service;

import java.util.List;

import javax.validation.Valid;

import com.neosoft.poc.entity.Student;




public interface StudentService {

	Student insertData(Student student);

	List<Student> getAllStudent();

	Student getStudentById(int studentId);
	
	
	

	

}
