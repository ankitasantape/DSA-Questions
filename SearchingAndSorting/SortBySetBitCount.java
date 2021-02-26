package Day9;
import java.util.Vector;
/*Sort an array according to count of set bits
Difficulty Level : Medium
 Last Updated : 23 Feb, 2021
Given an array of positive integers, sort the array in decreasing order of count of set bits in binary representations of array elements. For integers having the same number of set bits in their binary representation, sort according to their position in the original array i.e., a stable sort. For example, if the input array is {3, 5}, then the output array should also be {3, 5}. Note that both 3 and 5 have the same number set bits.

Examples:

Input: arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
Output: 15 7 5 3 9 6 2 4 32
Explanation:
The integers in their binary representation are:
    15 -1111
    7  -0111
    5  -0101
    3  -0011
    9  -1001
    6  -0110
    2  -0010
    4- -0100
    32 -10000
hence the non-increasing sorted order is:
{15}, {7}, {5, 3, 9, 6}, {2, 4, 32}

Input: arr[] = {1, 2, 3, 4, 5, 6};
Output: 3 5 6 1 2 4
Explanation:
    3  - 0011
    5  - 0101
    6  - 0110
    1  - 0001
    2  - 0010
    4  - 0100
hence the non-increasing sorted order is
{3, 5, 6}, {1, 2, 4}  

Method 1: Simple

Create an auxiliary array and store the set-bit counts of all integers in the aux array
Simultaneously sort both arrays according to the non-increasing order of auxiliary array. (Note that we need to use a stable sort algorithm)
Before sort:
int arr[] = {1, 2, 3, 4, 5, 6};
int aux[] = {1, 1, 2, 1, 2, 2}
After sort:
arr = {3, 5, 6, 1, 2, 4}
aux = {2, 2, 2, 1, 1, 1}
Implementation:
*/

// a utility function that 
// returns total set bits
// count in an integer
public static void insertionSort(int arr[], int aux[], int n)
{
    for (int i = 1; i < n; i++)
    {
        // use 2 keys because we 
        // need to sort both
        // arrays simultaneously
        int key1 = aux[i];
        int key2 = arr[i];
        int j = i - 1;
 
        /* Move elements of arr[0..i-1] 
        and aux[0..i-1], such that 
        elements of aux[0..i-1] are
        greater than key1, to one 
        position ahead of their current
        position */
        while (j >= 0 && aux[j] < key1)
        {
            aux[j + 1] = aux[j];
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        aux[j + 1] = key1;
        arr[j + 1] = key2;
    }
}
 
// Function to sort according
// to bit count using an 
// auxiliary array
public static void sortBySetBitCount(int arr[], int n)
{
    // Create an array and 
    // store count of
    // set bits in it.
    int aux[] = new int[n];
    for (int i = 0; i < n; i++)
        aux[i] = countBits(arr[i]);
 
    // Sort arr[] according 
    // to values in aux[]
    insertionSort(arr, aux, n);
}
/*Auxiliary Space: O(n)
Time complexity: O(n2)
Note: Time complexity can be improved to O(nLogn) by using a stable O(nlogn) sorting algorithm.

Method 2: Using std::sort()

Using custom comparator of std::sort to sort the array according to set-bit count
*/
private static Integer[] sortBySetBitCount(
        Integer[] arr, int n)
    {
        // TODO Auto-generated method stub
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                // TODO Auto-generated method stub
                int c1 = Integer.bitCount(arg0);
                int c2 = Integer.bitCount(arg1);
                if (c1 <= c2)
                    return 1;
                else
                    return -1;
            }
        });
        return arr;
 }
/*
Auxiliary Space : O(1)
Time complexity : O(n log n)

Method 3 : Counting Sort based

This problem can be solved in O(n) time. The idea is similar to counting sort.
Note: There can be a minimum 1 set-bit and only a maximum of 31set-bits in an integer.
Steps (assuming that an integer takes 32 bits):

Create a vector “count” of size 32. Each cell of count i.e., count[i] is another vector that stores all the elements whose set-bit-count is i
Traverse the array and do the following for each element:
Count the number set-bits of this element. Let it be ‘setbitcount’
count[setbitcount].push_back(element)
Traverse ‘count’ in reverse fashion(as we need to sort in non-increasing order) and modify the array.
*/

public class SortBySetBitCount {
    public static int countBits(int n) {
    	int count = 0;
    	while( n > 0 ) {
    		if( ( n & 1 ) > 0) {
    			count += 1;
    		}
    		n = n >> 1;
        }
    	return count;
    }

	public static void sortBySetBitCount(int arr[], int n) {
		Vector<Integer>[] count = new Vector[32];

		for (int i = 0; i < count.length; i++)
			count[i] = new Vector<Integer>();

		int setbitcount = 0;

		for (int i = 0; i < n; i++) {
			setbitcount = countBits(arr[i]);
			count[setbitcount].add(arr[i]);
		}

		// Used as an index in
		// final sorted array
		int j = 0;

		// Traverse through all bit
		// counts (Note that we sort
		// array in decreasing order)
		for (int i = 31; i >= 0; i--) {
			Vector<Integer> v1 = count[i];

			for (int p = 0; p < v1.size(); p++)
				arr[j++] = v1.get(p);
		}
	}

    	// Utility function to print 
    	// an array
    public static void printArr(int arr[], int n)
    {
    	  for (int i = 0; i < n; i++)
    	    System.out.print(arr[i] + " ");
    }
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		// 3 5 6 1 2 4 
		sortBySetBitCount(arr,arr.length);
        printArr(arr,arr.length);   
	}

}
