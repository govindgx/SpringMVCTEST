package com.sansthas.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sansthas.springmvc.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {

	public Student findById(int id) {
		return getByKey(id);
	}

	public void saveStudent(Student student) {
		persist(student);
	}
	
	public void saveOrUpdate(Student student){
		super.saveOrUpdate(student);
	}
	
	public void deleteStudentById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Student where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		Criteria criteria = createEntityCriteria();
		return (List<Student>) criteria.list();
	}

	public Student findStudentById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Student) criteria.uniqueResult();
	}


}
