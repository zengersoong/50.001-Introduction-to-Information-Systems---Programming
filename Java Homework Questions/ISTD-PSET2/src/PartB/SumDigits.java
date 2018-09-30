package PartB;


// Cohort Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class SumDigits {
     public static void main (String[] args) {
            int number = -543;
            System.out.println(sumDigits(number));

            // Input your codes here.
            // Suggested solution plan. Handle negative 
            // case first, then invoke sumDigits(number)

            }
        

//     public static int sumDigits(int i) {
//    	 int firstDigit=0;
//    	 int newI=i;
//    	 if (i<0) {
//    		 String s=Integer.toString(i);
//    		 int lenS=s.length();
//    		 firstDigit=Integer.parseInt(s.substring(0,2));
//    		 newI= Integer.parseInt(s.substring(2,lenS));
//    		 
//    		 return newI == 0 ? 0 : newI % 10 + sumDigits(newI/10)+firstDigit;
//    		 
//    	 }
//    			 
//    	 else {
//    	    return newI == 0 ? 0 : newI % 10 + sumDigits(newI/10)+firstDigit;
//    	
//     }
//     //sumDigits will get the second and third digits out 
//}
//}

  public static int sumDigits(int i) {
        int ans = i;
        int n = Math.abs(i);
        if ( n/10 > 0 ) //if more than 1 digit
            if ( i < 0 ) 
                ans = n % 10 + sumDigits(-(n/10));
            else 
                ans = n % 10 + sumDigits(n/10);
        return ans;
    }
}

