package assignment6;

import java.util.Arrays;
import java.util.Comparator;

final public class SparseMatrix {
	final private int[][] data;
	final private int totalRows;
	final private int totalCols;
	final private int noOfNonZeroValues;
	final private int rowIndex = 0;
	final private int colIndex = 1;
	final private int valueIndex = 2;
	
	/**
	 * Constructor for Sparse Matrix
	 * @param dataValues
	 * 			2D array of non-zero elements with their row and column values.
	 * @param noOfValues
	 * 			total non-zero elements in matrix.
	 * @param noOfRows
	 * 			total rows in the matrix
	 * @param noOfCols
	 * 			total columns in the matrix
	 */
	public SparseMatrix(int[][] dataValues, int noOfValues, int noOfRows, int noOfCols){
		this.noOfNonZeroValues = noOfValues;
		this.totalRows = noOfRows;
		this.totalCols = noOfCols;
		data = new int[noOfNonZeroValues][3];
		for(int index = 0; index<noOfValues; index++){
			this.data[index][rowIndex] = dataValues[index][rowIndex];
			this.data[index][colIndex] = dataValues[index][colIndex];
			this.data[index][valueIndex] = dataValues[index][valueIndex];
		}

		sort(this.data);
	}
	
	
	/**
	 * This method helps in to keep row,column sorted in a sparse matrix.
	 * @param array
	 * 		a 2D array of integers which has non-zero values with their row and column index.
	 */

	public void sort(int array[][]) {
		Comparator<int[]> comparator = new Comparator<int[]>() {

			@Override
			public int compare(int[] first, int[] second) {
				// For row
				if (first[0] > second[0])
					return 1;
				else if (first[0] < second[0])
					return -1;
				// For column
				else if (first[1] > second[1])
					return 1;
				else
					return -1;
			}
		};
		Arrays.sort(array, comparator);
	}

	/**
	 * This function creates transpose of a sparse matrix.
	 * @return SparseMatrix
	 * 		transpose SparseMatrix object of a sparse matrix.
	 */
	public SparseMatrix getTranspose(){
		int[][] transposeData = new int[this.totalCols][this.totalRows];
		for(int row=0; row<noOfNonZeroValues; row++){
			transposeData[row][colIndex] = this.data[row][rowIndex];
			transposeData[row][rowIndex] = this.data[row][colIndex];
			transposeData[row][valueIndex] = this.data[row][valueIndex];
		}
		return new SparseMatrix(transposeData, noOfNonZeroValues, totalCols, totalRows);
	}
	
	
	/**
	 * This function adds a SparseMatrix to another.
	 * @param secondSM
	 * 			sparse matrix object for addition
	 * @return SparseMatrix
	 * 			return the Sparse Matrix of addition of both matrices.
	 */
	public SparseMatrix addSparseMatrix(SparseMatrix secondSM){
		SparseMatrix firstSM = this;
		if(firstSM.totalCols!=secondSM.totalCols || firstSM.totalRows!=secondSM.totalRows){
			System.out.println("Different Dimension Matrices can't be added.");
			return null;
		}
		int noOfValuesInResultMatrix = findSizeOfResultMatrix(firstSM, secondSM);
		int[][] resultData = new int[noOfValuesInResultMatrix][3];
		int rowInFirst = 0, rowInSecond = 0;
		int counter = 0;

		while (rowInFirst < firstSM.noOfNonZeroValues && rowInSecond < secondSM.noOfNonZeroValues) {

			// If row index of first matrix is less than row index of second
			// matrix
			if (firstSM.data[rowInFirst][rowIndex] < secondSM.data[rowInSecond][rowIndex]) {
				resultData[counter][rowIndex] = firstSM.data[rowInFirst][rowIndex];
				resultData[counter][colIndex] = firstSM.data[rowInFirst][colIndex];
				resultData[counter][valueIndex] = firstSM.data[rowInFirst][valueIndex];
				rowInFirst++;
				counter++;
			}
			// If row index of first matrix is greater than row index of second
			// matrix
			else if (firstSM.data[rowInFirst][rowIndex] > secondSM.data[rowInSecond][rowIndex]) {
				resultData[counter][rowIndex] = secondSM.data[rowInSecond][rowIndex];
				resultData[counter][colIndex] = secondSM.data[rowInSecond][colIndex];
				resultData[counter][valueIndex] = secondSM.data[rowInSecond][valueIndex];
				rowInSecond++;
				counter++;
			}
			// If column index of first matrix is less than column index of
			// second matrix
			else if (firstSM.data[rowInFirst][colIndex] < secondSM.data[rowInSecond][colIndex]) {
				resultData[counter][rowIndex] = firstSM.data[rowInFirst][rowIndex];
				resultData[counter][colIndex] = firstSM.data[rowInFirst][colIndex];
				resultData[counter][valueIndex] = firstSM.data[rowInFirst][valueIndex];
				rowInFirst++;
				counter++;
			}
			// If column index of first matrix is greater than column index of
			// second matrix
			else if (firstSM.data[rowInFirst][colIndex] > secondSM.data[rowInSecond][colIndex]) {
				resultData[counter][rowIndex] = secondSM.data[rowInSecond][rowIndex];
				resultData[counter][colIndex] = secondSM.data[rowInSecond][colIndex];
				resultData[counter][valueIndex] = secondSM.data[rowInSecond][valueIndex];
				rowInSecond++;
				counter++;
			}
			// If row and column index of first and second matrix are equal
			else {
				resultData[counter][rowIndex] = firstSM.data[rowInFirst][rowIndex];
				resultData[counter][colIndex] = firstSM.data[rowInFirst][colIndex];
				resultData[counter][valueIndex] = firstSM.data[rowInFirst][valueIndex]
						+ secondSM.data[rowInSecond][valueIndex];
				rowInFirst++;
				rowInSecond++;
				counter++;
			}
		}

		// If rows are still left in first matrix
		while (rowInFirst < firstSM.noOfNonZeroValues) {
			resultData[counter][rowIndex] = firstSM.data[rowInFirst][rowIndex];
			resultData[counter][colIndex] = firstSM.data[rowInFirst][colIndex];
			resultData[counter][valueIndex] = firstSM.data[rowInFirst][valueIndex];
			rowInFirst++;
			counter++;
		}

		// If rows are still left in second matrix
		while (rowInSecond < secondSM.noOfNonZeroValues) {
			resultData[counter][rowIndex] = secondSM.data[rowInSecond][rowIndex];
			resultData[counter][colIndex] = secondSM.data[rowInSecond][colIndex];
			resultData[counter][valueIndex] = secondSM.data[rowInSecond][valueIndex];
			rowInSecond++;
			counter++;
		}
		
		return new SparseMatrix(resultData, noOfValuesInResultMatrix, totalRows, totalCols);
	}
	
	
	/**
	 * This method will calculate and find the total number of rows for the
	 * resultant addition matrix
	 * 
	 * @param first
	 *            It is the first sparse matrix
	 * @param second
	 *            It is the second sparse matrix
	 * @return the total number of row for the resultant addition matrix
	 */
	public int findSizeOfResultMatrix(SparseMatrix first, SparseMatrix second) {
		int size = 0;
		int rowInFirst = 0, rowInSecond = 0;
		while (rowInFirst < first.noOfNonZeroValues
				&& rowInSecond < second.noOfNonZeroValues) {
			if (first.data[rowInFirst][0] < second.data[rowInSecond][0]) {
				rowInFirst++;
				size++;
			} else if (first.data[rowInFirst][0] > second.data[rowInSecond][0]) {
				rowInSecond++;
				size++;
			} else if (first.data[rowInFirst][1] < second.data[rowInSecond][1]) {
				rowInFirst++;
				size++;
			} else if (first.data[rowInFirst][1] > second.data[rowInSecond][1]) {
				rowInSecond++;
				size++;
			} else {
				rowInFirst++;
				rowInSecond++;
				size++;
			}
		}
		while (rowInFirst < first.noOfNonZeroValues) {
			rowInFirst++;
			size++;
		}
		while (rowInSecond < second.noOfNonZeroValues) {
			rowInSecond++;
			size++;
		}
		return size;
	}
	
	/**
	 * Checks whether a matrix is symmetric or not.
	 * @return boolean
	 * 		returns true if matrix is symmetric otherwise false.
	 */
	public boolean isSymmetric() {
		SparseMatrix originalMatrix = this;
		SparseMatrix transposeMatrix = originalMatrix.getTranspose();

		for (int row = 0; row < originalMatrix.noOfNonZeroValues; row++) {
			if (originalMatrix.data[row][0] != transposeMatrix.data[row][0])
				return false;
			if (originalMatrix.data[row][1] != transposeMatrix.data[row][1])
				return false;
			if (originalMatrix.data[row][2] != transposeMatrix.data[row][2])
				return false;
		}
		return true;
	}
	
	/**
	 * This method is used to calculate the total number of rows will be there
	 * in the multiplication matrix
	 * 
	 * @param first
	 *            It is the first sparse matrix
	 * @param second
	 *            It is the second sparse matrix
	 * @return total number of rows in the multiplication matrix
	 */
	private int findRowsOfMultiplicationMatrix(SparseMatrix firstSM, SparseMatrix secondSM) {
		int count = 0;
		for (int rowInFirst = 0; rowInFirst < firstSM.noOfNonZeroValues; rowInFirst++) {
			for (int rowInSecond = 0; rowInSecond < secondSM.noOfNonZeroValues; rowInSecond++) {
				if (firstSM.data[rowInFirst][colIndex] == secondSM.data[rowInSecond][colIndex])
					count++;
			}
		}
		return count;
	}
	
	
	/**
	 * This method will multiply two sparse matrices and return the
	 * multiplication
	 * 
	 * @param second
	 *            It is the second sparse matrix
	 * @return the multiplication of the two sparse matrices
	 */
	public SparseMatrix multiplySparseMatrix(SparseMatrix secondSM) {
		SparseMatrix firstSM = this;

		// checking whether matrix are of different size
		if ((firstSM.totalCols != secondSM.totalRows)){
			System.out.println("Matrices can't be multiplied.");
		}

		// transpose of second matrix
		SparseMatrix transposedSecondMatrix = secondSM.getTranspose();
		int rowsOfMuliplicationMatrix = findRowsOfMultiplicationMatrix(firstSM,transposedSecondMatrix);

		// creating the multiplication matrix
		int multiplicationData[][] = new int[rowsOfMuliplicationMatrix][firstSM.totalCols];


		int count = 0;
		for (int rowInFirst = 0; rowInFirst < firstSM.noOfNonZeroValues; rowInFirst++) {
			for (int rowInSecond = 0; rowInSecond < transposedSecondMatrix.noOfNonZeroValues; rowInSecond++) {
				if (firstSM.data[rowInFirst][colIndex] == transposedSecondMatrix.data[rowInSecond][colIndex]) {
					multiplicationData[count][rowIndex] = firstSM.data[rowInFirst][rowIndex];
					multiplicationData[count][colIndex] = transposedSecondMatrix.data[rowInSecond][rowIndex];
					multiplicationData[count][valueIndex] = firstSM.data[rowInFirst][valueIndex]
							* transposedSecondMatrix.data[rowInSecond][valueIndex];
					count++;
				}
			}
		}

		return new SparseMatrix(multiplicationData, rowsOfMuliplicationMatrix, firstSM.totalRows, secondSM.totalCols);
	}
	
	
	/**
	 * This function prints the whole matrix.
	 */
	public void printMatrix(){
		int[][] matrix = new int[this.totalRows][this.totalCols];
		
		for(int val = 0; val<this.noOfNonZeroValues; val++){
			matrix[this.data[val][0]-1][this.data[val][1]-1] = this.data[val][2];
		}
		
		for(int row=0; row<this.totalRows; row++){
			for(int col=0; col<this.totalCols; col++){
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		
	}

}
