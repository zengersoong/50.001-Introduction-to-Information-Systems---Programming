package PartC.calculator.calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator lexical analyzer.
 */
public class Lexer {

	public ArrayList<Token> tokens;
	
	/**
	 * Token in the stream.
	 */
	public static class Token {
		final Type type;
		final String text;

		Token(Type type, String text) {
			this.type = type;
			this.text = text;
		}

		Token(Type type) {
			this(type, null);
		}
		
	}


	
	@SuppressWarnings("serial")
	static class TokenMismatchException extends Exception {
	}

	// TODO write method spec
	public Lexer(String input) {
		tokens = new ArrayList<Token>();
		int pos = 0;
		
		Pattern num_matcher = Pattern.compile("\\s*(\\d+(\\.\\d+)?)\\s*");
		Pattern space_matcher = Pattern.compile("\\s+");
		Pattern plus_matcher  = Pattern.compile("\\s*\\+\\s*");
		Pattern minus_matcher  = Pattern.compile("\\s*-\\s*");
		Pattern times_matcher  = Pattern.compile("\\s*\\*\\s*");
		Pattern divide_matcher  = Pattern.compile("\\s*/\\s*");
		Pattern lparen_matcher  = Pattern.compile("\\s*\\(\\s*");
		Pattern rparen_matcher  = Pattern.compile("\\s*\\)\\s*");
		Pattern inch_matcher  = Pattern.compile("\\s*in\\s*");
		Pattern point_matcher  = Pattern.compile("\\s*pt\\s*");
		
		while ( pos < input.length() ) {
			Matcher match = num_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.NUMBER, match.group(1)));
				pos = match.end() + pos;
				continue;
			}
			match = plus_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.PLUS));
				pos = match.end() + pos;
				continue;
			}
			match = minus_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.MINUS));
				pos = match.end() + pos;
				continue;
			}
			match = divide_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.DIVIDE));
				pos = match.end() + pos;
				continue;
			}
			match = times_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.TIMES));
				pos = match.end() + pos;
				continue;
			}
			match = lparen_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.L_PAREN));
				pos = match.end() + pos;
				continue;
			}
			match = rparen_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.R_PAREN));
				pos = match.end()+ pos;
				continue;
			}
			match = inch_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.INCH));
				pos = match.end() + pos;
				continue;
			}
			match = point_matcher.matcher(input.substring(pos));
			if (match.lookingAt() ) {
				tokens.add(new Token(Type.POINT));
				pos = match.end() + pos;
				continue;
			}
		}
		
	}
}
