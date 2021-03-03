package recursion_Q1;

public class Recursion {
	
	/**
	 * LCM recursion function
	 * @param num1
	 * 			first number for lcm
	 * @param num2
	 * 			second number for lcm
	 * @param temp
	 * 			temporary number which can be LCM
	 * @return integer
	 * 			LCM of first and second number
	 */
	private static int lcm(int num1, int num2, int temp){
		if(num1==num2){
			return num1;
		}else if(num1==1 || num2==1){
			return num1*num2;
		}else{
			if(temp<=num1 && temp<=num2){
				if(num1%temp==0 && num2%temp==0){
					return temp * lcm(num1/temp, num2/temp, 2);
				} else{
					return lcm(num1, num2, temp+1);
				}
			}else{
				return num1*num2;
			}
		}
	}
	
	
	/**
	 * to receive two numbers and return their LCM
	 * @param num1
	 * 			first integer
	 * @param num2
	 * 			second integer
	 * @return integer
	 * 			LCM of given two numbers
	 */
	public static int findLCM(int num1, int num2){
		return lcm(num1, num2, 2);
	}
	
	/**
	 * Recursive function for HCF calculation
	 * @param num1
	 * 			first integer
	 * @param num2
	 * 			second integer
	 * @return integer
	 * 			HCF of given two numbers.
	 */
	private static int hcf(int num1, int num2){
		if(num1==0)
			return num2;
		return hcf(num2%num1, num1);
	}
	
	/**
	 * caller function for recursive HCF function
	 * @param num1
	 * 			first integer 
	 * @param num2
	 * 			second integer
	 * @return integer
	 * 			returns HCF of given two numbers.
	 */
	public static int findHCF(int num1, int num2){
		return hcf(num1, num2);
	}
}
