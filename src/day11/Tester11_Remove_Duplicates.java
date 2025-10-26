package day11;
//0, 0, 1, 1, 1, 2, 2, 3, 3, 4
public class Tester11_Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int slowPointer = 0;

        for (int itr = 1; itr < length; itr++) {
            if (nums[slowPointer] == nums[itr]) {
                //nums[itr] = Integer.MIN_VALUE;
                continue;
            } else {
                for (int shiftptr=itr;shiftptr-1>slowPointer;shiftptr--){
                    nums[shiftptr-1]=nums[shiftptr];
                }
                slowPointer++;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(">>>Result" + (nums[i]));
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2}; // Input array
        int[] expectedNums = {1, 2,}; // The expected answer with correct length
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        expectedNums = new int[]{0, 1, 2, 3, 4, 0, 0, 0, 0, 0};
        int k = new Tester11_Remove_Duplicates().removeDuplicates(nums); // Calls your implementation

        /*assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            System.out.println(">>>Result" + (nums[i] + "," + expectedNums[i]));
        }*/
    }
}
