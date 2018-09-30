package PartB;


// Homework Question 6
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

public class ReverseLetter {
    public static void main (String[] args) {
        String s = "HelloWorld";

        System.out.println ("Calling reverse: ");
        String output = reverse(s);
        System.out.println("output = " + output);
    }
    public static String reverse(String s){
    	int slen = s.length();
    	String revString = "";
    	String lastChar= s.substring(0);
    	
         if (slen==0) return revString + lastChar;
         
         else { 
         char c = s.charAt(slen-1);
         String x = Character.toString(c) ;
         String s1 = s.substring(0, slen-1);
         revString = x + reverse(s1);
         return revString;
         }
        
         


    }
}
