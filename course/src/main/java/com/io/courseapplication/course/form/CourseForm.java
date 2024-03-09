package com.io.courseapplication.course.form;

import java.io.Serializable;




public class CourseForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4470918985512091981L;

	private int courseid;
	
	private String courseName;
	
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
}
