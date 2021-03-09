package assignment4_Q2;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
	private static Map<String, Integer> stringVault = new HashMap<String, Integer>();
	
	public static int countUniqueChar(String str){
		int count = 0;
		if(stringVault.containsKey(str)){
			System.out.println("From String Vault (Cached Result): ");
			count = stringVault.get(str);
		}else{
			boolean[] isItHere = new boolean[Character.MAX_VALUE];
			for(int index=0; index<str.length(); index++){
				isItHere[str.charAt(index)]=true;
			}
			for(int index =0; index<isItHere.length; index++){
				if(isItHere[index])
					count++;
			}
			stringVault.put(str, count);
		}
		return count;		
	}
}
