package com.example;

/**
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
