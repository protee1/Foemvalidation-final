package com.project.dao;

import java.util.List;

import com.project.model.Student;
public interface StudentDao {
	public void save(Student s);
	public List<Student> listStudent();
	public void delete(Student s);
	public void update(Student s);
}
