package Day7;

import java.util.Scanner;

/*First and last occurrences of X 
Basic Accuracy: 47.1% Submissions: 25215 Points: 1
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Note: If the number x is not found in the array just print '-1'.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case contains two integers n and x. The second line contains n spaced integers.

Output:
Print index of the first and last occurrences of the number x with a space in between.

Constraints: 
1<=T<=100
1<=n,a[i]<=1000

Example:
Input:
2
9 5
1 3 5 5 5 5 67 123 125
9 7
1 3 5 5 5 5 7 123 125

Output:
2 5
6 6

*/
public class FindFirstAndLastOccurrence {
	/* Time Complexity- O(n) Space Complexity - O(1)*/
    public static void findFirstAndLast(int a[], int n, int x) {
    	int first = -1, last = -1;
        for( int i = 0 ; i < n ; i++ ) {
        	if( a[i] != x ) {
        		continue;
        	}
        	if( first == -1 ) {
        		first = i;
        	}
        	last = i;
        }
        if( first != -1 ) {
        	System.out.println("First : " + first);
        	System.out.println("Last : " + last);
        }else {
        	System.out.println("Not found");
        }
    }
    
    /* Time Complexity- O( log n ) Space Complexity - O(1)   */
    public static int first(int a[], int n, int x) {
           int start= 0, end = n-1;
           int res = -1; 
           while( start <= end ) {
        	   int mid =start + (end-start)/2; 
        	   if(x == a[mid]) {
        		   res = mid;
        		   end = mid - 1;
        	   } else if( x < a[mid] ) {
        		   end = mid - 1;
        	   } else {
        		   start = mid +1;
        	   }
           }
           return res;
    }
    /* Time Complexity- O( log n ) Space Complexity - O(1)   */
    public static int last(int a[], int n, int x) {
           int start= 0, end = n-1;
           int res = -1; 
           while( start <= end ) {
        	   int mid =start + (end-start)/2; 
        	   if(x == a[mid]) {
        		   res = mid;
        		   start = mid + 1;
        	   } else if( x < a[mid] ) {
        		   end = mid - 1;
        	   } else {
        		   start = mid +1;
        	   }
           }
           return res;
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int a[] = new int[n];
        for( int i = 0; i < n; i++ ) {
        	a[i] = s.nextInt();
        }
        findFirstAndLast(a,n,x);
        System.out.println("First : "+first(a,n,x));
        System.out.println("Last : "+last(a,n,x));
        s.close();
	}

}
