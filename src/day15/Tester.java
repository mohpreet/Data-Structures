package day15;

public class Tester {

    public int maxSum(int[] num1, int[] num2) {
        int MOD = 1_000_000_007;
        int num1Length = num1.length, num2Length = num2.length;
        int num1Ptr = 0, num2Ptr = 0;
        long sum1 = 0, sum2 = 0; // running sums
        long total = 0;

        while (num1Ptr < num1Length && num2Ptr < num2Length) {
            if (num1[num1Ptr] < num2[num2Ptr]) {
                sum1 += num1[num1Ptr++];
            } else if (num1[num1Ptr] > num2[num2Ptr]) {
                sum2 += num2[num2Ptr++];
            } else { // common element (bridge)
                total += Math.max(sum1, sum2) + num1[num1Ptr];
                total %= MOD; // apply modulo here
                num1Ptr++;
                num2Ptr++;
                sum1 = 0;
                sum2 = 0;
            }
        }

        // Add remaining elements
        while (num1Ptr < num1Length) sum1 += num1[num1Ptr++];
        while (num2Ptr < num2Length) sum2 += num2[num2Ptr++];

        total += Math.max(sum1, sum2);
        total %= MOD; // final modulo

        return (int) total;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4,5,8,10};
        int[] nums2 = new int[]{4,6,8,9};

        new  Tester().maxSum(nums1,nums2);
    }
}
//https://leetcode.com/problems/get-the-maximum-score/description/