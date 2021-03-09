package assignment2_Q3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Counseling {
	Queue<Student> studentQueue;
	ArrayList<Course> courseList;
	String filePath;
	
	/**
	 * Constructor for Counseling Class
	 * @param filepath
	 * 			Requires File Path for the Student List and Courses.
	 */
	public Counseling(String filepath) {
		this.filePath = filepath;
		this.courseList = getListOfCourses();
	}

	
	/**
	 * This function reads the data from the excel file and add the data into the 
	 * class attributes i.e. studentQueue and courseList
	 */
	public void readStudentData() {
		try {
			File file = new File(this.filePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Student List");

			// getting total Rows in the file
			int totalRows = sheet.getPhysicalNumberOfRows();

			// initializing the student queue
			this.studentQueue = new StudentQueue(totalRows - 1);

			for (int row = 1; row < totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);
				int cellNum = currentRow.getPhysicalNumberOfCells();

				String studentName = currentRow.getCell(0).getStringCellValue();
				ArrayList<String> coursePreference = new ArrayList<String>();

				// Entering the course options into the coursePreference list.
				for (int cell = 1; cell < cellNum; cell++) {
					XSSFCell currentCell = currentRow.getCell(cell);
					coursePreference.add(currentCell.getStringCellValue());
				}

				// adding the student into the queue
				this.studentQueue.addStudent(new Student(studentName, coursePreference));
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * This function reads the Course and their capacities and adds to the CourseList
	 * @return ArrayList
	 * 		ArrayList object of courses.
	 */
	public ArrayList<Course> getListOfCourses() {
		ArrayList<Course> listOfCourses = new ArrayList<Course>();
		try {
			File file = new File(this.filePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Course List");

			// fetching total rows in the file
			int totalRows = sheet.getPhysicalNumberOfRows();

			for (int row = 1; row < totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);
				String courseName = currentRow.getCell(0).getStringCellValue();
				int courseCapacity = (int) currentRow.getCell(1).getNumericCellValue();
				
				// adding the course into the list of courses
				listOfCourses.add(new Course(courseName, courseCapacity));
				
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listOfCourses;
	}
	
	
	/**
	 * This function allocates the courses to the Students
	 * @return boolean
	 * 			true if the writing of the excel file is successful otherwise false
	 */
	public boolean allocateCourse() {
		List<Student> listOfStudents = new ArrayList<Student>();
		while (!studentQueue.isEmpty()) {
			Student currentStudent = studentQueue.deleteStudent();

			boolean flag = true;
			for (int index = 0; index < currentStudent.courseOptionList.size(); index++) {
				// checking the capacity of the current preferred program of student
				if(flag){
					for (int course = 0; course<courseList.size(); course++) {
						Course currentCourse = courseList.get(course);
						if (currentStudent.courseOptionList.get(index).equals(currentCourse.getCourseName())) {
							if (currentCourse.hasCapacity()) {
								currentStudent.setCourse(currentCourse.courseName);
								currentCourse.decreaseCourseCapacity();
//								System.out.println("Program Allocated for index : "+ index);
								flag = false;
							}
						}
					}					
				}
			}
			listOfStudents.add(currentStudent);
		}

		return writeDataFile(listOfStudents);
	}
	
	/**
	 * This function writes the Student data to the excel file.
	 * @param listOfStudents
	 * 			List of the Students with allocated courses
	 * @return
	 */
	public boolean writeDataFile(List<Student> listOfStudents) {
		boolean flag=false;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();

			// fetching the total number of student record
			int totalRows = listOfStudents.size();

			// Initializing first row with the title of the column
			XSSFRow firstRow = sheet.createRow(0);
			firstRow.createCell(0).setCellValue("Student Name");
			firstRow.createCell(1).setCellValue("Course Allocated");

			// inserting each student and its allocated course
			for (int row = 0; row < totalRows; row++) {
				Student currentStudent = listOfStudents.get(row);
				XSSFRow currentRow = sheet.createRow(row + 1);
				currentRow.createCell(0).setCellValue(currentStudent.getName());
				currentRow.createCell(1).setCellValue(currentStudent.getCourse());
			}

			// writing the workbook
			String path = "C:\\Users\\bharat.gupta_metacub\\workspace\\DSAassginments\\src\\assignment2_Q3\\Allocation.xlsx";
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			workbook.close();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
