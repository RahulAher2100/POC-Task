package com.neosoft.poc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.poc.entity.Student;
import com.neosoft.poc.repository.StudentRepository;
import com.neosoft.poc.service.StudentService;




@Service
public class StudentServiceIMPL implements StudentService 
{
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public Student insertData( Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return studentrepository.getByStudentId(studentId);
	}

	
	

}
