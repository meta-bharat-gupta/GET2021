package recursion_Q2;

public class Search {
	
	private static int linear(int[] array, int num, int index){
		if(index>=array.length){
			return -1;
		}
		if(array[index]==num){
			return index;
		}
		return linear(array, num, index+1);
	}
	public static int linearSearch(int[] array, int num){
		int index = linear(array, num, 0);
		return index;
	}
	
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
		
	public static int binarySearch(int[] array, int num){
		int index = binary(array, num, 0, array.length-1);
		return index;
		}
}

