package PartA;

// Question 2
// total: 10 points

//===============================================
// todo: provide the value for
//===============================================




import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
//	private static final String REGEX = "aaabccacca";
	

	public static void main(String[]args) {
		
		//TODO: initialize str appropriately
		String str = "a\\w{2,5}";// Predefined Character Classes, first letter is a , followed by any word of length 2-5

		Pattern p1 = Pattern.compile(str);
		Matcher m = p1.matcher("aaabcc");
		boolean b = m.matches();
		System.out.println(b);
		//true

		Matcher m2 = p1.matcher("accc");
		boolean b2 = m2.matches();
		System.out.println(b2);
		//true
		Matcher m3 = p1.matcher("aaaabccccc");
		boolean b3 = m3.matches();
		System.out.println(b3);
		//false 
		Matcher m4 = p1.matcher("aabbccccc");
		boolean b4 = m4.matches();
		System.out.println(b4);
		//false
		Matcher m5 = p1.matcher("aab");
		boolean b5 = m5.matches();
		System.out.println(b5);
		//true
	}
}
