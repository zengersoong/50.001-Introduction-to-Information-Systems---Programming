package PartB;




// Homework Question 7
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================



public class RecurStringReverse {
    public static void main (String[] args) {
        System.out.println(recurStringReverse("man ate fish"));
         
        
    }
   /*
    public static String recurStringReverse (String s)  {
		   int i = s.indexOf(" ");
		   //indexing of space closest from left side  
		   //System.out.println(i);
		   //System.out.println(s);
		   return i == -1 ? s : recurStringReverse(s.substring(i + 1)) + " " + s.substring(0, i);
		   // every stack remove this which later will be added back;  s.substring(0,i)
		   //each stack reduce the string by one word
		   // after it reaches i==-1, it return s which is base case, last word in s
		   
		  
		}


    }
*/
    	public static String recurStringReverse(String s) {
    		String[] twoPart = s.split(" ",2);	
    		return twoPart.length == 1?  s : recurStringReverse(twoPart[1]) + " " + twoPart[0];
    	}
    	
    	
    }

