package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionfactory;

	public void save(Student s) {
		Session ss=sessionfactory.getCurrentSession();
		ss.save(s);
	}

	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
		Session ss=sessionfactory.getCurrentSession();
		return ss.createCriteria(Student.class).list();
	}

	public void delete(Student s) {
		Session ss=sessionfactory.getCurrentSession();
		ss.delete(s);
	}

	public void update(Student s) {
		Session ss=sessionfactory.getCurrentSession();
		ss.update(s);
	}
	
	
}