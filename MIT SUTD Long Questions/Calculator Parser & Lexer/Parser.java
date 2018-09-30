package PartC.calculator.calculator;

import java.util.ArrayList;

import PartC.calculator.calculator.Lexer.Token;

/*
 * TODO (optional) define your grammar here
 */

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {
	
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

		Value(double value, ValueType type) {
			this.value = value;
			this.type = type;
		}

		@Override
		public String toString() {
			switch (type) {
			case INCHES:
				return value / PT_PER_IN + " in";
			case POINTS:
				return value + " pt";
			default:
				return "" + value;
			}
		}
	}

	private static final double PT_PER_IN = 1; //72;
	private Value Result;
	//private final Lexer lexer;

	Value operate(Value v1, Value v2, Type operator) {
		double res = -1;
		ValueType resultType = ValueType.SCALAR;
		
		switch(operator) {
		case PLUS: 
			res = v1.value + v2.value;
			if ( v1.type == ValueType.SCALAR && v2.type == ValueType.INCHES)
				resultType = ValueType.INCHES;
			if ( v2.type == ValueType.SCALAR && v1.type == ValueType.INCHES)
				resultType = ValueType.INCHES;
			if ( v1.type == ValueType.INCHES && v2.type == ValueType.POINTS)
				resultType = ValueType.INCHES;
			if ( v1.type == v2.type)
				resultType = v1.type;
			break;
		case MINUS:
			res = v1.value - v2.value;
			if ( v1.type == v2.type)
				resultType = v1.type;
			break;
		case TIMES:
			res = v1.value * v2.value;
			if ( v1.type == ValueType.INCHES && v2.type == ValueType.SCALAR)
				resultType = ValueType.INCHES;
			if ( v2.type == ValueType.INCHES && v1.type == ValueType.SCALAR)
				resultType = ValueType.INCHES;
			if ( v2.type == ValueType.INCHES && v1.type == ValueType.INCHES)
				resultType = ValueType.INCHES;
			break;
		case DIVIDE:
			res = v1.value / v2.value;
			if ( v1.type == ValueType.INCHES && v2.type == ValueType.SCALAR )
				resultType = ValueType.INCHES;
			if ( v1.type == ValueType.SCALAR && v2.type == ValueType.INCHES)
				resultType = ValueType.INCHES;
			break;	
		}
		
			
		return new Value(res, resultType);
	}
	
	Value reduce(ArrayList<Token> tokens, int pos ) {
		Value v1 = null;
		Value v2 = null;
		Type operator = null;
		
		while ( pos < tokens.size()) {
			Token tok = tokens.get(pos);
			
			if ( tok.type == Type.L_PAREN) {
				Value val = reduce(tokens, pos + 1);
				while (tokens.get(pos).type != Type.R_PAREN) pos++;
				if ( pos < tokens.size() -1 && tokens.get(pos + 1).type == Type.INCH){
					val = new Value(val.value, ValueType.INCHES);
					pos++;
				} 
				if ( pos < tokens.size() -1 && tokens.get(pos + 1).type == Type.POINT){
					val = new Value(val.value, ValueType.POINTS);
					pos++;
				} 
				if ( v1 == null ) {
					v1 = val;
				} else {
					v2 = val;
					return operate(v1,v2,operator);
				} 
				
				
				
			} else if ( tok.type == Type.NUMBER) {
				double val =  Double.valueOf(tok.text);
				Value v;
				if ( pos < tokens.size() - 1 && tokens.get(pos + 1).type == Type.INCH ) {
					v = new Value(val, ValueType.INCHES);
					pos++;
				} else if (pos < tokens.size() - 1 && tokens.get(pos + 1).type == Type.POINT ) {
					v = new Value(val, ValueType.POINTS);
					pos++;
				} else {
					v = new Value(val, ValueType.SCALAR);
				}
				if ( v1 == null ) {
					v1 = v;
				} else {
					v2 = v;
					return operate(v1, v2, operator);
				}
			} else if ( tok.type == Type.PLUS) {
				operator = Type.PLUS;
			} else if ( tok.type == Type.MINUS) {
				operator = Type.MINUS;
			} else if ( tok.type == Type.TIMES) {
				operator = Type.TIMES;
			} else if ( tok.type == Type.DIVIDE) {
				operator = Type.DIVIDE;
			} 
			pos++;
			
			
		}
		return v1;
	}
	
	
	// TODO write method spec
	Parser(Lexer lexer) {
		// TODO implement for Problem 
		int pos = 0;
		Result = reduce(lexer.tokens, pos);
		
	}

	// TODO write method spec
	public Value evaluate() {
		// TODO implement for Problem 
		return Result;
		
	}
	
}
