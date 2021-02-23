package Question1;

public class MainClass {
	public static void main(String[] args) {
		hexCalc first = new hexCalc("A1A");
		hexCalc second = new hexCalc("1F1");
		
		System.out.println("Addition = " + first.add(second) );
		System.out.println("Subtraction = " + first.subtract(second));
		System.out.println("Multiplication = " + first.multiply(second));
		System.out.println("Division = " + first.divide(second));
		
		System.out.println("Decimal Value of First HexString = " + first.toDecimal());
		System.out.println("Decimal Value of Second HexString = " + second.toDecimal());
		
		System.out.println(hexCalc.isEqual(first, second));
		System.out.println(hexCalc.isGreaterThan(first, second));
		System.out.println(hexCalc.isLessThan(first, second));
	}
}
