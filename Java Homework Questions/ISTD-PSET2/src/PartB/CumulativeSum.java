package PartB;


// Cohort Question 5
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class CumulativeSum {
   public static void main (String[] args) {
       int d[] = {2,3,1,5,6,2,7};
       
       cumulativeSum(d, 1);
       for (int i = 0; i < d.length; i++) {
    	   System.out.print(d[i]+ " ");
       }
       System.out.println("");
   }
   
   

    public static void cumulativeSum(int data[], int n) {
    	int len = data.length;
    	if(n==len)return;
    	else {
    		data[n] = data[n-1]+data[n];
    		cumulativeSum(data,n+1);
    	}
    	
    	

    // Insert your code here

        
    }

}
