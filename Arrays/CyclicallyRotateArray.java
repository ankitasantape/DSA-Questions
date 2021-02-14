Given an array, cyclically rotate the array clockwise by one.

Examples:

Input:  arr[] = {1, 2, 3, 4, 5}
Output: arr[] = {5, 1, 2, 3, 4}

Following are steps.
1) Store last element in a variable say x.
2) Shift all elements one position ahead.
3) Replace first element of array with x.

import java.util.Arrays; 
  
public class Test 
{ 
    static int arr[] = new int[]{1, 2, 3, 4, 5}; 
      
    // Method for rotation 
    static void rotate() 
    { 
       int x = arr[arr.length-1], i; 
       for (i = arr.length-1; i > 0; i--) 
          arr[i] = arr[i-1]; 
       arr[0] = x; 
    } 
      
    /* Driver program */
    public static void main(String[] args)  
    { 
        System.out.println("Given Array is"); 
        System.out.println(Arrays.toString(arr)); 
          
        rotate(); 
          
        System.out.println("Rotated Array is"); 
        System.out.println(Arrays.toString(arr)); 
    } 
} 

Output:
Given array is
1 2 3 4 5
Rotated array is
5 1 2 3 4
Time Complexity: O(n) As we need to iterate through all the elements
Auxiliary Space: O(1)
