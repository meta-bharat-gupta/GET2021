package specification_Q1;

public class StringOperations {
	
	/**
	 * To compare two strings
	 * @param strOne
	 * 			String and cannot be null
	 * @param strTwo
	 * 			String and cannot be null
	 * @return
	 * 			1 if both strings are equal
	 * 			0 if both strings are not equal
	 */
	public static int compare(String strOne, String strTwo){
		char[] strOneArray = strOne.toCharArray();
		char[] strTwoArray = strTwo.toCharArray();
		int strOneLength=0;
		int strTwoLength=0;
		for(char character:strOneArray){
			strOneLength++;
		}
		for(char character:strTwoArray){
			strTwoLength++;
		}
		if(strOneLength!=strTwoLength){
			return 0;
		}else{
			for(int chr=0; chr<strOneLength; chr++){
				if(strOneArray[chr]!=strTwoArray[chr]){
					return 0;
				}
			}
			return 1;
		}
	}
	
	/**
	 * To reverse a String
	 * @param str
	 * 			String which cannot be null
	 * @return
	 * 			reversed string of given string in parameter as str
	 */			
	public static String reverse(String str){
		char[] strArray = str.toCharArray();
		String reversedString="";
		for(char c:strArray){
			reversedString = c + reversedString;
		}
		return reversedString;
	}
	
	/**
	 * To change cases of the letters in the string
	 * @param str
	 * 			not null string
	 * @return
	 * 			String which has opposite case letters
	 */
	public static String changeCase(String str){
		char[] strArray = str.toCharArray();
		String caseChangedString="";

		for(char character:strArray){
			if(character>='A' && character<='Z'){
				caseChangedString += (char)((int)character+32);
			}else if(character>='a' && character<='z'){
				caseChangedString += (char)((int)character-32);
			}else{
				caseChangedString += character;
			}
		}
		return caseChangedString;	
	}
	
	/**
	 * To find largest word in a string.
	 * @param str
	 * 			String which cannot be null.
	 * @return
	 * 			String of largest word in the given string.
	 */
	public static String largestWord(String str){
		char[] strArray = str.toCharArray();
		int maxLength=0;
		String maxLengthWord="";
		int length=0;
		String word="";
		for(char character: strArray){
			if(character==' '){
				if(length>=maxLength){
					maxLength = length;
					maxLengthWord = word;
				}
				length=0;
				word="";
			}else{
				length++;
				word+=character;
			}
		}
		if(length>=maxLength){
			maxLengthWord = word;
		}
		return maxLengthWord;
	}
}
