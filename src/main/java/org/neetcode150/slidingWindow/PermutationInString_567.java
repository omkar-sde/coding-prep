package org.neetcode150.slidingWindow;

public class PermutationInString_567 {

    /*
        Problem Statement: Check if s2 contains permutation of s1
        Intuition: hashmap[26]. Count char matches in s2 of s1 char, start window at s1’s length when iterating over s2. calculate right/left char index, increment/decrement match as it is found. If total matches is 26 true
        Time Complexity: O(26) + O(n), n is length of s2
        Space Complexity: O(1), except constant space for maps.
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1Count[i] == s2Count[i]) matches++;
        }

        for(int left = 0, right = s1.length(); right < s2.length(); right++){
            if(matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            s2Count[index]++;
            if(s1Count[index] == s2Count[index]) matches++;
            else if(s1Count[index] + 1 == s2Count[index]) matches--;

            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if(s1Count[index] == s2Count[index]) matches++;
            else if(s1Count[index] - 1 == s2Count[index]) matches--;

            left++;
        }

        return matches == 26;
    }

    public static void main(String[] args) {
        PermutationInString_567 obj = new PermutationInString_567();

        String s1 = "ab", s2 = "eidbaooo";
        System.out.println("Test 1: " + obj.checkInclusion(s1, s2)); // Expected: true

        String s3 = "ab", s4 = "eidboaoo";
        System.out.println("Test 2: " + obj.checkInclusion(s3, s4)); // Expected: false

        String s5 = "adc", s6 = "dcda";
        System.out.println("Test 3: " + obj.checkInclusion(s5, s6)); // Expected: true

        String s7 = "hello", s8 = "ooolleoooleh";
        System.out.println("Test 4: " + obj.checkInclusion(s7, s8)); // Expected: false
    }
}
