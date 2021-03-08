package assignment6;

public class MainClass {
	
	
	public static void main(String[] args) {
//		int noOfValues, totalRow, totalCol;
		
		int[][] data = new int[][]{{1,2,3},{2,1,5},{4,2,7}};
		

		SparseMatrix sm = new SparseMatrix(data, 3, 4, 4);
		System.out.println("First Matrix: ");
		sm.printMatrix();
		System.out.println("Transpose of First Matrix: ");
		sm.getTranspose().printMatrix();
		int[][] data2 = new int[][]{{1,2,3},{2,1,5},{4,2,7},{2,2,4}, {1,1,6}};
		SparseMatrix sm2 = new SparseMatrix(data2, 4, 4, 4);
		System.out.println("Second Matrix: ");
		sm2.printMatrix();
		try{
			SparseMatrix addSM = sm.addSparseMatrix(sm2);
			System.out.println("Addition of the matrices: ");
			addSM.printMatrix();			
		}catch(Exception e){
			System.out.println("Matrices can't be added");
		}
		try{
			SparseMatrix mulSM = sm.multiplySparseMatrix(sm2);
			System.out.println("Multiplication of metrices:");
			mulSM.printMatrix();			
		}catch(Exception e){
			System.out.println("Matrices can't be multiplied.");
		}
		System.out.println("Symmetric : "+ sm.isSymmetric());
		
	}
}
