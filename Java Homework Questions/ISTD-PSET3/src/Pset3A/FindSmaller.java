package Pset3A;

/**
 * Write a method, public static int findsmaller(int x, int[] arr).
It returns the total count of all the elements in arr,
that are smaller than or equal to x. In case there are no smaller elements in arr, 
it returns 0. Write a suitable TestFindSmaller class that uses the Junit framework 
to test the correct working of findsmaller.
 Illustrate what happens when there is an error in the code. 
 (For example, deliberately introduce an error in the findSmaller method.)  
 Include failure / error messages in your submission.

 * Created by jit_biswas on 10/8/2017.
 */
public class FindSmaller {

        //constructor
        public FindSmaller() {
        }

        public int findSmaller(int x, int[] a) {
            int len = a.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (a[i]< x) count++;
            }
            return count;
        }

		
}
