
// Cohort Question 3
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================
// Why use recurrence for this 
package PartB;
import java.lang.Math;


public class RecurMulti {
    public static void main(String[] args) {
        System.out.println(multiply(4, 7));
        System.out.println(multiply(0,7));
        System.out.println(multiply(4,0));

    }

    public static int multiply(int i, int j) {
    	if (j == 0) return 0;
    	return i+ multiply(i, j-1);
    	}
    }
//loop till j becomes 0, so i + i + i + i + i + ...


// Expected result is 
/*
28 
0
0

*/

