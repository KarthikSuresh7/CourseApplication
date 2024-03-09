package com.io.courseapplication.course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.io.courseapplication.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query("from Course c where c.price=:price")
	List<Course> getCourse(int price);
}
