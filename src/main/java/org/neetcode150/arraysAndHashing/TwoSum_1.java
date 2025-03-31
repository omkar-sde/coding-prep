package org.neetcode150.arraysAndHashing;

import java.util.*;

public class TwoSum_1 {

    /*
        Problem Statement: In an array find a pair of numbers(indices) that add up to a target. Order of indices not required
        Intuition: Check if diff is present in map
        Time Complexity: O(n)
        Space Complexity: O(n), as we store values in hashmap
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                ans[0] = i;
                ans[1] = map.get(diff);
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum_1 obj = new TwoSum_1();

        int[] ans = obj.twoSum(nums, target);
        for (int i : ans) {
            System.out.println(nums[i]);
        }
    }
}
