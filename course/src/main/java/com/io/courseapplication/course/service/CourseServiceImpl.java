package com.io.courseapplication.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.courseapplication.course.dao.CourseRepository;
import com.io.courseapplication.course.form.CourseForm;
import com.io.courseapplication.course.form.CourseOutputForm;
import com.io.courseapplication.course.model.Course;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository cRepo;
	
	@Override
	public Course createCoureNames(CourseForm course) {
		
		Course c = new Course();
		c.setCoursename(course.getCourseName());
		c.setPrice(course.getPrice());
		System.out.println("courses"+c);
		return cRepo.save(c);

		
		
	}

	@Override
	public List<CourseOutputForm> findByPrice(int price) {
		List<Course> course = cRepo.getCourse(price);
	    List<CourseOutputForm> courseOutputForms = new ArrayList<>();

		for(Course c : course) {
			CourseOutputForm co = new CourseOutputForm();
			co.setCourseid(c.getCourseid());
			co.setCoursename(c.getCoursename());
			co.setPrice(c.getPrice());
			courseOutputForms.add(co);
		}
		return courseOutputForms;
		
	}

	@Override
	public List<CourseOutputForm> getAllcourses() {
		List<Course> course = cRepo.findAll();
	    List<CourseOutputForm> courseOutputForms = new ArrayList<>();

		for(Course c : course) {
			CourseOutputForm co = new CourseOutputForm();
			co.setCourseid(c.getCourseid());
			co.setCoursename(c.getCoursename());
			co.setPrice(c.getPrice());
			courseOutputForms.add(co);
		}
		return courseOutputForms;
	}

}
