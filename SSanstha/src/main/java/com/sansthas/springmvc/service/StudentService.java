package com.sansthas.springmvc.service;

import java.util.List;

import com.sansthas.springmvc.model.Student;

public interface StudentService {

	Student findById(int id);
	
	void saveStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudentById(Integer id);

	List<Student> findAllStudents(); 
	
	Student findStudentById(Integer id);

	boolean isStudentCodeUnique(Integer id);
	
}
