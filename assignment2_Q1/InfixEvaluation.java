package assignment2_Q1;


public class InfixEvaluation {
	
	private static int precedence(String token){
		if(token.equals("+") || token.equals("-")){
			return 2;
		}else if(token.equals("*") || token.equals("/")){
			return 3;
		}else if(token.equals(">=") || token.equals("<=") || token.equals("==") || token.equals("!=")){
			return 1;
		}else if(token.equals("&&") || token.equals("||")){
			return 0;
		}
		return -1;
	}

	
	public static int tokenType(String str){
		String[] ops = new String[]{"+", "-", "*", "/", ">=", "<=", "==", "!="};
		
		try{
			Integer.parseInt(str);
			return 1;
		}catch(Exception e){
			for(int val=0; val<ops.length; val++){
				if(str.equals(ops[val]))
					return 2;
			}
			return 3;
		}
		
	}
	
	private static int evaluate(String operator, int secondInt, int firstInt){
		int result=0;
		switch(operator){
		case "+":
			result = firstInt + secondInt;
			break;
		case "-":
			result = firstInt - secondInt;
			break;
		case "*":
			result = firstInt * secondInt;
			break;
		case "/":
			if (secondInt == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
			result = firstInt / secondInt;
			break;
		case "&&":
			if(firstInt==0 || secondInt==0)
				result = 0;
			result = 1;
			break;
		case "||":
			if(firstInt==1 || secondInt==1)
				result = 1;
			else
				result = 0;
			break;
		case ">=":
			if(firstInt >= secondInt)
				result = 1;
			else
				result = 0;
			break;
		case "==":
			if(firstInt == secondInt)
				result = 1;
			else
				result = 0;
			break;
		case "<=":
			if(firstInt == secondInt)
				result = 1;
			else
				result = 2;
			break;
		}
		return result;
	}
	
	public static int infixEvaluation(String expression){
		
		OperandStack values = new OperandStack();
		OperatorStack operators = new OperatorStack();
		
		String[] tokens = expression.split(" ");
		for(int index=0; index<tokens.length; index++){
			int type = tokenType(tokens[index]);
			switch(type){
				case 1:
					System.out.println("Value");
					values.push(Integer.parseInt(tokens[index]));
					break;
				case 2:
					System.out.println("Operator");
					if(operators.isEmpty()){
						operators.push(tokens[index]);
					}else{
						while(!operators.isEmpty() && precedence(operators.peek())>=precedence(tokens[index])){
							int result = evaluate(operators.pop(), values.pop(), values.pop());
							values.push(result);
						}
						operators.push(tokens[index]);
					}
					break;
				case 3:
					if(tokens[index].equals("(")){
						operators.push(tokens[index]);
					}else{
						while(!operators.peek().equals("(")){
							int result = evaluate(operators.pop(), values.pop(), values.pop());
							values.push(result);
						}
						operators.pop();
					}
					break;
			}
		}

		while(!operators.isEmpty()){
			System.out.println("while running");
			int result = evaluate(operators.peek(), values.pop(), values.pop());
			values.push(result);
			operators.pop();
		}
		return values.pop();
	}
}
