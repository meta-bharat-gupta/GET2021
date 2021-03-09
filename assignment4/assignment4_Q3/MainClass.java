package assignment4_Q3;

public class MainClass {
	public static void main(String[] args) {
		MolecularMass mMass = new MolecularMass();
		String compound = "CHOHO(CH)3(CHO)5";
		int weight = mMass.calculateMass(compound);
		System.out.println(weight);
	}
}
