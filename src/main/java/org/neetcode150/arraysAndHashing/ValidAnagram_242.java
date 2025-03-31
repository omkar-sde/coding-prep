package org.neetcode150.arraysAndHashing;

public class ValidAnagram_242 {

    /*
        Problem Statement: Two strings having exactly same characters (including their count)
        Intuition: Use hashtable, store character counts with character ascii as key/index.
        Time Complexity: O(n), where n is the length of the string, since both have same length
        Space Complexity: O(1), constant space to store a-z alphabets
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram_242 obj = new ValidAnagram_242();
        boolean ans = obj.isAnagram("anagram", "nagaram");

        System.out.println(ans);
    }
}
