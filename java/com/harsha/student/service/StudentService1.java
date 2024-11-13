package com.harsha.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsha.student.model.Student;
import com.harsha.student.repo.StudentRepo;


@Service
public class StudentService1 implements StudentService{
	@Autowired
	 StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student insertStudent(Student std) {
		// TODO Auto-generated method stub
		return studentRepo.save(std);
	}

	@Override
	public void updateStudent(Student std,int id) {
		Student st = studentRepo.findById(id).get();
		st.setName(std.getName());
		st.setEmail(std.getEmail());
		st.setPassword(std.getPassword());
		studentRepo.save(st);
	}
	
	
	public Student findById(int id)
	{
		return studentRepo.findById(id).get();	
	}
	@Override
	public void deleteStudent(int id) {
		
		Student std = studentRepo.findById(id).get();
		
		studentRepo.delete(std);
		
	}

	
	
}
