package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Por","make"));
		theStudents.add(new Student("jake","wakl"));
		theStudents.add(new Student("kim","meme"));
		theStudents.add(new Student("kwan","luu"));
		
	}
	
	// define endpoint for"/student" -return list student
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		
		
		return theStudents;
	}
	
	//define endpoint for"/student/{studentId}" - return student at index
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// just index the list 
		
		// check the student again list size
		
		if( studentId >= theStudents.size() || studentId <0 ) {
			throw new StudentNotFoundException("Student id not found -" + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
}
