package day9;

import java.util.HashMap;
import java.util.Stack;

class SolutionTemprature {
    public int[] dailyTemperatures(int[] temperatures) {
        HashMap<Integer, Integer> nextBiggerElementMapping = new HashMap<>();
        Stack<Integer> monotonicDecreasingStack = new Stack<>();
        for (int i=0;i<temperatures.length;i++) {
            while (!monotonicDecreasingStack.isEmpty() && temperatures[monotonicDecreasingStack.peek()] < temperatures[i]) {
                nextBiggerElementMapping.put(monotonicDecreasingStack.pop(), i);
            }
            monotonicDecreasingStack.push(i);
        }
        for (int i=0;i< temperatures.length;i++){
            temperatures[i]= nextBiggerElementMapping.getOrDefault(i,0)==0?0:nextBiggerElementMapping.getOrDefault(i,0)-i;
        }

        return temperatures;
    }

    public static void main(String[] args) {
        int nums1[] = {73,74,75,71,69,72,76,73};
        new SolutionTemprature().dailyTemperatures(nums1);
    }
}
//https://leetcode.com/problems/daily-temperatures/?envType=problem-list-v2&envId=monotonic-stack
//https://www.youtube.com/watch?v=8BDKB2yuGyg