package com.project.viewmodel;

import java.util.List;


import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

import com.project.model.Student;
import com.project.service.StudentService;


@VariableResolver(DelegatingVariableResolver.class)
public class StudentViewModel{

	@WireVariable("service")
	StudentService services;	
	
	private Student students;
	private List<Student> lsStudents;

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	public List<Student> getLsStudents() {
		return lsStudents;
	}

	public void setLsStudents(List<Student> lsStudents) {
		this.lsStudents = lsStudents;
	}
	
	@Init
	public void initialisation() {
		students=new Student();
		lsStudents = new ListModelList<Student>(services.listStudents());
	}
	
	@Command
	@NotifyChange({"lsStudents","students"})
	public void saveButton(@BindingParam("a") Student z) {

		services.save(getStudents());
		initialisation();
			Clients.showNotification("Save successful");
	}
	
	@Command
	@NotifyChange({"lsStudents","students"})
	public void list() {
		lsStudents=services.listStudents();	
	}
	
	@Command
	@NotifyChange({"lsStudents","students"})
	public void deletion(@BindingParam("items") Student item) {
		services.delete(item);	
		//lsStudents.remove(item);
		initialisation();
	}
	
	@Command
	@NotifyChange({"lsStudents","students"})
	public void updating(@BindingParam("item") Student s) {
		services.update(s);
		initialisation();
	}
	
	
}