package recursion_Q3;

import static java.lang.System.out;

public class NQueens {
	
	/**
	 * isSafe function checks whether the position is safe or not for a queen.
	 * @param board
	 * 			2D array of 0 & 1 representing chess board.
	 * @param curRow
	 * 			current row on which we are checking
	 * @param curCol
	 * 			current column on which we are checking
	 * @param size
	 * 			size of the chess board or no of queens.
	 * @return boolean
	 * 			true if position is safe else false
	 */
	private static boolean isSafe(int[][] board, int curRow, int curCol, int size){
		for(int row=0; row<curRow; row++){
			if(board[row][curCol]==1){
				return false;
			}
		}
		
		int diagonalRow = curRow;
		int diagonalCol = curCol;
		// checking left diagonal
		while(diagonalRow>=0 && diagonalCol>=0){
			if(board[diagonalRow][diagonalCol]==1){
				return false;
			}
			diagonalRow--;
			diagonalCol--;
		}
		
		diagonalRow = curRow;
		diagonalCol = curCol;
		// checking right diagonal
		while(diagonalRow>=0 && diagonalCol<size){
			if(board[diagonalRow][diagonalCol]==1){
				return false;
			}
			diagonalRow--;
			diagonalCol++;
		}
		return true;
	}
	
	
	/**
	 * Recursive NQueen function
	 * @param board
	 * 			2D array of 0 & 1 representing chess board.
	 * @param row
	 * 			current row in which we are putting our queen
	 * @param size
	 * 			size of the chess board.
	 * @return boolean
	 * 			true if we place a queen successfully otherwise false.
	 */
	private static boolean nQueen(int[][] board, int row, int size){
		if(row>=size){
			return true;
		}
		
		for(int col=0; col<size; col++){
			if(isSafe(board, row, col, size)){
				board[row][col]=1;
				
				if(nQueen(board, row+1, size)){  // recursion
					return true;
				}
				
				board[row][col]=0; // backtracking
			}
		}
		return false;
	}
	
	
	/**
	 * To display the result if possible.
	 * @param size
	 * 			the size of the chess board or number of queens.
	 */
	public static void getResult(int size){
		int[][] board = new int[size][size];
		
		if(nQueen(board, 0,size)){
			out.println("Solution for given board size: ");
			for(int row=0; row<size; row++){
				for(int col=0; col<size; col++){
					System.out.print(board[row][col] + " ");
				}
				out.println();
			}
		}else{
			out.println("There is no solution for given size.");
		}
	}
}
