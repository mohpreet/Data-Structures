package day7.factorial.dp;

public class FactorialBottomUpTabulation {

    public static long factorial(int n) {
        long[] dp = new long[n + 1];

        // Base case
        dp[0] = 1;

        // Build bottom-up
        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }

        return dp[n];
    }
    public static void main(String[] args) {

        long result=factorial(9);
        System.out.println("Result is: "+result );
    }
}
