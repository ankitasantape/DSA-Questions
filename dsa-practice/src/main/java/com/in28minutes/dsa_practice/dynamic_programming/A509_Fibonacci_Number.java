package com.in28minutes.dsa_practice.dynamic_programming;

import java.util.Arrays;

public class A509_Fibonacci_Number {
    public int fib_recursive(int n) {
        if(n <= 1){
            return n;
        }
        return fib_recursive(n-1) + fib_recursive(n-2);
    }

    public int fib_memo(int n, int[] memo) {
        if(n <= 1){
            return n;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] = fib_memo(n-1, memo) + fib_memo(n-2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        A509_Fibonacci_Number fibonacciNumber = new A509_Fibonacci_Number();
        int n = 12;
        int ans = fibonacciNumber.fib_recursive(12);
        System.out.println("Fibonacci of n " + n + " with brute force approach is " + ans);

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        int ans2 = fibonacciNumber.fib_memo(n, memo);
        System.out.println("Fibonacci of n "+ n +" with memoize approach is " + ans2);
    }
}
