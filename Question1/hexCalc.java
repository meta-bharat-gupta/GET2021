package Question1;

public class hexCalc {
	private static int base = 16;
	private String hexString;
	
	
	public hexCalc(String hexString){
		this.hexString = hexString;
	}
	
	public int toDecimal(){
		return Integer.parseInt(hexString, base);
	}
	
	public String add(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt+secondInt);
	}
	
	public String subtract(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt-secondInt);
	}
	
	public String multiply(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt*secondInt);
	}
	
	public String divide(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt/secondInt);
	}
	
	
	public static boolean isEqual(hexCalc firstNumber, hexCalc secondNumber){
		if(firstNumber.hexString.compareTo(secondNumber.hexString)==0){
			return true;
		}
		return false;
	}
	
	public static boolean isGreaterThan(hexCalc firstNumber, hexCalc secondNumber){
		if(firstNumber.hexString.compareTo(secondNumber.hexString)>0){
			return true;
		}
		return false;
	}
	
	public static boolean isLessThan(hexCalc firstNumber, hexCalc secondNumber){
		if(firstNumber.hexString.compareTo(secondNumber.hexString)<0){
			return true;
		}
		return false;
	}

}
