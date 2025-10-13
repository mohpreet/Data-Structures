package day9;

import java.util.HashMap;
import java.util.Stack;

class SolutionNextGreaterNumber1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextBiggerElementMapping = new HashMap<>();
        Stack<Integer> monotonicDecreasingStack = new Stack<>();
        for (int i : nums2) {
            while (!monotonicDecreasingStack.isEmpty() && monotonicDecreasingStack.peek() < i) {
                nextBiggerElementMapping.put(monotonicDecreasingStack.pop(), i);
            }
            monotonicDecreasingStack.push(i);
        }
        for (int i=0;i< nums1.length;i++){
            nums1[i]=nextBiggerElementMapping.getOrDefault(nums1[i],-1);
        }

        return nums1;
    }

    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};
        int num2[] = {1, 3, 4, 2};
        new SolutionNextGreaterNumber1().nextGreaterElement(nums1,num2);
    }
}
//https://leetcode.com/problems/next-greater-element-i/?envType=problem-list-v2&envId=monotonic-stack
//https://www.youtube.com/watch?v=8BDKB2yuGyg