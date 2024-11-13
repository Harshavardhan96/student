package com.harsha.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.harsha.student.model.Student;
import com.harsha.student.service.StudentService1;

//@RestController
@Controller
public class StudentController {
	
	@Autowired
	private StudentService1 stuserv;
	
//	@GetMapping("/students")
//	public List<Student> getAllStudents() {
//		// TODO Auto-generated method stub
//		return studentService.getAllStudents();
//		} 
//	@PostMapping("/student")
//	public Student insertStudent(Student std) {
//		// TODO Auto-generated method stub
//		return studentService.insertStudent(std);
//	}
//	
//	@PutMapping("/addstudent")
//	public Student updateStudent(Student std) {
//		// TODO Auto-generated method stub
//		return studentService.updateStudent(std);
//	}
//
//	@DeleteMapping("/deletestudent")
//public void deleteStudent(int id) {
//		
//	studentService.deleteStudent(id);
//	}
	
	@GetMapping("/register")
   public String getregister() {
	   return "index";
   }
	
	@PostMapping("/save")
	public String Savestudent(@ModelAttribute Student s) {
		stuserv.insertStudent(s);
		
		return "redirect:/getAll";
	}
	
//	@PutMapping("/Put")
//	public String Putstudent(@ModelAttribute Student s) {
//		stuserv.updateStudent(s);
//		return "index";
//	}
	
	@GetMapping("/get/{id}")
	public String getById(@PathVariable int id,Model model) {
		model.addAttribute("harsha", stuserv.findById(id));
		return "update";
	}
	
	@GetMapping("/getAll")
	public String getAllStudents(Model model) {
		
		model.addAttribute("hello",stuserv.getAllStudents());
        return "getAllStudents";
	}
	
	@PostMapping("/update/{id}")
	public String updateStudentById(@PathVariable int id,@ModelAttribute Student student) {
		stuserv.updateStudent(student, id);
		return "redirect:/getAll";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteById(@PathVariable int id) {
		stuserv.deleteStudent(id);
		return "redirect:/getAll";
	}
	
}
