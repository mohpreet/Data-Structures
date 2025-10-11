package day6;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;      // start index of current substring window
        int maxLen = 0;    // answer

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // if character seen before, move left just after its last occurrence
            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }

            // update last seen index for current character
            lastSeen.put(c, right);

            // calculate window length
            int windowLen = right - left + 1;
            maxLen = Math.max(maxLen, windowLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str= "abcxbdefg";
        System.out.println(">>"+new Solution().lengthOfLongestSubstring(str));

    }

}
//https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=sliding-window
//Sliding window with dynamic size
// Flexible Size Sliding Window - Longest