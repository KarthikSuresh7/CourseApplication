package com.io.courseapplication.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.io.courseapplication.course.dao.CourseRepository;
import com.io.courseapplication.course.form.CourseForm;
import com.io.courseapplication.course.form.CourseOutputForm;
import com.io.courseapplication.course.model.Course;
import com.io.courseapplication.course.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

	@Autowired
	CourseRepository cRepo;
	
	@Autowired
	CourseService cService;
	
	@GetMapping
	public String dashBoard() {
		return "Good Morning";
	}
	
	
	@PostMapping("/createCourses")
	private Course createCourse(@RequestBody CourseForm course){
		return cService.createCoureNames(course);
	}
	
	@GetMapping("/findAll")
	private List<Course> getcourses(){
		return cRepo.findAll();
	}
	
	@GetMapping("/findById")
	private List<CourseOutputForm> getcoursesyId(@RequestParam(required = false) int price){
		return cService.findByPrice(price);
	}
	
}
