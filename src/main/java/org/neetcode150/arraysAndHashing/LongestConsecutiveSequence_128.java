package org.neetcode150.arraysAndHashing;

import java.util.*;

public class LongestConsecutiveSequence_128 {

    /*
        Problem Statement: In an array find sequence of consecutive elements(nums)
        Intuition: store in set. Iterate over set, check if num-1 doesn’t exist. Keep adding length to num and checking in set.
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();

        for (int num : nums) store.add(num);

        int ans = 0;
        for (int num : store) {
            if (!store.contains(num - 1)) {
                int len = 1;
                while (store.contains(num + len)) len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 obj = new LongestConsecutiveSequence_128();

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println("Test 2: " + obj.longestConsecutive(nums));
    }
}
