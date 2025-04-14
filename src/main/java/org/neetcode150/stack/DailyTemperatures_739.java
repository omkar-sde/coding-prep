package org.neetcode150.stack;

import java.util.*;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int index = stack.pop()[1];
                ans[index] = i - index;
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures_739 dt = new DailyTemperatures_739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }

}
