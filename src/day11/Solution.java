package day11;

class Solution {
    public int removeDuplicates(int[] nums) {
        int slowPointer = 0;
        for (int itr = 1; itr < nums.length; itr++) {
            if (nums[slowPointer] != nums[itr]) {
                    slowPointer++;
                    nums[slowPointer]=nums[itr];
            }
        }
        return slowPointer+1;
    }
}
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/