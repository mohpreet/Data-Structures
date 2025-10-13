package day8.longest.common.subsequence;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table row by row
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // match case
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // no match
                }
            }
            // Print DP array after each row
            System.out.println("After processing word1[0.." + (i-1) + "] = '" + word1.substring(0, i) + "'");
            printDP(dp, i, m);
            System.out.println();
        }

        return dp[n][m]; // final answer
    }

    // Helper method to print DP table
    private static void printDP(int[][] dp, int rows, int cols) {
        System.out.print("     ");
        for (int j = 0; j <= cols; j++) {
            if (j == 0) System.out.print("\"\"   ");
            else System.out.print((char)('a' + j - 1) + "   ");
        }
        System.out.println();

        for (int i = 0; i <= rows; i++) {
            if (i == 0) System.out.print("\"\"   ");
            else System.out.print((char)('a' + i - 1) + "    ");

            for (int j = 0; j <= cols; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String word1 = "abcde";
        String word2 = "ace";
        int lcsLength = longestCommonSubsequence(word1, word2);
        System.out.println("Length of LCS = " + lcsLength);
    }
}
//https://www.youtube.com/watch?v=jHGgXV27qtk