package recursion_Q3;

public class NQueens {
	
	private static boolean isSafe(int[][] board, int rows, int cols, int number){
		for(int row=0; row<rows; row++){
			if(board[row][cols]==1){
				return false;
			}
		}
		
		int row = rows;
		int col = cols;
		
		while(row>=0 && col>=0){
			if(board[row][col]==1){
				return false;
			}
			row--;
			col--;
		}
		
		row = rows;
		col = cols;
		
		while(row>=0 && row<number){
			if(board[row][col]==1){
				return false;
			}
			row--;
			col++;
		}
		return true;
	}
	
	
	private static boolean nQueen(int[][] board, int row, int number){
		if(row>=number){
			return true;
		}
		
		for(int col=0; col<number; col++){
			if(isSafe(board, row, col, number)){
				board[row][col]=1;
				
				if(nQueen(board, row+1, number)){
					return true;
				}
				
				board[row][col]=0; // backtracking
			}
		}
		return false;
	}
	public static void getResult(int number){
		int[][] board = new int[number][number];
		
		if(nQueen(board, 0,number)){
			System.out.println("Solution for given board size: ");
			for(int row=0; row<number; row++){
				for(int col=0; col<number; col++){
					System.out.print(board[row][col] + " ");
				}
				System.out.println();
			}
		}else{
			System.out.println("There is no solution for given size.");
		}
	}
}
