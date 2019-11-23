package com.project.service;
import java.util.List;

import com.project.model.Student;
public interface StudentService {
	public void save(Student s);
	public List<Student> listStudents();
	public void delete(Student s);
	public void update(Student s);
}
