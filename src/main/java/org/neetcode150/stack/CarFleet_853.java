package org.neetcode150.stack;

import java.util.*;
public class CarFleet_853 {

    /*
        Problem Statement: Car fleet. Fleet of cars reaching a target. Position and speed are given
        Intuition: Create pair(p,s). Sort descending. Calculate time taken for car to reach target. Compare it with time taken of the previous.
        Time Complexity: O(nlogn)
        Space Complexity: O(1)
     */
    public int carFleet(int target, int[] position, int[] speed) {
        // STEP1: pair to store and sort in descending order
        // (position, speed)
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // STEP 2: Sort in decreasing order based on position
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        // STEP 3: Stack to store the time taken for a car to reach the target
        Stack<Double> stack = new Stack<>();

        for(int[] p: pair){
            stack.push((double) (target - p[0])/p[1]);
            // If the current car takes less or equal time than the car ahead of it (peek),
            // it will catch up and become part of the same fleet, so we pop() the current time.
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet_853 sol = new CarFleet_853();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int result = sol.carFleet(target, position, speed);
        System.out.println(result);
    }

}
