package Day6;

import java.util.Scanner;

/*Median of two sorted arrays of different sizes
Difficulty Level : Expert
 Last Updated : 29 Dec, 2020
Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, in O(log n + log m) time complexity, when n is the number of elements in the first array, and m is the number of elements in the second array.
This is an extension of median of two sorted arrays of equal size problem. Here we handle arrays of unequal size also. 

Example: 

Input: ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
Output : The median is 3.
Explanation : The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15},
       So the median of the merged array is 3

Input: ar1[] = {2, 3, 5, 8}
        ar2[] = {10, 12, 14, 16, 18, 20}
Output : The median is 11.
Explanation : The merged array is :
        ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
        if the number of the elements are even, 
        so there are two middle elements,
        take the average between the two :
        (10 + 12) / 2 = 11.
*/
public class MedianOfTwoSortedArrayOfDifferentSize {
	public static int getMedian(int ar1[], int ar2[], int n, int m){
		int start = 0, end = n;
		while (start <= end) {
			int i1 = (start + end) / 2;
			int i2 = (n + m + 1) / 2 - i1;

			int min1 = (i1 == n) ? Integer.MAX_VALUE : ar1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : ar1[i1 - 1];

			int min2 = (i2 == m) ? Integer.MAX_VALUE :ar2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE :ar2[i2 - 1];
			
			if( max1 <= min2 && max2 <= min1 ) {
				if(( m+n )%2 == 0 ) {
					return (Math.max(max1, max2) + Math.max(min1, min2)) / 2;
				} else {
					// Agar odd hai to left side ki sbse larger value return krenge
					return Math.max(max1, max2);
				}
			} else if( max1 > min2 ){
				// left me shift krenge
				end = i1 - 1;
			} else {
				start = i1 + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ar1[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			ar1[i] = s.nextInt();
		}
		int m = s.nextInt();
		int ar2[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			ar2[i] = s.nextInt();
		}
		System.out.println( getMedian(ar1, ar2, n, m));
		s.close();
	}

}
