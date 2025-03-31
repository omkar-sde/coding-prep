package org.neetcode150.slidingWindow;

public class BestTimeToBuyAndSellStock_121 {

    /*
        Problem Statement: Maximize profit by buying low and selling high. Find pair of such prices
        Intuition: keep moving right, if right is small than left, update left, find diff, get max
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int ans = 0;

        int left = 0, right = 0;
        while(right < prices.length){
            if(prices[right] < prices[left]) left = right;
            int diff = prices[right] - prices[left];

            ans = Math.max(ans, diff);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 obj = new BestTimeToBuyAndSellStock_121();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + obj.maxProfit(prices1)); // Expected: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2: " + obj.maxProfit(prices2)); // Expected: 0

        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + obj.maxProfit(prices3)); // Expected: 4

        int[] prices4 = {2, 4, 1};
        System.out.println("Test 4: " + obj.maxProfit(prices4)); // Expected: 2
    }
}
