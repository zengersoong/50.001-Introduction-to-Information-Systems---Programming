package PartB;


// Homework Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================




import java.util.InputMismatchException;
import java.util.Scanner;

public class Handshake {
    public static void main (String[] args) {
        try {
         
            System.out.println(handshake(10));
            System.out.println(handshake(3));
            System.out.println(handshake(-4));

        }
        catch (InputMismatchException e) {
        	System.out.println(e);
        	
        }
                // Input your codes here
    }

    public static int handshake (int k) throws InputMismatchException {
    		if(k<0) {
    			throw new InputMismatchException("Sorry. Number of person cannot be negative.");
    		}
    		else {
    		if(k <= 1){
    	        return 0;

    	    } else {
    	        return ((k-1) + handshake(k-1));
    		}
    }
}
}
    		
    

