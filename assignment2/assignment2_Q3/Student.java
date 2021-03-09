package assignment2_Q3;

import java.util.ArrayList;

public class Student {
	String name;
	ArrayList<String> courseOptionList = new ArrayList<String>();
	String course;
	
	public Student(String name, ArrayList<String> courseList){
		this.name = name;
		this.courseOptionList = courseList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getCourseOptionList() {
		return courseOptionList;
	}
	public void setCourseOptionList(ArrayList<String> courseOptionList) {
		this.courseOptionList = courseOptionList;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
}
