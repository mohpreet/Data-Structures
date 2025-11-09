package day9;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class SortingUsingStack {

    public static void main(String[] args) {
        Stack<Integer> inputStack = inputStack();
        Stack<Integer> sortedStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                inputStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        System.out.println(sortedStack);
    }

    private static Stack<Integer> inputStack() {
        int[] elements = new int[]{12, 4, 2, 7, 1, 9, 6, 3, 11, 8};
        Stack<Integer> inputStack = Arrays.stream(elements).boxed()
                .collect(Collectors.toCollection(() -> new Stack<>()));
        return inputStack;
    }
}
//https://chatgpt.com/share/691102f4-4454-8011-9710-04bdc5c6e793