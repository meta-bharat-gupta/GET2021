package assignment3_Q2;

public class MainClass {
	public static void main(String[] args) {
		int[] polyArr = {2,3,1};
		Poly polyOne = new Poly(3, polyArr);
		System.out.println(polyOne.toString());
		System.out.println(polyOne.evaluate(0));
		
		int[] polyAr = {3,4,1,4};
		Poly polyTwo = new Poly(4, polyAr);
		System.out.println(polyTwo.toString());
		
		Poly newPoly = Poly.addPoly(polyOne, polyTwo);
		System.out.println(newPoly.toString());
		System.out.println(newPoly.evaluate(2.0f));
		
		Poly newMulPoly = Poly.multiplyPoly(polyOne, polyTwo);
		System.out.println(newMulPoly.toString());
		
		Poly polyThree = new Poly(2, new int[]{8, -3});
		System.out.println(polyThree.toString());
		System.out.println(Poly.addPoly(polyOne, polyThree));
		
	}
}
