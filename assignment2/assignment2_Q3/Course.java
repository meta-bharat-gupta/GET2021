package assignment2_Q3;

public class Course {
	String courseName;
	int courseCapacity;
	
	public Course(String name, int capacity){
		this.courseName = name;
		this.courseCapacity = capacity;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCapacity() {
		return courseCapacity;
	}

	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}
	
	public boolean hasCapacity() {
		if (courseCapacity != 0)
			return true;
		else
			return false;
	}
	
	public void decreaseCourseCapacity(){
		this.courseCapacity--;
	}
}
