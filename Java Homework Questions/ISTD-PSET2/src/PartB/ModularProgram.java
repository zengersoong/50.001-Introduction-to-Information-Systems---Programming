package PartB;


// Homework Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class ModularProgram {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        do {
            try {
                tryexception(input);
            }
            catch (InputMismatchException ex)  {
                 System.out.println("Sorry, please enter two integer values.");




            }
            catch (ArithmeticException ex) {
                System.out.println("Sorry, you cannot mod by 0");



            }
            finally {
                System.out.println ("Do another pair of values ? (y)");
                String str = input.nextLine();
                char ch = str.charAt(0);
                System.out.println (" ch = " + ch);

                if ((ch != 'y') && (ch != 'Y')) {
                    continueInput = false;
                }
            }
        } while (continueInput);
    }

    public static void tryexception (Scanner input) throws InputMismatchException {
        // Input your code here
    	System.out.println("Welcome to the modulas computer");
    	System.out.println("Enter two integer value");
    	Scanner sc = new Scanner(System.in);
    	int i1 = 0,i2=0;
    	if(sc.hasNextInt()){
    		   i1 = sc.nextInt();
    		}
    	if(sc.hasNext()) {
    		i2 = sc.nextInt();
    	}
    	if(i1>0 && i2>0) {
    		int ans = i1%i2;
    		System.out.println(ans);
    	}
    		else {
    			throw new ArithmeticException();
    			
    		}
    	}
    
    	    }

