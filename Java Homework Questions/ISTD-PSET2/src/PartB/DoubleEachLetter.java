package PartB;


// Cohort Question 6
// total: 5 points

//===============================================
// todo: complete the following program
//==============================================6


public class DoubleEachLetter {
    public static void main (String[] args) {
        String s = "HelloWorld";

        String output = doubleEachLetter(s);
        System.out.println("output = " + output);
    }
    public static String doubleEachLetter(String s){
    	int len=s.length();
    	if(len<=1) return s+s;
    	else {
    	
    	char c =s.charAt(0);
    	String X = Character.toString(c)+Character.toString(c);
    	String newS = s.substring(1,len);
    	
    	return X + doubleEachLetter(newS);
    	}
    }
}
