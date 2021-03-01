package assignment3_Q2;

final public class Poly {
	final private int polyDegree;
	final private int[] polynomial;
	
	/**
	 * Constructor to initialize polynomial.
	 * @param degree
	 * 			degree of the polynomial
	 * @param poly
	 * 			1D array for the coefficient in the increasing order of power of variable.
	 */
	public Poly(int degree, int[] poly){
		this.polyDegree = degree;
		polynomial = new int[degree];
		for(int i=0; i<poly.length; i++){
			this.polynomial[i] = poly[i];
		}
	}
	
	/**
	 * To add two Poly class object polynomials.
	 * @param polyOne
	 * 			Poly Class Object
	 * @param polyTwo
	 * 			Poly Class Object
	 * @return addPoly
	 * 			Addition of two polynomial objects received in parameters.
	 * 
	 */
	public static Poly addPoly(Poly polyOne, Poly polyTwo){
		int addPolyDegree = polyOne.degree()>=polyTwo.degree()?polyOne.degree():polyTwo.degree();
		int[] addPolyArr = new int[addPolyDegree];
		for(int i=0; i<polyOne.degree();i++){
			addPolyArr[i] = polyOne.polynomial[i];
		}
		for(int i=0; i<polyTwo.degree();i++){
			addPolyArr[i] += polyTwo.polynomial[i];
		}
		return new Poly(addPolyDegree, addPolyArr);
	}
	
	/**
	 * To evaluate a Polynomial for given value.
	 * @param value
	 * 			a float value on which polynomial will be evaluated.
	 * @return float
	 * 			a float value after evaluating the polynomial for given value.
	 */
	public float evaluate(float value){
		float result = 0.0f;
		for(int i=0; i<this.degree();i++){
			result += this.polynomial[i] * Math.pow(value, i);
		}
		return result;
	}
	
	/**
	 * To multiply two Poly Object polynomials.
	 * @param polyOne
	 * 			first Poly Object
	 * @param polyTwo
	 * 			second Poly Object
	 * @return mulPoly
	 * 			Multiplication of given two Poly Object polynomials.
	 */
	public static Poly multiplyPoly(Poly polyOne, Poly polyTwo){
		int degree = polyOne.degree() * polyTwo.degree();
		int[] mulPolyArr = new int[degree];
		for(int i=0; i<polyOne.degree(); i++){
			for(int j=0; j<polyTwo.degree(); j++){
				mulPolyArr[i+j] += polyOne.polynomial[i] * polyTwo.polynomial[j];
			}
		}
		return new Poly(degree, mulPolyArr);
	}
	
	/**
	 * To print the polynomial in a String format.
	 */
	public String toString(){
		String polyString="";
		for(int i=0; i<this.polyDegree; i++){
			if(polynomial[i]==0){
				continue;
			}else{
				polyString += "  " +this.polynomial[i]+"x^"+i;
			}
		}
		return polyString;
	}
	
	/**
	 * To return the degree of the polynomial.
	 * @return
	 */
	public int degree(){
		int degree = this.polyDegree;
		return degree;
	}
	
	
}
