package com.harsha.student.service;

import java.util.List;

import com.harsha.student.model.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student insertStudent(Student std);
	
//	public Student updateStudent(Student std);
	public void updateStudent(Student std,int id) ;

	void deleteStudent(int id);
	
}
