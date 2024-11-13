package com.harsha.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsha.student.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	
}
