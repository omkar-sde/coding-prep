package org.neetcode150.slidingWindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement_424 {

    /*
        Problem Statement: In a string, find max length of repeating char if k replacements are allowed
        Intuition: HashMap, Increase right char freq if grow, reduce left char freq if shrink. Right - left + 1 - maxFreq > k
        Time Complexity: O(n)
        Space Complexity: O(m), m is no. of unique chars
     */
    public int characterReplacement(String s, int k) {
        int ans = 0;
        // Step 1: Create HashMap to count occurence of characters
        Map<Character, Integer> store = new HashMap<>();
        int maxFreq = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // Step 2: Keep updating freq of char at right index
            store.put(s.charAt(right), store.getOrDefault(s.charAt(right), 0) + 1);

            // Step 3: Calculate max frequency of right char
            maxFreq = Math.max(maxFreq, store.get(s.charAt(right)));

            // Step 4: calculate freq of remaining chars if they exceed 'k' reduce freq of left char
            // Shrink window from left
            while (right - left + 1 - maxFreq > k) {
                store.put(s.charAt(left), store.get(s.charAt(left)) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement_424 obj = new LongestRepeatingCharacterReplacement_424();

        String s1 = "XYYX";
        int k1 = 2;
        System.out.println("Test 1: " + obj.characterReplacement(s1, k1)); // Expected: 4

        String s2 = "AAABABB";
        int k2 = 1;
        System.out.println("Test 2: " + obj.characterReplacement(s2, k2)); // Expected: 5

        String s3 = "AAAA";
        int k3 = 0;
        System.out.println("Test 3: " + obj.characterReplacement(s3, k3)); // Expected: 4

        String s4 = "ABCDE";
        int k4 = 2;
        System.out.println("Test 4: " + obj.characterReplacement(s4, k4)); // Expected: 3
    }

}
