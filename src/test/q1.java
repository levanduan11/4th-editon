package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class q1 {
 static    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (prevMap.containsKey(diff)) {
                return new int[]{ prevMap.get(diff), i };
            }
            prevMap.put(nums[i], i);
        }
        return new int[0]; // Guranteed solution, no need for return
    }

    public static void main(String[] args) {
        int arr[]={3,2,4};
        int a=6;
        int []t=twoSum(arr,a);
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }
}
