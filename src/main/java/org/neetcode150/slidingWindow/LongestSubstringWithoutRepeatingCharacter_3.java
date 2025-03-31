package org.neetcode150.slidingWindow;

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacter_3 {

    /*
        Problem Statement: Find length of longest substring without duplicate characters
        Intuition: use set to store unique chars. If duplicate found remove until unique again
        Time Complexity: O(n)
        Space Complexity: O(m), m is set of unique characters
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        Set<Character> store = new HashSet<>();
        for(int left = 0, right = 0; right < s.length(); right++){
            while(store.contains(s.charAt(right))){
                store.remove(s.charAt(left));
                left++;
            }
            store.add(s.charAt(right));
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacter_3 obj = new LongestSubstringWithoutRepeatingCharacter_3();

        String s1 = "abcabcbb";
        System.out.println("Test 1: " + obj.lengthOfLongestSubstring(s1)); // Expected: 3

        String s2 = "bbbbb";
        System.out.println("Test 2: " + obj.lengthOfLongestSubstring(s2)); // Expected: 1

        String s3 = "pwwkew";
        System.out.println("Test 3: " + obj.lengthOfLongestSubstring(s3)); // Expected: 3

        String s4 = "";
        System.out.println("Test 4: " + obj.lengthOfLongestSubstring(s4)); // Expected: 0

        String s5 = "au";
        System.out.println("Test 5: " + obj.lengthOfLongestSubstring(s5)); // Expected: 2
    }
}
