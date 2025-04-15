package org.neetcode150.binarySearch;

public class FindMinimumInRotatedSortedArray_153 {
    /*
        Problem Statement: An array is sorted and rotated, find the minimum number in it.
        Intuition: if num[mid] is greater than num[left] that means all the numbers on left of min are greater and we move left to mid
        Time Complexity: O(logn)
        Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int ans = nums[0];
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return Math.min(ans, nums[left]);
            }

            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid] > nums[left]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray_153 solution = new FindMinimumInRotatedSortedArray_153();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums1));  // Output: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums2));  // Output: 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(solution.findMin(nums3));  // Output: 11

        int[] nums4 = {1};
        System.out.println(solution.findMin(nums4));  // Output: 1
    }
}
