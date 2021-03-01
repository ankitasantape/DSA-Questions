package Day11Matrix;
/*Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/
public class SearchAnElementInAMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        // if matrix[i][j] > target then move towards left of the array
		while (i >= 0 && i <= matrix.length-1 && j >= 0 && j <= matrix[0].length-1) {
			if (matrix[i][j] > target) {
				// move towards left
				j--;
			} else if (target > matrix[i][j]) {
				// move downward
				i++;
			} else if (target == matrix[i][j]) {
				return true;
			}
		}
		return false;
    }
	public static void main(String[] args) {
		int[][] matrix = {{ 1 , 3 ,  5, 7 },
				          { 10, 11, 16, 20},
				          { 23, 30, 34, 60}};
		int target = 24;
		System.out.println( searchMatrix(matrix,target));

	}

}
