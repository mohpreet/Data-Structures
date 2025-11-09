package day12;

import java.util.stream.IntStream;

public class Tester1001 {
    public int majorityElement(int[] nums) {
        nums = IntStream.of(nums).sorted().toArray();
        return nums[(int) nums.length / 2];
    }

    public static void main(String[] args) {

    }
}
