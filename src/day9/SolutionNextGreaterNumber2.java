package day9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//Circular Array
class SolutionNextGreaterNumber2 {
    public int[] nextGreaterElement(int[] nums1) {
        HashMap<Integer, Integer> nextBiggerElementMapping = new HashMap<>();
        Stack<Integer> monotonicDecreasingStack = new Stack<>();
        int array[] = new int[nums1.length*2];
                System.arraycopy(nums1,0,array,0,nums1.length);
                System.arraycopy(nums1,0,array,nums1.length,nums1.length);


        for (int i : array) {
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
        //int nums1[] = {4, 1, 2};
        //int nums2[] = {1, 3, 4, 2};
        int nums3[] = {5, 4, 3, 2, 1};

        //new SolutionNextGreaterNumber2().nextGreaterElement(nums1);
        //new SolutionNextGreaterNumber2().nextGreaterElement(nums2);
        Arrays.stream(new SolutionNextGreaterNumber2().nextGreaterElement(nums3)).forEach(x-> System.out.print(x+"\t"));

    }
}
//https://leetcode.com/problems/next-greater-element-ii/?envType=problem-list-v2&envId=monotonic-stack
//https://www.youtube.com/watch?v=8BDKB2yuGyg