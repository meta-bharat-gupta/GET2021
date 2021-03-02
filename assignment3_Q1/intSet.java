package assignment3_Q1;

import static java.lang.System.out;

final public class intSet {
	private final int[] set = new int[1000];
	private final int length;
	
	
	/**
	 * Constructor to initialize intSet object.
	 * @param setValues
	 * 			1D array of the values to be put in the set.
	 */
	public intSet(int[] setValues){
		int len=0;
		for(int i=0; i<setValues.length; i++){
			if(isMember(setValues[i])){
				continue;
			}else{
				this.set[len] = setValues[i];
				len++;
			}
		}
		this.length = len;
	}
	
	
	/**
	 * To check whether given integer is a member of the set or not.
	 * @param num
	 * 			integer to find whether it is member of the set or not.
	 * @return boolean
	 * 	
	 */
	public boolean isMember(int num){
		for(int each: set){
			if(num==each)
				return true;
		}
		return false;
	}
	
	
	/**
	 * To return size of the Set.
	 * @return integer
	 */
	public int size(){
		return this.length;
	}
	
	
	/**
	 * To check whether the given intSet object is subset of the object or not.
	 * @param anotherSet
	 * 			a intSet object.
	 * @return boolean
	 */
	public boolean isSubSet(intSet anotherSet){
		if(anotherSet.length==0){
			return true;
		}
		for(int i=0; i<anotherSet.length; i++){
			if(!isMember(anotherSet.set[i]))
				return false;
		}
		return true;
	}
	
	
	/**
	 * To compute the complement of the set.
	 * @return 
	 * 		intSet object of complement set.
	 */
	public intSet getComplement(){
		int[] array = new int[1000];
		int size = 0;
		for(int i=1;i<=1000;i++){
			if(!isMember(i)){
				array[size]=i;
				size++;
			}
		}
		return new intSet(array);
	}
	
	
	/**
	 * To display the set object.
	 */
	public void print(){
		if(this.length==0){
			out.println("Empty Set");
		}else{
			for(int i=0; i<this.length; i++){
				System.out.print(set[i]+ " ");
			}
			out.println();
		}
	}
	
	
	/**
	 * To find union of two sets.
	 * @param setOne
	 * 			first intSet object.
	 * @param setTwo
	 * 			second intSet object.
	 * @return
	 * 			intSet object with union of given two sets.
	 */
	public static intSet union(intSet setOne, intSet setTwo){
		int[] array = new int[setOne.size() + setTwo.size()];
		for(int i=0; i<setOne.size(); i++){
			array[i] = setOne.set[i];
		}
		int index = setOne.size();
		for(int i=0; i<setTwo.size(); i++){
			if(!setOne.isMember(setTwo.set[i])){
				array[index] = setTwo.set[i];
				index++;
			}
		}
		return new intSet(array);
	}
	
}
