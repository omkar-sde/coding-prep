package org.neetcode150.twoPointers;

public class ContainerWithMostWater_11 {

    /*
        Problem Statement: array with heights, find max area between two heights
        Intuition: min height is breadth, indices difference is length
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public int maxArea(int[] height) {
        int ans = 0;

        int left = 0, right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if(height[left] <= height[right]) left++;
            else right--;

        }

        return ans;
    }

    public static void main(String[] args) {
        ContainerWithMostWater_11 obj = new ContainerWithMostWater_11();

        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test 1: " + obj.maxArea(heights1)); // Expected: 49

        int[] heights2 = {1, 1};
        System.out.println("Test 2: " + obj.maxArea(heights2)); // Expected: 1

        int[] heights3 = {4, 3, 2, 1, 4};
        System.out.println("Test 3: " + obj.maxArea(heights3)); // Expected: 16

        int[] heights4 = {1, 2, 1};
        System.out.println("Test 4: " + obj.maxArea(heights4)); // Expected: 2
    }
}
