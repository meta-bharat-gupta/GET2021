package assignment2_Q3;

public class MainClass {
	
	public static void main(String[] args) {
		//File Path for the Student and Courses List
		String filePath = "C:\\Users\\bharat.gupta_metacub\\workspace\\DSAassginments\\src\\assignment2_Q3\\CollegeData.xlsx";
		
		// object of counseling class
		Counseling collegeCounseling = new Counseling(filePath);
		collegeCounseling.readStudentData();
		if(collegeCounseling.allocateCourse()){
			System.out.println("Courses Allocated.");
		}else{
			System.out.println("Something Wrong Happened.");
		}
	}
}