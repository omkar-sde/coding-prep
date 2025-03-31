package org.neetcode150.arraysAndHashing;

import java.util.*;

public class GroupAnagrams_49 {

    /*
        Problem Statement: In an array of strings, group the anagrams together and return a list
        Intuition: use hashmap where sorted string is the key and its value is the list of its anagram.
            (map.putIfAbsent())
        Time Complexity: O(n*mlogm), where n is number of strings and m is maximum length of the string
        Space Complexity: O(n*m)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);

            String key = new String(a);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams_49 obj = new GroupAnagrams_49();
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = obj.groupAnagrams(words);

        // Print the grouped anagrams
        System.out.println(result);
    }
}
