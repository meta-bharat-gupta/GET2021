package assignment3_Q1;

import static java.lang.System.out;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,5};
		intSet setOne = new intSet(arr);
		setOne.print();
		out.println("Size of Set One = " + setOne.size());
		int[] arr1 = {1,2,3,4,6};
		intSet setTwo = new intSet(arr1);
		out.println("second set is subset of first: " +setOne.isSubSet(setTwo));
		
		out.println("Complement of First set -");
		setOne.getComplement().print();
		
		intSet unionSet = intSet.union(setOne, setTwo);
		out.println("union of first and second set");
		unionSet.print();
		out.println("size of union set: " +unionSet.size());
		
		out.println("Is 5 is the member of set one: "+ setOne.isMember(5));
	}
}
