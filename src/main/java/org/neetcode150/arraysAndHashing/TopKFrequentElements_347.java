package org.neetcode150.arraysAndHashing;

import java.util.*;
public class TopKFrequentElements_347 {

    /*
        Problem Statement: In an array find k top elements with highest occurences
        Intuition: Bucket Sort. Count occ in hashmap, put it in bucket of size N as per occ
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the occurences
        Map<Integer, Integer> occMap = new HashMap<>();

        for (int num : nums) {
            occMap.put(num, occMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create bucket to store nums as per occurences
        // Note: in an array of size N, maximum times a number can be repeated is N
        List<Integer>[] bucket = new List[nums.length + 1];

        // Initialize the arraylists of bucket
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Add nums based on occurences in bucket
        for (Map.Entry<Integer, Integer> entry : occMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        // Step  4: Aggregate the values in bucket upto k starting from end(max occ) of bucket
        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int n : bucket[i]) {
                ans[index++] = n;
                if (index == k) {
                    return ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentElements_347 obj = new TopKFrequentElements_347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = obj.topKFrequent(nums, k);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
