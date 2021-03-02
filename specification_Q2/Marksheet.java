package specification_Q2;

public class Marksheet {
	
	/**
	 * Calculate the average of the grades.
	 * @param grades
	 * 			1D array with grades ranges from 0-100 and length of the array should be positive integer
	 * @return
	 * 			float value of Average of all grades.
	 */
	public static float calculateAvg(int[] grades){
		int sum = 0;
		for(int grade=0; grade<grades.length; grade++){
			sum += grades[grade];
		}
		float avg = Float.valueOf(String.format("%.02f", (float)sum/grades.length));
		return avg;
	}
	
	
	/**
	 * To find Maximum Grade from all student's grades.
	 * @param grades
	 * 			1D array with grades ranges from 0-100 and length of the array should be positive integer
	 * @return
	 * 			integer of maximum grade present in the array.
	 */
	public static int maxGrade(int[] grades){
		int curGrade = grades[0];
		for(int grade=1; grade<grades.length; grade++){
			if(grades[grade]>curGrade){
				curGrade = grades[grade];
			}
		}
		return curGrade;
	}
	
	/**
	 * To find Minimum Grade from all student's grades.
	 * @param grades
	 * 			1D array with grades ranges from 0-100 and length of the array should be positive integer
	 * @return
	 * 			integer of minimum grade present in the array.
	 */
	public static int minGrade(int[] grades){
		int curGrade = grades[0];
		for(int grade=1; grade<grades.length; grade++){
			if(grades[grade]<curGrade){
				curGrade = grades[grade];
			}
		}
		return curGrade;
	}
	
	
	/**
	 * To calculate the percentage of students passed.
	 * @param grades
	 * 			1D array with grades ranges from 0-100 and length of the array should be positive integer
	 * @return
	 * 			float value of the percentage of passed students.
	 */
	public static float passPercentage(int[] grades){
		int passedStudent = 0;
		for(int grade : grades){
			if(grade>=40)
				passedStudent++;
		}
		float percentage = Float.valueOf(String.format("%.02f", (passedStudent/(float)grades.length)*100));
		
		return percentage;
	}
}
