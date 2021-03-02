package assignment3_Q2;
import static java.lang.System.out;
public class MainClass {
	public static void main(String[] args) {
		int[] polyArr = {2,3,1};
		Poly polyOne = new Poly(3, polyArr);
		out.println(polyOne.toString());
		out.println(polyOne.evaluate(0));
		
		int[] polyAr = {3,4,1,4};
		Poly polyTwo = new Poly(4, polyAr);
		out.println(polyTwo.toString());
		
		Poly newPoly = Poly.addPoly(polyOne, polyTwo);
		out.println(newPoly.toString());
		out.println(newPoly.evaluate(2.0f));
		
		Poly newMulPoly = Poly.multiplyPoly(polyOne, polyTwo);
		out.println(newMulPoly.toString());
		
		Poly polyThree = new Poly(2, new int[]{8, -3});
		out.println(polyThree.toString());
		out.println(Poly.addPoly(polyOne, polyThree));
		
	}
}
