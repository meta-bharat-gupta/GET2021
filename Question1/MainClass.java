package Question1;

import static java.lang.System.out;
public class MainClass {
	public static void main(String[] args) {
		hexCalc first = new hexCalc("A1A");
		hexCalc second = new hexCalc("0");
		
		out.println("Addition = " + first.add(second) );
		out.println("Subtraction = " + first.subtract(second));
		out.println("Multiplication = " + first.multiply(second));
		out.println("Division = " + first.divide(second));
		
		out.println("Decimal Value of First HexString = " + first.toDecimal());
		out.println("Decimal Value of Second HexString = " + second.toDecimal());
		
		out.println(hexCalc.isEqual(first, second));
		out.println(hexCalc.isGreaterThan(first, second));
		out.println(hexCalc.isLessThan(first, second));
	}
}
