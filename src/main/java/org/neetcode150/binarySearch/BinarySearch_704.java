package org.neetcode150.binarySearch;

public class BinarySearch_704 {

    /*
        Problem Statement: Search in sorted array in O(logn)
        Intuition: Use pivot
        Time Complexity: O(logn)
        Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int ans = -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BinarySearch_704 bs = new BinarySearch_704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 8;
        int result = bs.search(nums, target);
        System.out.println(result);
    }

}
