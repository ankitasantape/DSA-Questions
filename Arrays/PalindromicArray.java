package Day6;

import java.util.Scanner;

/*Palindromic Array 
School Accuracy: 50.0% Submissions: 16602 Points: 0
Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.

Input:
The first line of input contains an integer denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains an integer n denoting the size of the arrays. In the second line are N space separated values of the array A[].

Output:
For each test case in a new line print the required result.

Constraints:
1 <=T<= 50
1 <=n<= 20
1 <=A[]<= 10000

Example:
Input:
2
5
111 222 333 444 555
3
121 131 20

Output:
1
0

Explanation:
For First test case.
n=5;
A[0] = 111    //which is a palindrome number.
A[1] = 222   //which is a palindrome number.
A[2] = 333   //which is a palindrome number.
A[3] = 444  //which is a palindrome number.
A[4] = 555  //which is a palindrome number.
As all numbers are palindrome so This will return 1.

Time Complexity - O(n)
*/
public class PalindromicArray {
	private static boolean isPalinArray(int n, int[] a) {
		for( int i = 0; i < n; i++ ) {
			boolean ans = isPalindrome(a[i]);
			if( ans == false ) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(int N) {
		String str = "" + N;
		int len = str.length();
		for( int i = 0; i < len / 2 ; i++ ) {
			if( str.charAt(i) != str.charAt(len-i-1) ) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for( int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		System.out.println(isPalinArray(n, a));
		s.close();

	}

}
