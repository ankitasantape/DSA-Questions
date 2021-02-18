package Day4;
/* The time complexity of the solution is O(n). 
 * Maximum profit by buying and selling a share at most twice
Difficulty Level : Hard
 Last Updated : 16 Feb, 2021
In daily share trading, a buyer buys shares in the morning and sells them on the same day. 
If the trader is allowed to make at most 2 transactions in a day, whereas the second transaction can only start after the first one is complete (Sell->buy->sell->buy). Given stock prices throughout the day, find out the maximum profit that a share trader could have made.

Examples: 

Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12, 75 
Buy at 10, sell at 22, 
Buy at 5 and sell at 80

Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
Output:  100
Trader earns 100 as sum of 28 and 72
Buy at price 2, sell at 30, buy at 8 and sell at 80

Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
Output:  72
Buy at price 8 and sell at 80.

Input:   price[] = {90, 80, 70, 60, 50}
Output:  0
Not possible to earn.
Recommended: Please try your approach on {IDE} first, before moving on to the solution.
A Simple Solution is to consider every index ‘i’ and do the following 

Max profit with at most two transactions =
       MAX {max profit with one transaction and subarray price[0..i] +
            max profit with one transaction and subarray price[i+1..n-1]  }
i varies from 0 to n-1.
Maximum possible using one transaction can be calculated using the following O(n) algorithm 
The maximum difference between two elements such that the larger element appears after the smaller number
The time complexity of the above simple solution is O(n2).

We can do this O(n) using the following Efficient Solution. 
The idea is to store the maximum possible profit of every subarray and solve the problem in the following two phases.*/
public class MaximumProfitTwoTransaction {

	public static void main(String[] args) {
		int price[] = { 2, 30, 15, 10, 8, 25, 80 };
        int n = price.length;
        System.out.println("Maximum Profit = "
                           + maxProfit(price, n));     
	}

	private static int maxProfit(int[] price, int n) {
		int profit[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			profit[i] = 0;
		}
		
		int maxprice = price[n-1];
		for( int i = n-2 ; i >= 0; i-- ) {
			if( maxprice < price[i] ) {
				maxprice = price[i];
			}
			profit[i] = Math.max( maxprice - price[i] , profit[i+1] );
		}
		
		int minprice = price[0];
		for( int i = 1 ; i < n ; i++ ) {
			if( price[i] < minprice ) {
				minprice = price[i];
			}
			profit[i] = Math.max(profit[i-1], profit[i] + price[i] - minprice );
		}
		
		int res = profit[n-1];
		return res;
	}

}
