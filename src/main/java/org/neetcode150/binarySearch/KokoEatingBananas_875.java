package org.neetcode150.binarySearch;

import java.util.*;

public class KokoEatingBananas_875 {

    /*
        Problem Statement: Koko likes to eat slow, we have piles of banana in piles[]. Guards go away for h hours. Koko starts eating. Find minimum speed in which koko can finish all bananas before guards comeback
        Intuition: find optimal speed between low speed and high speed. Mid is curr speed and see if koko can finish bananas with curr speed. Find minimum speed to finish all bananas.
        Time Complexity: O(n*logm), n is number of piles, m is max bananas in all piles
        Space Complexity: O(1)
    */
    public int minEatingSpeed(int[] piles, int h) {
        int optimalSpeed = Arrays.stream(piles).max().getAsInt();

        int lowSpeed = 1, highSpeed = optimalSpeed;

        while (lowSpeed <= highSpeed) {
            int currSpeed = (lowSpeed + highSpeed) / 2;

            long timeWithCurrSpeed = 0;
            for (int pile : piles) {
                timeWithCurrSpeed += Math.ceil((double) pile / currSpeed);
            }

            if (timeWithCurrSpeed <= h) {
                optimalSpeed = currSpeed;
                highSpeed = currSpeed - 1;
            } else {
                lowSpeed = currSpeed + 1;
            }
        }

        return optimalSpeed;
    }

    public static void main(String[] args) {
        KokoEatingBananas_875 solution = new KokoEatingBananas_875();

        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(solution.minEatingSpeed(piles1, h1));  // Output: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(solution.minEatingSpeed(piles2, h2));  // Output: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(solution.minEatingSpeed(piles3, h3));  // Output: 23
    }
}
