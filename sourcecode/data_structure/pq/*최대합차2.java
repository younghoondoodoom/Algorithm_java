package org.example.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 9, 1, 5, 8, 3}));
    }

    public static int solution(int[] nums) {
        int m = nums.length;
        int n = m / 3;

        int[] left = new int[m];
        int[] right = new int[m];

        left[n - 1] = Arrays.stream(nums, 0, n).sum();

        PriorityQueue<Integer> pqLeft =
                new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pqLeft.offer(nums[i]);
        }

        for (int i = n; i < 2 * n; i++) {
            pqLeft.offer(nums[i]);
            left[i] = left[i - 1] + nums[i] - pqLeft.poll();
        }

        right[2 * n] = Arrays.stream(nums, 2 * n, m).sum();

        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        for (int i = 2 * n; i < 3 * n; i++) {
            pqRight.offer(nums[i]);
        }

        for (int i = 2 * n - 1; i > n - 1; i--) {
            pqRight.offer(nums[i]);
            right[i] = right[i + 1] + nums[i] - pqRight.poll();
        }

        int result = Integer.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            result = Math.min(result, left[i] - right[i + 1]);
        }

        return result;
    }
}
