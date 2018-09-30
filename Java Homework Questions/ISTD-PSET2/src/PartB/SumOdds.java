package PartB;



// Homework Question 5
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================

public class SumOdds {
	public static void main(String[] args) {
		int number = -54321;
		System.out.println(sumOdd(number));
	}

	public static int sumOdd(int i) {
        int ans;
        int n = Math.abs(i);
        if ( n/10 > 0 ) { //if more than 1 digit
            int digit = n % 10;
            int oddval = digit % 2 == 0? 0: digit; // Is it a even number? if it is oddVal is 0, else it is digit.
            if ( i < 0 ) 
                ans = sumOdd(-(n/10)) + oddval;
            else 
                ans = sumOdd(n/10) + oddval;
        } else {
            ans = i%2 == 0? 0: i; //checking last digit for even/odd
        }

        return ans;
    }

			

			}

/*
 * public static int sumOdd(int i) {
		String s = Integer.toString(i);
		int lenS= s.length();
		int firstDigit=0;
		
			if(i == 0)
			   return 0;
			if(i<0) {
				firstDigit=Character.getNumericValue(s.charAt(1));
				if(firstDigit%2==1) {
					int newI=Integer.parseInt(s.substring(2,lenS));
					return sumOdd(newI)-firstDigit;
				}else {
					int modI=i*-1;
					return sumOdd(modI);
				}	
			}
			if(i%2 == 1) {
				return i % 10 + sumOdd(i/10);//if i is odd
			}	
			else
			   return sumOdd(i/10); 
			

			}
}

 */

