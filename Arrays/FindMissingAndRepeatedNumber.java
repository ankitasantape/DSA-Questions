package Day1;

import java.util.HashMap;
import java.util.Scanner;

/*
Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array, 
2 is missing and 3 occurs twice 

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1
*/
public class FindMissingAndRepeatedNumber {
    public static void findMissingNRepeatedNumbers(int arr[], int n) {
    	int i = 0;
    	while( i < n ) {
    		if( arr[i] != arr[arr[i] - 1]) {
    			int temp = arr[i];
    			arr[i] = arr[arr[i] - 1];
    			arr[arr[i] - 1] = temp;
    		}
    		i++;
    	}
    	for( int j : arr ) {
    		System.out.print(j + " ");
    	}
//    	for( i = 0; i < n; i++ ) {
//    		if( arr[i] != i+1 ) {
//    			System.out.println("Missing = "+ i+1 +", Repeating = "+ arr[i]);
//    		}
//    	}
    }
    /*Method 3 (Use elements as Index and mark the visited places)
Approach: 
Traverse the array. While traversing, use the absolute value of every element as an index and 
make the value at this index as negative to mark it visited. If something is already marked negative 
then this is the repeating element. 
To find missing, traverse the array again and look for a positive value.*/
    public static void printTwoElements(int arr[], int size)
    {
        int i;
        System.out.print("The repeating element is ");
        /*  4 3 6 2 1 1
         * i=0 abs_val = 4, if( arr[3] > 0) ( 2 > 0 ) arr[3] = -2    arr { 4,3,6,-2,1,1}   
         * i=1 abs_val = 3, if( arr[2] > 0) ( 6 > 0 ) arr[2] = -6    arr { 4,3,-6,-2,1,1} 
         * i=2 abs_val = 6, if( arr[5] > 0) ( 1 > 0 ) arr[5] = -1    arr { 4,3,-6,-2,1,-1}
         * i=3 abs_val = 2, if( arr[1] > 0) ( 3 > 0 ) arr[1] = -3    arr { 4,-3,-6,-2,1,-1}
         * i=4 abs_val = 1, if( arr[0] > 0) ( 4 > 0 ) arr[0] = -4    arr { -4,-3,-6,-2,1,-1}
         * i=5 abs_val = 1, if( arr[0] > 0) ( 4 > 0 ) false  duplicate found in this array all the unique number
         * becomes negative */ 
        for (i = 0; i < size; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.println(abs_val);
        }
 
        System.out.print("And the missing element is ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
    }
    public static void findRepeatedNMissing(int a[], int n) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	for( int i : a) {
    		if( map.containsKey(i) ) {
    			System.out.println("Repeated : " + i);
    		}
    		map.put(i, 1);
    		
    	}
    	for( int i = 0; i < n; i++ ) {
    		if( !map.containsKey(i+1) ) {
    			System.out.println("Missing : " + (i + 1));
    		}
    	}
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		findMissingNRepeatedNumbers(arr,n);
		findRepeatedNMissing(arr,n);
        sc.close();
	}

}
