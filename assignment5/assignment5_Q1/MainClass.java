package assignment5_Q1;

import org.json.JSONObject;

public class MainClass {

	// Main function to use dictionary and its methods
	public static void main(String[] args) {
		Dictionary dict;
		try{
			JSONObject jo = new JSONObject("{data:[{key:3, value:Three},"
					+ "{key:1,value:One},"
					+ "{key:2,value:Two},"
					+ "{key:5, value:Five},"
					+ "{key:4, value:Four}]}");	

			dict = new Dictionary(jo);
			System.out.println(dict.get(2));
			
			System.out.println("Sorted Value: ");
			dict.sort();
			dict.remove(2);
			System.out.println("Sorted after removing 2:");
			dict.sort();
			System.out.println("Sorted in range 2 - 4:");
			dict.sortInRange(2, 4);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
