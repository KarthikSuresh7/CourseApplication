package com.io.courseapplication.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.io.courseapplication.course.form.CourseForm;
import com.io.courseapplication.course.form.CourseOutputForm;
import com.io.courseapplication.course.model.Course;

@Service
public interface CourseService {

	Course createCoureNames(CourseForm course);

	List<CourseOutputForm> findByPrice(int price);

	
	List<CourseOutputForm> getAllcourses();
	//Course findByPrice(int price);
}
