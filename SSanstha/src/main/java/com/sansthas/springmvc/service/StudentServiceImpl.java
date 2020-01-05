package com.sansthas.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansthas.springmvc.dao.StudentDao;
import com.sansthas.springmvc.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;
	
	public Student findById(int id) {
		return dao.findById(id);
	}

	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}
	
	public void updateStudent(Student student) {
		Student entity = dao.findById(student.getId());
		if(entity!=null){
			entity.setName(student.getName());
		//set fields here in case of update operations ... need to decide this in future...
			
			
			
			//dao.saveOrUpdate(student);
		}
	}

	public void deleteStudentById(Integer id) {
		dao.deleteStudentById(id);
	}
	
	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}

	public Student findStudentById(Integer id) {
		return dao.findStudentById(id);
	}

	public boolean isStudentCodeUnique(Integer id) {
		Student student = findStudentById(id);
		return ( student == null || ((id != null) && (student.getId() == id)));
	}

	
}
