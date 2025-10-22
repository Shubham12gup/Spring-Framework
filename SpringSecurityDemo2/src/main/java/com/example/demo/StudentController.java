package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    private final SpringSecurityDemo2Application springSecurityDemo2Application;

    private final HomeController homeController;

	List<Student> students  = new ArrayList<>(List.of(
			new Student(1, "Shubham", 10),
			new Student(2, "Om", 20),
			new Student(3, "Ram", 30)
			));

    StudentController(HomeController homeController, SpringSecurityDemo2Application springSecurityDemo2Application) {
        this.homeController = homeController;
        this.springSecurityDemo2Application = springSecurityDemo2Application;
    }
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		
		
		
		return students;
	}
	
	
	@PostMapping("/students")
	public Student addStudents(@RequestBody Student student) {
		
		students.add(student);
		System.out.println("Added");
		return student;
		
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		
		System.out.println("CSRF");
		
		
		CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
		System.out.println(csrfToken.getToken());
		return csrfToken;
	}
}
