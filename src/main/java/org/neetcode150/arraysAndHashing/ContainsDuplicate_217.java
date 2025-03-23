package org.neetcode150.arraysAndHashing;

import java.util.*;

public class ContainsDuplicate_217 {

    /*
        Problem Statement: If an array contains duplicate return false else return true
        Intuition: Use sets to store all elements, if no duplicates are present, size will be different
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1};
        ContainsDuplicate_217 obj = new ContainsDuplicate_217();
        boolean ans = obj.containsDuplicate(nums);

        System.out.println(ans);
    }
}
