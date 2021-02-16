package Arrays;
/*Pair Sum
Send Feedback
You have been given an integer array/list(ARR) and a number X. Find and return the total number of pairs in the array/list which sum to X.
Note:
Given array/list can contain duplicate elements. 
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains an integer 'X'.
Output format :
For each test case, print the total number of pairs present in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= X <= 10^9
Time Limit: 1 sec
Sample Input 1:
1
9
1 3 6 2 5 4 3 2 4
7
Sample Output 1:
7
Sample Input 2:
2
9
1 3 6 2 5 4 3 2 4
12
6
2 8 10 5 -2 5
10
Sample Output 2:
0
2


 Explanation for Input 2:
Since there doesn't exist any pair with sum equal to 12 for the first query, we print 0.

For the second query, we have 2 pairs in total that sum up to 10. They are, (2, 8) and (5, 5).
*/
import java.util.Scanner;

public class PairSum {
 
  Time Complexity: O(n2) 
  Auxiliary Space: O(1)
  
	public static int pairSum(int arr[], int x) {
		int count = 0;
    	for(int i = 0; i < arr.length- 1; i++)
    	{
    		for(int j = i + 1; j < arr.length; j++)
    		{
    		   	if((arr[i] + arr[j]) == x)
    		   	{
    		   		count++;
    		   	}
    		}
    	}
    	return count;
  }
    
 Efficient solution – 
 A better solution is possible in O(n) time. Below is the Algorithm – 

Create a map to store frequency of each number in the array. (Single traversal is required)
In the next traversal, for every element check if it can be combined with any other element (other than itself!) to give the desired sum. Increment the counter accordingly.
After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two times. Hence divide count by 2 and return.
        Time Complexity - O(n)
	Space Complexity - O(n)
	
	public static int pairSumUsingHashMap(int arr[], int x) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for( int i = 0; i < arr.length; i++  ) {
			if( !map.containsKey(arr[i]) ) {
				map.put(arr[i], 0);
			}
			map.put( arr[i], map.get(arr[i]) + 1);
		}
		
		int count = 0;
		for( int i = 0; i < arr.length; i++ ) {
			if( map.get( x - arr[i] ) != null ) {
				count += map.get(x - arr[i]);
			}
			if( x - arr[i] == arr[i] ) {
				count--;
			}
		}
		return count/2;
	}
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
            {
            	a[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            int res = pairSum(a , x);
            System.out.println(res);
        	t--;
        
        }        sc.close();

	}

}
