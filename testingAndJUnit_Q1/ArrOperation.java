package testingAndJUnit_Q1;


public class ArrOperation {
	
	/**
	 * Returns the length of the largest mirror section of an array.
	 * @param array
	 * 			1D array of integers
	 * @return integer
	 * 			length of largest mirror section 
	 */
	public static int maxMirror(int[] array) {
        int length = array.length;
     
        if(length==0){
        	throw new AssertionError("Array is Empty");
        }
  
        int max=0, count=0;
        for(int front = 0; front<length; front++){
        	count = 0;
        	for(int back=length-1; back>=0 && (front+count)<length; back--){
        		if(array[front+count]==array[back]){
        			count++;
        		}else{
        			if(count>0){
        				max = count>max?count:max;
        				count = 0;
        			}
        		}
        	}
        	max = count>max?count:max;
        }
        return max;
    }
	
	
	
	/**
	 * Returns the number of clumps available in an array.
	 * @param array
	 * 			1D array of integers.
	 * @return integer
	 * 			number of clumps
	 */
	public static int numberOfClumps(int[] array){
		int length = array.length;
		if(length == 0){
			throw new AssertionError("Array is Empty.");
		}
		
		int clumps = 0;
		boolean flag = false;
		for(int val = 1; val<length; val++){
			if(array[val-1]==array[val] && !flag){
				clumps++;
				flag = true;
			}
			if(array[val-1]==array[val] && flag){
				continue;
			}
			if(array[val-1]!=array[val]){
				flag = false;
			}
		}
		return clumps;
	}
	
	
	/**
	 * Return the array by placing every Y value immediately right to the value X
	 * @param array
	 * 			1D array of integers.
	 * @param X
	 * 			integer value 
	 * @param Y
	 * 			integer value
	 * @return array
	 * 			1D array after replacing Y values immediately right to the X values
	 */
	public static int[] fixXY(int[] array, int X, int Y){
		int length = array.length;
		if(length == 0){
			throw new AssertionError("Array is Empty.");
		}
		
		int noOfX=0, noOfY=0;
		for(int val=0; val<length; val++){
			if(array[val]==X){
				noOfX++;
			}
			if(array[val]==Y){
				noOfY++;
			}
		}
		if(noOfX!=noOfY){
			throw new AssertionError("No of X and Y are not equal.");
		}
		
		boolean adjacentX = false;
		for(int val=1; val<length; val++){
			if(array[val-1]==X && array[val]==X){
				adjacentX = true;
			}
		}
		if(adjacentX){
			throw new AssertionError("Two Adjacent X values found.");
		}
		
		if(array[length-1]==X){
			throw new AssertionError("X value found on the last index of the array.");
		}
		
		int yLastPos = 0;
		for(int index=0; index<length-1; index++){
			if(array[index]==X){
				for(int id=yLastPos; id<length; id++){
					if(array[id]==Y){
						if(id>1 && array[id-1]==X){
							continue;
						}
						int temp = array[index+1];
						array[index+1] = Y;
						array[id] = temp;
						yLastPos = id;
						break;
					}
				}
			}
		}
		
		return array;
	}
	
	
	/**
	 * Return the array index from which you can divide an array in such way that both array has same sum of values.
	 * @param array
	 * 			1D array of integers.
	 * @return integer
	 * 			index of the array if possilbe else -1.
	 */
	public static int splitArray(int[] array){
		int length = array.length;
		if(length==0){
			throw new AssertionError("Array is Empty.");
		}
		int sumOfArray = 0;
		for(int value: array){
			sumOfArray += value;
		}
		int tempSum = 0;
		for(int index = length-1; index>=0; index--){
			tempSum += array[index];
			sumOfArray -= array[index];
			if(tempSum==sumOfArray){
				return index;
			}
		}
		return -1;
	}
	
}
