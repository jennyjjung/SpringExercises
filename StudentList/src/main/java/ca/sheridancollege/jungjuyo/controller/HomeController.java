package ca.sheridancollege.jungjuyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.jungjuyo.beans.Student;
import ca.sheridancollege.jungjuyo.repositories.StudentStorage;

@Controller
public class HomeController {
	
	String correctUserName = "jungjuyo"; 
	String correctPassword = "1234";
	
	
	@GetMapping("/")
	public String goLogin() {
		return "index.html";
	}
	
	@GetMapping("/index")
	public String goLogin(@RequestParam String name, 
						  @RequestParam String pwd) {
		
		if (correctUserName.equals(name) && correctPassword.equals(pwd)) {
			return "valid.html";
		} else {
			return "invalid.html";
		}
	}
	
	@GetMapping("/addStudent")
	public String addStudent() {
		return "valid.html";
	}
	
	@GetMapping("/info")
	public String goInfo(
			@RequestParam String name, 
			@RequestParam String studentId,
			@RequestParam String course1,
			@RequestParam String course2,
			@RequestParam String course3,
			@RequestParam String course4,
			@RequestParam(required=false, defaultValue="false") boolean regiCoop,
			@RequestParam(required=false, defaultValue="false") boolean fullTime,
			@RequestParam(required=false, defaultValue="false") boolean paidTuition
			) {
		
		
		Student student = new Student(name, studentId, course1, course2, 
				course3, course4, regiCoop, fullTime, paidTuition);
		
		StudentStorage.students.add(student);
		
		System.out.println("Student name is " + name);
		System.out.println("Student id is " + studentId);
		System.out.println("Course 1 is " + course1);
		System.out.println("Course 2 is " + course2);
		System.out.println("Course 3 is " + course3);
		System.out.println("Course 4 is " + course4);
		System.out.println("Registered Co-op? " + ((regiCoop)?"yes":"no"));
		System.out.println("Full time student? " + ((fullTime)?"yes":"no"));
		System.out.println("Paid tuition? " + ((paidTuition)?"yes":"no"));

		return "valid.html";
		
	}
	
	
	@GetMapping("/record")
	public String goRecord(Model model) {
		
		model.addAttribute("students", StudentStorage.students);
	
		return "studentInfo.html";	
	}

}
