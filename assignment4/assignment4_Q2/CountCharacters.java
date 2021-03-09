package assignment4_Q2;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
	private static Map<String, Integer> stringVault = new HashMap<String, Integer>();
	
	/**
	 * Count Unique Characters in given String
	 * @param str
	 * 			String given by user.
	 * @return integer
	 * 			unique number of characters present in the string.
	 * 
	 */
	public static int countUniqueChar(String str){
		int count = 0;
		// Checks whether String is already occurred and stored in the String Vault or not
		if(stringVault.containsKey(str)){
			System.out.println("From String Vault (Cached Result): ");
			count = stringVault.get(str);
		}else{
			//boolean array for the character occurrence.
			boolean[] isItHere = new boolean[Character.MAX_VALUE];
			for(int index=0; index<str.length(); index++){
				isItHere[str.charAt(index)]=true;
			}
			// checking how many characters occurred in the string.
			for(int index =0; index<isItHere.length; index++){
				if(isItHere[index])
					count++;
			}
			stringVault.put(str, count);
		}
		return count;		
	}
}
