package calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;

import calculator.Lexer;
import calculator.Lexer.Token;
import calculator.Lexer.TokenMismatchException;

/*
 * TODO (optional) define your grammar here
 *  THIS IS OPTIONALTHIS IS OPTIONALTHIS IS OPTIONALTHIS IS OPTIONALTHIS IS OPTIONAL
 */

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {
	private static ArrayList<Token> tokens = new ArrayList<Token>(); 
	private int i;
	private int pCounter ;//parenthesisCount
	DecimalFormat df = new DecimalFormat("##.0");
	@SuppressWarnings("serial")
	static class ParserException extends RuntimeException {
	}

	/**
	 * Type of values.
	 */
	private enum ValueType {
		POINTS, INCHES, SCALAR
	};

	/**
	 * Internal value is always in points.
	 */
	public class Value {
		final double value;
		final ValueType type;
		private Type tokenType;
		
		Value(double value, ValueType type) {
			this.value = value;
			this.type = type;
		}
		
		Value(double value, ValueType type, Type tokenType) {
			this.value = value;
			this.type = type;
			this.tokenType = tokenType;
		}

		@Override
		public String toString() {
			
			switch (type) {
			case INCHES:
				return Double.parseDouble(df.format(value / PT_PER_IN)) + " in";
			case POINTS:
				return value + "pt";
			default:
				return "" + value;
			}
		}
	}

	private static final double PT_PER_IN = 72;
	private final Lexer lexer;

	
	Parser(Lexer lexer) throws TokenMismatchException {// process of analyzing a string of symbols
    	tokens.clear();
    	this.lexer = lexer;
    	this.pCounter = 0;//Initialized to zero
    	Token tokenLex = lexer.goNext();
    	while(tokenLex.getType() != Type.END){// not towards the end of the line
    		tokens.add(tokenLex);
    		tokenLex = lexer.goNext();
    	}
	}

	
	public Value evaluate() throws TokenMismatchException {
		Stack<Token> tokenStack = new Stack<Token>();
		ArrayList<String> position = new ArrayList<String>(); 
		Value answer;
		Token x =tokens.get(i);
		
		while(x.getType() !=Type.END) {
			String string =x.getValue();
			Type tokenType=x.getType();
			switch(tokenType) {
			case INCH:
				tokenStack.push(x);
				int lastpos = position.size()-1;
				Double valNew = Double.parseDouble(position.get(lastpos))*72;
				position.remove(lastpos);
				position.add(String.valueOf(valNew));
				i++;
				break;
			case OPERATOR:
				position.add(string);
				i++;
				break;
				
			case PLUS:
				tokenStack.push(x); //push to stack.
				i++;
				break;
				
			case MINUS:
				tokenStack.push(x);
				i++;
				break;
				
				
			case TIMES:
				tokenStack.push(x);
				i++;
				break;
				
			case DIVIDE:
				tokenStack.push(x);
				i++;
				break;
			case L_PAREN:
				tokenStack.push(x);
				i++;
				break;
			case R_PAREN:// closing parenthesis
				pCounter++;
				answer = solve(tokenStack, position);
				position.add(String.valueOf(answer.value));//add to position
				if((answer.type==ValueType.POINTS)||(answer.type==ValueType.POINTS)) {
					if(answer.type==ValueType.POINTS) {
						tokenStack.push(new Token(Type.POINT));
					}
						else {
							tokenStack.push(new Token(Type.POINT));
					}
				}
				tokenStack.push(x);
				i++;
				break;
			default:
				break;
			}
			if(i==tokens.size()) {
				answer=solve(tokenStack,position);
				return answer;
			}
		}
		
		return solve(tokenStack,position);
		
	}
	private Value solve(Stack<Token> s, ArrayList<String> a) throws TokenMismatchException{
		   int index = 0;
		   
		   ValueType type = ValueType.SCALAR;
		   Type tokenType = Type.OPERATOR;
		   int leftIndex = a.size()-2;
		   int rightIndex = a.size() -1;
		   
		   
		   double leftOperand =  Double.parseDouble(a.get(leftIndex));
		   double rightOperand =  Double.parseDouble(a.get(rightIndex));
		   double result = rightOperand; 
		   boolean operationChecker = false;
		   
		   
		   
		   Token top = s.pop();
		  
		   while(top != null){
			   Type operation = top.getType(); 
			   int sizeOfStack = s.size();
			   
			   if(operationChecker){
				   rightOperand = result;
				   leftIndex--;
				   if(leftIndex < 0){
					   leftIndex = 0;
				   }
				   
				   leftOperand = Double.parseDouble(a.get(leftIndex));
				   operationChecker = false;
			   }
			   
			   
			   switch(operation){
		       case PLUS:
		    	   if(a.size() == 1){
		    		   throw new TokenMismatchException("do not need to support"+a.get(index)+"\\+" );
		    	   }else{
		    		   int operatorsIndex = sizeOfStack-1;
		    		   if((operatorsIndex < 0)){
		    			   
		    			   if(type == ValueType.INCHES){
		    				   leftOperand = leftOperand * PT_PER_IN;
		    			   }
		    			   
		    		   }else{
		    			  
		    			   type =  unitConvert( s, type);
		    			  
		    		   }
		    		   
		    		   result = leftOperand + rightOperand;
		    		   operationChecker = true;
		    	   }
		    	   break;
		       case TIMES:
		    	   if(a.size() == 1){
		    		throw new TokenMismatchException("do not support");   
		    	   }else{
		    		   result =  leftOperand * rightOperand;
		    		   operationChecker = true;
		    	   }
		    	   break;
		       case MINUS:
		    	   if(a.size() == 1){
			    		throw new TokenMismatchException("do not support");   
			    	   }else{
			    		   if((sizeOfStack-1 < 0)){
			    			   if(type == ValueType.INCHES){
			    				   leftOperand = leftOperand * PT_PER_IN;
			    			   }
			    		   }else{
			    			 type =  unitConvert( s, type);
			    		   }
			    		   result =  leftOperand - rightOperand;
			    		   operationChecker = true;
			    	   }
		    	   break;
		       case DIVIDE:
		    	   if(a.size() == 1){
			    		throw new TokenMismatchException("do not support");   
			    	   }else{
			    		   if(sizeOfStack-1 > 0){
			    			   if((type == ValueType.POINTS) || (type == ValueType.INCHES)){
				    			   type = ValueType.SCALAR;
				    		   }
			    		   }
			    		   result =  leftOperand / rightOperand;
			    		   operationChecker = true;
			    	   }
		    	   break;
		       case INCH:
		    	   
		    	   if(a.size() == 1){
		    		   return new Value((PT_PER_IN * leftOperand), type, Type.INCH);
		    	   }else{
		    		   if(pCounter == 0 ){
		    			   type = ValueType.INCHES;
			    		   tokenType = Type.INCH;  
		    		  }else{
		    			  if(type != ValueType.SCALAR){
		    				  
		    				  break;
		    			  }else{
		    				  type = ValueType.INCHES;
				    		   tokenType = Type.INCH; 
		    			  }
		    		   }
		    	   }
		    	   break;
		       case POINT:
		    	   if(a.size() == 1){
		    		   return new Value(leftOperand, type, Type.POINT);
		    	   }else{
		    		  
		    		  if(pCounter == 0 ){
		    			   type = ValueType.POINTS;
			    		   tokenType = Type.POINT; 
			    		  
		    		  }else{
		    			  if(type != ValueType.SCALAR){  
		    				  break;
		    			  }else{
		    				  type = ValueType.POINTS;
				    		   tokenType = Type.POINT; 
		    			  }
		    		  } 
		    	   }
		    	   break;
		       case L_PAREN:
		    	   if(pCounter > 0){
		    		   pCounter--;

		    	   }else{
		    		   pCounter = 0;
		    	   }
		    	   
		    	   break;
		       case R_PAREN:
		    	   pCounter++;
			   default:
				   break;
		     }
			   if(s.empty() ){
				   
//				   result = unit1 rightOperand operation unit2  leftOperand;
				   return new Value(result, type, tokenType);
			   }
			   top = s.pop(); 
			   
		   }
		return new Value(rightOperand, type, tokenType);
	   }
	private ValueType unitConvert(Stack<Token> stack, ValueType k){
 	   int operatorsIndex = stack.size()-1;
			Type  operation = stack.get(operatorsIndex).getType();
			  
			switch (operation) {
			case R_PAREN:
				 stack.pop();
				return unitConvert( stack ,k);
			case INCH:
				return ValueType.INCHES;
			case POINT:
				return ValueType.POINTS;
			case TIMES:
				
			default:
				break;
			}
			return k;
 }
}
