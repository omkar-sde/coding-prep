package org.neetcode150.twoPointers;

import java.util.*;

public class ThreeSum_15 {
    /*
        Problem Statement: Sum of triplets in an array where target is 0. Multiple triplets but no duplicates
        Intuition: skip duplicates, i, j, k. Sum < 0 j++ else k++
        Time Complexity: O(n^2)
        Space Complexity: O(1), exclude result space
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            if (i != 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) left++;
                else if(sum > 0) right--;
                else{
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                }
                while(left < right && nums[left] == nums[left-1]) left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSum_15 obj = new ThreeSum_15();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + obj.threeSum(nums1)); // Expected: [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        System.out.println("Test 2: " + obj.threeSum(nums2)); // Expected: []

        int[] nums3 = {0, 0, 0};
        System.out.println("Test 3: " + obj.threeSum(nums3)); // Expected: [[0, 0, 0]]

        int[] nums4 = {-2, 0, 1, 1, 2};
        System.out.println("Test 4: " + obj.threeSum(nums4)); // Expected: [[-2, 0, 2], [-2, 1, 1]]
    }
}
