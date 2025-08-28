package com.in28minutes.dsa_practice.binary_search;

public class A04_Median_Of_Two_Sorted_Array {

    public double findMedianSortedArrays(int[] X, int[] Y) {

        int m = X.length;
        int n = Y.length;
        if(m > n){
            return findMedianSortedArrays(Y, X);
        }
        int left = 0;
        int right = m;

        while(left <= right){
            int midX = (left + right)/2;
            int midY = (m+n+1)/2 - midX;

            int maxLeftX = midX == 0 ? Integer.MIN_VALUE : X[midX-1];
            int minRightX = midX == m ? Integer.MAX_VALUE : X[midX];

            int maxLeftY = midY == 0 ? Integer.MIN_VALUE : Y[midY-1];
            int minRightY = midY == n ? Integer.MAX_VALUE : Y[midY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((m+n)%2 == 0){
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
                }
                else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                right = midX-1;
            }
            else {
                left = midX+1;
            }
        }

        return -1;
    }
}
