package recursion_Q1;

public class Recursion {
	
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
	
	public static int findLCM(int num1, int num2){
		int result = lcm(num1, num2, 2);
		return result;
	}
	
	private static int hcf(int num1, int num2){
		if(num1==0)
			return num2;
		return hcf(num2%num1, num1);
	}
	
	public static int findHCF(int num1, int num2){
		int result = hcf(num1, num2);
		return result;
	}
}
