package Day7;
/*Count number of occurrences (or frequency) in a sorted array
Difficulty Level : Medium
 Last Updated : 10 Sep, 2018
Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)
Examples:

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
  Output: 4 // x (or 2) occurs 4 times in arr[]

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
  Output: 1 

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
  Output: 2 

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
  Output: -1 // 4 doesn't occur in arr[] 
Method 1 (Linear Search)
Linearly search for x, count the occurrences of x and return the count.

Method 3 (Best using Improved Binary Search)
1) Use Binary search to get index of the first occurrence of x in arr[]. Let the index of the first occurrence be i.
2) Use Binary search to get index of the last occurrence of x in arr[]. Let the index of the last occurrence be j.
3) Return (j – i + 1);


*/
public class CountElement {
     // Time Complexity - O(n)
	// Returns number of times x occurs in arr[0..n-1] 
    public static int countOccurrences(int arr[], int n, int x) 
    { 
        int res = 0; 
        for (int i=0; i<n; i++) 
            if (x == arr[i]) 
              res++; 
        return res; 
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
    // Time Complexity - O(logn)
    public static int countOccurrences2(int arr[], int n, int x) 
    {
    	int first = first(arr, n, x );
    	//if element does not exit in the array
    	if( first == -1 ) {
    		return first;
    	}
    	int last = last(arr, n, x );
//    	System.out.println(first + " " + last);
    	return last - first + 1;
    }
    
    public static void main(String args[]) 
    { 
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 }; 
        int n = arr.length; 
        int x = 2; 
        System.out.println(countOccurrences(arr, n, x)); 
        System.out.println(countOccurrences2(arr, n, x)); 
    } 
}
