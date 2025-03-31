package org.neetcode150.twoPointers;

import java.util.*;

public class TwoSumII_167 {
    /*
        Problem Statement: Sorted array is given. Find pair such that their sum = target
        Intuition: sum = left + right, sum < target left++ else right++
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1, -1};

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[right] + numbers[left];
            if (sum < target) left++;
            else if (sum > target) right--;
            else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TwoSumII_167 obj = new TwoSumII_167();

        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test 1: " + Arrays.toString(obj.twoSum(numbers1, target1))); // Expected: [1, 2]

        int[] numbers2 = {1, 2, 3, 4, 4, 9, 56, 90};
        int target2 = 8;
        System.out.println("Test 2: " + Arrays.toString(obj.twoSum(numbers2, target2))); // Expected: [4, 5]

        int[] numbers3 = {1, 2, 3, 4, 5, 6};
        int target3 = 11;
        System.out.println("Test 3: " + Arrays.toString(obj.twoSum(numbers3, target3))); // Expected: [5, 6]

        int[] numbers4 = {1, 3, 5, 7};
        int target4 = 10;
        System.out.println("Test 4: " + Arrays.toString(obj.twoSum(numbers4, target4))); // Expected: [2, 4]
    }
}
