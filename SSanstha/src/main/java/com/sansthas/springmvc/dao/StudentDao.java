package com.sansthas.springmvc.dao;

import java.util.List;

import com.sansthas.springmvc.model.Student;

public interface StudentDao {

	Student findById(int id);

	void saveStudent(Student student);
	
	public void saveOrUpdate(Student student);
	
	void deleteStudentById(Integer id);
	
	List<Student> findAllStudents();

	Student findStudentById(Integer id);

}
