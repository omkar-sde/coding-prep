package org.neetcode150.twoPointers;

public class ValidPalindrome_125 {

    /*
        Problem Statement: String Palindrome check for alphanumeric case insensitive characters.
        Intuition: Helper function for char check, while loop to skip non alphanumeric characters.
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            while(isAlphaNum(s.charAt(left))) left++;
            while(isAlphaNum(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            right--;
            left++;

        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    public static void main(String[] args) {
        ValidPalindrome_125 obj = new ValidPalindrome_125();

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        String s4 = "0P";

        System.out.println("Test 1: " + obj.isPalindrome(s1)); // Expected: true
        System.out.println("Test 2: " + obj.isPalindrome(s2)); // Expected: false
        System.out.println("Test 3: " + obj.isPalindrome(s3)); // Expected: true
        System.out.println("Test 4: " + obj.isPalindrome(s4)); // Expected: false
    }
}
