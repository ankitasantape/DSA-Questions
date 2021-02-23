package Day8;
/*Efficient Solution 
Approach: The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases. 
The given number is greater than the current number: This will ensure, that all the elements in the current row are smaller than the given number as the pointer is already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and continue the search on the next row. Here elimination means that row needs not to be searched.
The given number is smaller than the current number: This will ensure, that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continue the search on the previous column i.e. the column at the immediate left.
The given number is equal to the current number: This will end the search.
Algorithm: 
Let the given element be x, create two variable i = 0, j = n-1 as index of row and column
Run a loop until i = 0
Check if the current element is greater than x then decrease the count of j. Exclude the current column.
Check if the current element is less than x then increase the count of i. Exclude the current row.
If the element is equal then print the position and end.
Time Complexity: O(n). 
Only one traversal is needed, i.e, i from 0 to n and j from n-1 to 0 with at most 2*n steps. 
The above approach will also work for m x n matrix (not only for n x n). Complexity would be O(m + n). 
Space Complexity: O(1). 
No extra space is required.
*/
public class SearchInRowiseColumnwiseSortedArray {
    
	static class Pair<V,K>{
		V first ;
		K second ;
	}
	
	public static void main(String[] args) {
		int a[][] = {{ 10, 20, 30, 40 },
		             { 15, 25, 35, 45 },
		             { 27, 29, 37, 48 },
		             { 32, 38, 39, 50 }
		             };
		int key = 29;
		System.out.println( "Row : "+search(a,4,4,key).first + " Column : " + search(a,4,4,key).second );
        
	}

	private static Pair<Integer,Integer> search(int[][] a,int m, int n, int key) {
		int i = 0, j = m-1;
		while ( i >= 0 && i < n && j >= 0 && j < m ) {
			if( a[i][j] == key ) {
				Pair<Integer,Integer> p = new Pair<>();
				p.first = i;
				p.second = j;
				return p;
			}
			else if( a[i][j] > key ) {
				j--;
			} else if( a[i][j] < key ) {
				i++;
			}
		}
		Pair<Integer,Integer> p1 = new Pair<>();
		p1.first = -1;
		p1.second = -1;
		return p1;
	}

}
