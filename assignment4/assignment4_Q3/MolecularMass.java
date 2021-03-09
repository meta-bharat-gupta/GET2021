package assignment4_Q3;

import java.util.ArrayList;
import java.util.Stack;

public class MolecularMass {
	
	/**
	 * Return the atomic mass of the element
	 * @param element
	 * 			String representation of the element
	 * @return integer
	 * 			atomic weight of the element
	 */
	public int getAtomicWeight(String element){
		int weight = 0;
		if(element.equals("C"))
			weight = 12;
		else if(element.equals("H"))
			weight = 1;
		else if(element.equals("O"))
			weight = 16;
		return weight;
	}
	
	
	/**
	 * Calculate the Molecular Mass of the compound and returns it.
	 * @param compound
	 * 			String representation of the compound formula.
	 * @return integer
	 * 			Weight of the Molecular Compound
	 */
	public int calculateMass(String compound){
		Stack<String> weightStack = new Stack<String>();
		ArrayList<String> compoundFormula = getFormula(compound);
		int moleculeWeight = 0;
		for(int index = 0; index<compoundFormula.size(); index++){
			String token = compoundFormula.get(index);
			if(token.equals("(")){
				weightStack.push(compoundFormula.get(index));
			}else if(token.equals(")")){
				int tempWeight = 0;
				while(!weightStack.peek().equals("(")){
					tempWeight += Integer.parseInt(weightStack.pop());
				}
				weightStack.pop();
				weightStack.push(String.valueOf(tempWeight));
			}else if(isNumber(token)){
				int top = Integer.parseInt(weightStack.pop());
				int multiplier = Integer.parseInt(token);
				weightStack.push(String.valueOf(top*multiplier));
			}else{
				weightStack.push(String.valueOf(getAtomicWeight(token)));
			}
		}
		while(!weightStack.isEmpty()){
			moleculeWeight += Integer.parseInt(weightStack.pop());			
		}
		return moleculeWeight;
	}
	
	
	/**
	 * Converts the compound formula into the tokens.
	 * @param compound
	 * 			String representation of the molecular compound
	 * @return ArrayList
	 * 			tokens of the molecular formula as an arraylist
	 */
	public ArrayList<String> getFormula(String compound){
		ArrayList<String> formulaTokens = new ArrayList<String>();
		//checking whether string is null or not
		if (compound != null) {
			for (int index = 0; index < compound.length(); index++) {
				// checking if there is any number present
				if (Character.isDigit(compound.charAt(index))) {
					String number = new String();
					// checking whether number is more than one character
					while (index < compound.length() && Character.isDigit(compound.charAt(index))){
						number += compound.charAt(index);
						index++;
					}
					index--;
					formulaTokens.add(number);
				}
				else {
					formulaTokens.add(String.valueOf(compound.charAt(index)));
				}
			}
		}
		return formulaTokens;
	}
	
	
	/**
	 * Checks whether a token is number or not.
	 * @param str
	 * 			a token from the arraylist
	 * @return
	 * 		true if token is number otherwise false
	 */
	public boolean isNumber(String str){
		try{
			Integer.parseInt(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
