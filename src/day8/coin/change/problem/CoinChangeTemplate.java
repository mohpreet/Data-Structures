package day8.coin.change.problem;

import java.util.*;

public class CoinChangeTemplate {

    // Function to compute minimum coins needed
    public static int coinChange(int[] coins, int amount) {
        // Step 1: Initialize DP array
        // int[] dp = ...
        //x is index which is amount and dp[x] is coin used to create that amount
        int [] dp = new int [amount+1];


        // Step 2: Fill DP array
        Arrays.fill(dp,(amount+1));
        dp[0]=0; // for 0 amount we need zero coins

        for (int x=1;x<=amount;x++){
            for (int coin_value : coins){
                    if(coin_value<=x){
                        dp[x]=Math.min(dp[x],dp[x-coin_value]+1); // update coins for x amount
                    }
            }
        }
        // Loop over amounts
        // Loop over coins
        // Update dp[x] accordingly

        // Step 3: Return the answer
        // Check if amount is reachable
        // return ...;
        
        return dp[amount]>amount?-1: dp[amount]; // placeholder
    }

    public static void main(String[] args) {
        // Example coins array
        int[] coins = { 1,2,5 };
        int amount = 20; // fill target amount

        // Call your function
        int minCoins = coinChange(coins, amount);

        // Print result
        System.out.println("Minimum coins required = " + minCoins);
    }
}
//https://chatgpt.com/c/68ebedaa-30b0-832b-889f-2a41f433f103
