package org.neetcode150.arraysAndHashing;

import java.util.*;

public class ProductOfArrayExceptSelf_238 {

    /*
        Problem Statement: Product of array except itself stored at the same index as self
        Intuition: Prefix and postfix multiplication.
        Time Complexity: O(n)
        Space Complexity: O(1), product array excluded
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // Step 1: Calculate prefix
        res[0] = 1; //prefix
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        // Step 2: Calculate postfix
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 obj = new ProductOfArrayExceptSelf_238();
        int[] nums = {1, 2, 3, 4};

        int[] result = obj.productExceptSelf(nums);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
