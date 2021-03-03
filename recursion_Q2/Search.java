package recursion_Q2;

public class Search {
	
	/**
	 * recursive linear search function
	 * @param array
	 * 			1D array for searching element
	 * @param num
	 * 			integer which we have to search in array
	 * @param index
	 * 			index for recursion
	 * @return integer
	 * 			index on which searching element is present
	 */
	private static int linear(int[] array, int num, int index){
		if(index>=array.length){
			return -1;
		}
		if(array[index]==num){
			return index;
		}
		return linear(array, num, index+1);
	}
	
	/**
	 * Linear Search Function to call recursive function
	 * @param array
	 * 			1D array for searching
	 * @param num
	 * 			integer element to be searched
	 * @return integer
	 * 			index of the element
	 */
	public static int linearSearch(int[] array, int num){
		int index = linear(array, num, 0);
		return index;
	}
	
	
	/**
	 * Recursive binary search function
	 * @param array
	 * 			1D sorted array for binary search
	 * @param num
	 * 			integer element which has to be searched
	 * @param low
	 * 			starting index of the array from which we have to search
	 * @param high
	 * 			end index of the array to which we have to search
	 * @return integer
	 * 			index which contains the searching element.
	 */
	private static int binary(int[] array, int num, int low, int high){
		while(low<=high){
			int mid = (low + high)/2;
			if(array[mid]==num){
				return mid;
			}
			if(array[mid]>num){
				return binary(array, num, low, mid-1);
			}
			return binary(array, num, mid+1, high);
		}
		return -1;
	}
	
	
	/**
	 * Binary Search Function to call recursive binary search
	 * @param array
	 * 			1D sorted array for binary search
	 * @param num
	 * 			integer element to be searched.
	 * @return integer
	 * 			index on which searching element is present
	 */
	public static int binarySearch(int[] array, int num){
		int index = binary(array, num, 0, array.length-1);
		return index;
		}
}

