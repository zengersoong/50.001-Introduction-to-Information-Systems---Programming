package PartA;


// Question 3
// total: 30 points

//===============================================
// todo: complete the following program
//===============================================


public class TestMatrix {
	public static void main(String[] args) {
		double [][] a = { 
				{1,2,3},
				{4,5,6}
		};
		
		double [][] b = {
				{1,2},
				{3,4},
				{5,6}
		};
		
		double [][] c = matMpy (a,b);
		
		printMat(c);

		//////
		
		int [] f = new int [5];
		f[0] = 2;
		f[1] = 5;
		int [] g = {1, 3, 7};
		
		mergeSortedArray(f, 2, g, 3);
		
		printMat(f);
		
		
		
	}

	public static void printMat(int [] c) {
		int m;
		m = c.length;
		for (int i = 0; i< m; i++) {
			System.out.print(c[i] + ",  ");
		}
		System.out.println();
	}
	
	public static void printMat(double [][] c) {
		int m,n;
		m = c.length;
		n = c[0].length;
		for (int i = 0; i< m; i++) {
			for (int j=0; j< n; j++) {
				System.out.print(c[i][j] + ",  ");
			}
			System.out.println();
		}
		
	}
	/*
	 * public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
	 */
	
	public static double [][] matMpy ( double [][] a, double [][] b) {
		if (a[0].length != b.length)
			return null;
		else {
			int aRowLength = a.length;
			int bColLength = b[0].length;
			
			//Create a new Array Matrix here for the result
			double [][] resultMatrix= new double [aRowLength][bColLength];
			for (int i = 0; i < aRowLength; i++) {
				for (int j = 0 ; j< bColLength;j++) {
					for ( int k = 0; k < a[0].length; k++ ) {
					resultMatrix[i][j] += a[i][k] * b[k][j];
					}
				}
			}
			return resultMatrix;
		}

		
	}

	public static void mergeSortedArray(int [] a, int m, int [] b, int n) {
	    while( m > 0 && n > 0){
	    	while(m > 0 && n > 0){
	            if(a[m-1] > b[n-1]){
	                a[m+n-1] = a[m-1];
	                m--;
	            }else{
	                a[m+n-1] = b[n-1];
	                n--;
	            }
	        }
	 
	        while(n > 0){
	            a[m+n-1] = b[n-1];
	            n--;
	        }
	    }
		}
		
		
		
		
	}

			
			
			
	
		
		
		
		//TODO: implement merging of "b" into "a" to form a single sorted array in ascending order
	


