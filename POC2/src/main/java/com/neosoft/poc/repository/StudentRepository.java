package com.neosoft.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

	Student getByStudentId(int studentId);	

}
