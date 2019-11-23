package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.StudentDao;
import com.project.model.Student;

@Service("service")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;

	@Transactional
	public void save(Student s) {
		dao.save(s);
	}
	
	@Transactional
	public List<Student> listStudents() {
		return dao.listStudent();
	}
	
	@Transactional
	public void delete(Student s) {
		dao.delete(s);
	}
	
	@Transactional
	public void update(Student s) {
		dao.update(s);
	}

}
