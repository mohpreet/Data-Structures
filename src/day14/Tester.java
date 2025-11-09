package day14;

import java.util.LinkedHashMap;

public class Tester {

    public static void main(String[] args) {
        /** If the given array is a sorted array
         * Two Sum in a SORTED ARRAY
         * Input: nums = [1, 2, 3, 4, 6], target = 6
         * Output: [1, 3](because nums[1] + nums[3] = 2 + 4 = 6)
         */
        int target =6;
        int nums[]= {1,2,3,4,6};
        LinkedHashMap<Integer,Integer> map= new LinkedHashMap<>();
        for(int i=0; i<nums.length;i++){
             int remainder= target-nums[i];
             for(int j=i+1; j<nums.length;j++){
                 if(nums[j]==remainder) {
                     map.put(nums[i],remainder);
                 }
             }
        }
        System.out.println(map);
    }
}
