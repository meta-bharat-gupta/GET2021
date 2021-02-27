package Question1;

public class hexCalc {
	private static int base = 16;
	private String hexString;
	
	/**
	 * Constructor
	 * @param hexString
	 */
	public hexCalc(String hexString){
		this.hexString = hexString;
	}
	
	/**
	 * Function to convert hexadecimal string to decimal equivalent.
	 * @return integer - decimal equivalent of hex String.
	 */
	public int toDecimal(){
		return Integer.parseInt(hexString, base);
	}
	
	/**
	 * Function adds two hexadecimal numbers.
	 * @param hexNumber - hexCalc object
	 * @return string - hexadecimal string
	 */
	public String add(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt+secondInt);
	}
	
	/**
	 * Function to subtract two hexadecimal numbers.
	 * @param hexNumber - hexCalc Object
	 * @return string - hexadecimal string
	 */
	public String subtract(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt-secondInt);
	}
	
	/**
	 * Function to multiply two hexadecimal numbers.
	 * @param hexNumber - hexCalc object
	 * @return string - hexadecimal string
	 */
	public String multiply(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		return Integer.toHexString(firstInt*secondInt);
	}
	
	/**
	 * Function to divide two hexadecimal Strings.
	 * @param hexNumber
	 * @return
	 */
	public String divide(hexCalc hexNumber){
		int firstInt = Integer.parseInt(hexString, base);
		int secondInt = Integer.parseInt(hexNumber.hexString, base);
		if(secondInt==0){
			return "Oops! Divisor is Zero, can't perform division operation.";
		}
		return Integer.toHexString(firstInt/secondInt);
	}
	
	/**
	 * Function to check if two hexCalc object are equal or not.
	 * @param firstNumber hexCalc object
	 * @param secondNumber hexCalc object
	 * @return boolean
	 */
	public static boolean isEqual(hexCalc firstNumber, hexCalc secondNumber){
		if(firstNumber.hexString.compareTo(secondNumber.hexString)==0){
			return true;
		}
		return false;
	}
	
	/**
	 * Function to check whether a hexCalc object is greater than another or not.
	 * @param firstNumber hexCalc object
	 * @param secondNumber hexCalc object
	 * @return boolean
	 */
	public static boolean isGreaterThan(hexCalc firstNumber, hexCalc secondNumber){
		if(firstNumber.hexString.compareTo(secondNumber.hexString)>0){
			return true;
		}
		return false;
	}
	
	/**
	 * Function to check whether a hexCalc object is less than another or not.
	 * @param firstNumber hexCalc object
	 * @param secondNumber hexCalc object
	 * @return boolean
	 */
	public static boolean isLessThan(hexCalc firstNumber, hexCalc secondNumber){
		if(firstNumber.hexString.compareTo(secondNumber.hexString)<0){
			return true;
		}
		return false;
	}

}
