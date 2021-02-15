Merge two sorted arrays with O(1) extra space
Difficulty Level : Medium
 Last Updated : 03 Feb, 2021
We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. Extra space allowed in O(1).

Example: 

Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}
This task is simple and O(m+n) if we are allowed to use extra space. But it becomes really complicated when extra space is not allowed and doesn’t look possible in less than O(m*n) worst case time. 
The idea is to begin from last element of ar2[] and search it in ar1[]. If there is a greater element in ar1[], then we move last element of ar1[] to ar2[]. To keep ar1[] and ar2[] sorted, we need to place last element of ar2[] at correct place in ar1[]. We can use Insertion Sort type of insertion for this. 

Algorithm: 

1) Iterate through every element of ar2[] starting from last 
   element. Do following for every element ar2[i]
    a) Store last element of ar1[i]: last = ar1[i]
    b) Loop from last element of ar1[] while element ar1[j] is 
       greater than ar2[i].
          ar1[j+1] = ar1[j] // Move element one position ahead
          j--
    c) If any element of ar1[] was moved or (j != m-1)
          ar1[j+1] = ar2[i] 
          ar2[i] = last
In above loop, elements in ar1[] and ar2[] are always kept sorted.




Below is the implementation of above algorithm. 

filter_none
edit
play_arrow

brightness_4
// Java program program to merge two 
// sorted arrays with O(1) extra space.
 
import java.util.Arrays;
 
class Test
{
    static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
    static int arr2[] = new int[]{2, 3, 8, 13};
     
    static void merge(int m, int n)
    {
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i=n-1; i>=0; i--)
        {
            /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j, last = arr1[m-1];
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];
      
            // If there was a greater element
            if (j != m-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
     
    // Driver method to test the above function
    public static void main(String[] args) 
    {
        merge(arr1.length,arr2.length);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}
Output: 

After Merging 
First Array: 1 2 3 5 8 9 
Second Array: 10 13 15 20
Time Complexity: The worst case time complexity of code/algorithm is O(m*n). The worst case occurs when all elements of ar1[] are greater than all elements of ar2[].
========================================================================= Approach 2 ==================================================================================================

Efficiently merging two sorted arrays with O(1) extra space
Difficulty Level : Hard
 Last Updated : 03 Feb, 2021
Given two sorted arrays, we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a sorted array, when n is the size of the first array, and m is the size of the second array.

Example:  

Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}
Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution. 
 
We have discussed a quadratic time solution in the below post. 

In this post, a better solution is discussed.
The idea: We start comparing elements that are far from each other rather than adjacent. 
For every pass, we calculate the gap and compare the elements towards the right of the gap. Every pass, the gap reduces to the ceiling value of dividing by 2.

Examples: 
First example: 
a1[] = {3 27 38 43}, 
a2[] = {9 10 82}
Start with 
gap =  ceiling of n/2 = 4 
[This gap is for whole merged array]
3 27 38 43   9 10 82 
3 27 38 43   9 10 82
3 10 38 43   9 27 82

gap = 2:
3 10 38 43   9 27 82
3 10 38 43   9 27 82
3 10 38 43   9 27 82 
3 10 9 43   38 27 82
3 10 9 27   38 43 82

gap = 1:
3 10 9 27   38 43 82
3 10 9 27   38 43 82
3 9 10 27   38 43 82
3 9 10 27   38 43 82
3 9 10 27   38 43 82
3 9 10 27   38 43 82
Output : 3 9 10 27 38 43 82

Second Example: 
a1[] = {10 27 38 43 82}, 
a2[] = {3 9}
Start with gap = ceiling of n/2 (4):
10 27 38 43 82   3 9 
10 27 38 43 82   3 9
10 3 38 43 82   27 9
10 3 9 43 82   27 38

gap = 2:
10 3 9 43 82   27 38
9 3 10 43 82   27 38
9 3 10 43 82   27 38
9 3 10 43 82   27 38
9 3 10 27 82   43 38
9 3 10 27 38   43 82

gap = 1
9 3 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82
3 9 10 27 38   43 82

Output : 3 9 10 27 38   43 82
 Below is the implementation of the above idea:
 // Java program for Merging two sorted arrays
// with O(1) extra space
 
public class MergeTwoSortedArrays {
 
    // Function to find next gap.
    private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
 
    private static void merge(int[] arr1, 
                              int[] arr2, int n,
                              int m)
    {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap))
        {
            // comparing elements in the first
            // array.
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap]) 
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
 
            // comparing elements in both arrays.
            for (j = gap > n ? gap - n : 0;
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
 
            if (j < m)
            {
                // comparing elements in the
                // second array.
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap]) 
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int[] a1 = { 10, 27, 38, 43, 82 };
        int[] a2 = { 3, 9 };
 
        // Function Call
        merge(a1, a2, a1.length, a2.length);
 
        System.out.print("First Array: ");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
 
        System.out.println();
 
        System.out.print("Second Array: ");
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
    }
}
 
// This code is contributed by Vinisha Shah
Output
First Array: 3 9 10 27 38 
Second Array: 43 82

====================================================== Approach 3 =====================================================================================================================

// time: O(m + n)
// space: O(1)

// trade off against merge sort
// time: let's L = m + n, O(L LOG_L)
// space between O(LOG L) to O(L) due to sorting
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int i = m - 1;
        int j = n - 1;
        int k = len - 1;
        
        while (i >= 0 && j >= 0) {
            int numi = nums1[i];
            int numj = nums2[j];
            
            if (numi > numj) {
                nums1[k] = numi;
                i -= 1;
            } else {
                nums1[k] = numj;
                j -= 1;
            }
            
            k -= 1;
        }
        
        while (j >= 0) {
            int numj = nums2[j];
            nums1[k] = numj;
            j -= 1;
            k -= 1;
        }
    }
}


