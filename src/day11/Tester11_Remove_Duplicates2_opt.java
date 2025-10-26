package day11;
//0, 0, 1, 1, 1, 2, 2, 3, 3, 4
public class Tester11_Remove_Duplicates2_opt {
    public int removeDuplicates(int[] nums) {

        int slowPointer = 2;

        for (int fastPointer = 2; fastPointer < nums.length; fastPointer++) {
            if(nums[fastPointer]!=nums[slowPointer-2]){
                nums[slowPointer]=nums[fastPointer];
                slowPointer++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(">>>Result" + (nums[i]));
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2}; // Input array
        int[] expectedNums = {1, 2,}; // The expected answer with correct length
        nums = new int[]{0,0,1,1,1,1,2,3,3};
        expectedNums = new int[]{0,0,1,1,2,3,3,0,0};
        int k = new Tester11_Remove_Duplicates2_opt().removeDuplicates(nums); // Calls your implementation

        /*assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            System.out.println(">>>Result" + (nums[i] + "," + expectedNums[i]));
        }*/
    }
}
