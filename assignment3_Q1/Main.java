package assignment3_Q1;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,5};
		intSet setOne = new intSet(arr);
		setOne.print();
		System.out.println("Size of Set One = " + setOne.size());
		int[] arr1 = {1,2,3,4,6};
		intSet setTwo = new intSet(arr1);
		System.out.println("second set is subset of first: " +setOne.isSubSet(setTwo));
		
		System.out.println("Complement of First set -");
		setOne.getComplement().print();
		
		intSet unionSet = intSet.union(setOne, setTwo);
		System.out.println("union of first and second set");
		unionSet.print();
		System.out.println("size of union set: " +unionSet.size());
	}
}
