package day7.fibonaci;

import java.util.Arrays;

public class FibonaciTesterTopDownMemoization {
    // Memoization array to store already computed Fibonacci numbers
    private static long[] dp;

    /**
     * Returns the nth Fibonacci number using top-down DP (memoization)
     * @param n index of the Fibonacci number
     * @return nth Fibonacci number
     */
    public static long getFibonacciElement(int n) {
        // Initialize the memoization array with -1
        // -1 indicates that the value has not been computed yet
        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        // Call the recursive helper function
        return fib(n);
    }

    /**
     * Recursive helper function with memoization
     * @param n index of the Fibonacci number
     * @return nth Fibonacci number
     */
    private static long fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // If already computed, return stored value to prevent duplicate computations
        if (dp[n] != -1) return dp[n];

        // Recursive computation with memoization
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 10;

        System.out.println(n1 + "th Fibonacci element: " + getFibonacciElement(n1));
        System.out.println(n2 + "th Fibonacci element: " + getFibonacciElement(n2));

        // Example with a larger number
        int n3 = 50;
        System.out.println(n3 + "th Fibonacci element: " + getFibonacciElement(n3));
    }
}
