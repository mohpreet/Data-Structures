package day7.factorial.dp;

import java.util.*;

public class FactorialTopDownMemoization {
    static Map<Integer, Long> memo = new HashMap<>();

    public static long factorial(int n) {
        // Base cases
        if (n == 0 || n == 1) return 1;

        // Check if already computed
        if (memo.containsKey(n)) return memo.get(n);

        // Recursive + memoization step
        long result = n * factorial(n - 1);

        // Store in memo
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }
}
