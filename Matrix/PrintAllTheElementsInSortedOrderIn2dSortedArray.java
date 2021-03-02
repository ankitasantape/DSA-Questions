 package Day12Matrix;

public class MinHeap {
/*Print all elements in sorted order from row and column wise sorted matrix
Difficulty Level : Hard
 Last Updated : 04 Sep, 2019
Given an n x n matrix, where every row and column is sorted in non-decreasing order. Print all elements of matrix in sorted order.
Example:

Input: mat[][]  =  { {10, 20, 30, 40},
                     {15, 25, 35, 45},
                     {27, 29, 37, 48},
                     {32, 33, 39, 50},
                   };

Output:
Elements of matrix in sorted order
10 15 20 25 27 29 30 32 33 35 37 39 40 45 48 50

 * Alternative Efficient Approach: The idea is to use Min Heap. 
 * This MinHeap based solution has the same time complexity which is O(NK log K). 
 * But for a different and particular sized array, this solution works much better. 
 * The process must start with creating a MinHeap and inserting the first element of all the k arrays. 
 * Remove the root element of Minheap and put it in the output array and insert the next element from the 
 * array of removed element. To get the result the step must continue until there is no element in the 
 * MinHeap left. 
MinHeap: A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or 
equal to the values in the children of that node. 
Mapping the elements of a heap into an array is trivial: if a node is stored at index k, 
then its left child is stored at index 2k + 1 and its right child at index 2k + 2.
 
Algorithm: 
Create a min Heap and insert the first element of all k arrays.
Run a loop until the size of MinHeap is greater than zero.
Remove the top element of the MinHeap and print the element.
Now insert the next element from the same array in which the removed element belonged.
If the array doesn’t have any more elements, then replace root with infinite.
After replacing the root, heapify the tree.

Complexity Analysis: 
Time Complexity :O( n * k * log k), Insertion and deletion in a Min Heap requires log k time. So the Overall time compelxity is O( n * k * log k)
Space Complexity :O(k), If Output is not stored then the only space required is the Min-Heap of k elements. So space Comeplexity is O(k).
*/
	static class MinHeapNode
	{
	    int element; // The element to be stored
	     
	     // index of the array from 
	     // which the element is taken
	    int i;
	     
	    // index of the next element 
	    // to be picked from array
	    int j; 
	 
	    public MinHeapNode(int element, int i, int j)
	    {
	        this.element = element;
	        this.i = i;
	        this.j = j;
	    }
	}
	MinHeapNode[] harr; // Array of elements in heap
    int heap_size; // Current number of elements in min heap
 
    // Constructor: Builds a heap from 
    // a given array a[] of given size
    public MinHeap(MinHeapNode a[], int size)
    {
        heap_size = size;
        harr = a;
        int i = (heap_size - 1)/2;
        while (i >= 0)
        {
            MinHeapify(i);
            i--;
        }
    }
 
    // A recursive method to heapify a subtree 
    // with the root at given index This method
    // assumes that the subtrees are already heapified
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l].element < harr[i].element)
            smallest = l;
        if (r < heap_size && harr[r].element < harr[smallest].element)
            smallest = r;
        if (smallest != i)
        {
            swap(harr, i, smallest);
            MinHeapify(smallest);
        }
    }
 
    // to get index of left child of node at index i
    int left(int i) { return (2*i + 1); }
 
    // to get index of right child of node at index i
    int right(int i) { return (2*i + 2); }
 
    // to get the root
    MinHeapNode getMin() 
    {
        if(heap_size <= 0) 
        {
            System.out.println("Heap underflow");
            return null;
        }
        return harr[0];
    }
 
    // to replace root with new node 
    // "root" and heapify() new root
    void replaceMin(MinHeapNode root) {
        harr[0] = root;
        MinHeapify(0);
    }
 
    // A utility function to swap two min heap nodes
    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // A utility function to print array elements
    static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
 
    // This function takes an array of 
    // arrays as an argument and All 
    // arrays are assumed to be sorted. 
    // It merges them together and 
    // prints the final sorted output.
    static void mergeKSortedArrays(int[][] arr, int k) 
    {
        MinHeapNode[] hArr = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++) 
        {
            MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }
 
        // Create a min heap with k heap nodes. Every heap node
        // has first element of an array
        MinHeap mh = new MinHeap(hArr, k);
 
        int[] result = new int[resultSize];     // To store output array
 
        // Now one by one get the minimum element from min
        // heap and replace it with next element of its array
        for(int i = 0; i < resultSize; i++) 
        {
 
            // Get the minimum element and store it in result
            MinHeapNode root = mh.getMin();
            result[i] = root.element;
 
            // Find the next element that will replace current
            // root of heap. The next element belongs to same
            // array as the current root.
            if(root.j < arr[root.i].length)
                root.element = arr[root.i][root.j++];
            // If root was the last element of its array
            else
                root.element = Integer.MAX_VALUE;
 
            // Replace root with next element of array 
            mh.replaceMin(root);
        }
 
        printArray(result);
 
    }
 
    // Driver code
    public static void main(String args[]){
//        int[][] arr= {{2, 6, 12, 34},
//                {1, 9, 20, 1000},
//                {23, 34, 90, 2000}};
        int [][]arr = {{10,20,30,40},{15,25,35,45,70},{27,29,37,48,60},{32,33,39,50}};
        System.out.println("Merged array is :");
 
        mergeKSortedArrays(arr,arr.length);
    }

}
