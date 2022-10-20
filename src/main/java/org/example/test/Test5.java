package org.example.test;

public class Test5 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 5, 8, 1, 3}));
        System.out.println(solution(new int[]{5, 2, 3, 5, 9, 14, 2, 3, 15, 19, 4, 6}));
    }

    public static int solution(int[] nums) {
        int n = nums.length / 3;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - n + 1; i++) {
            int min = i;
            int max = i + n - 1;

            int[] arr = new int[2 * n];
            int idx = 0;
            for (int j = 0; j < 3 * n; j++) {
                if (min <= j && j <= max) {
                    continue;
                }
                arr[idx++] = nums[j];
            }

            // 합 차 구하기
            int sumFirst = 0;
            int sumSecond = 0;

            for (int j = 0; j < n; j++) {
                sumFirst += arr[j];
            }
            for (int j = n; j < 2 * n; j++) {
                sumSecond += arr[j];
            }

            result = Math.min(result, sumFirst - sumSecond);
        }
        return result;
    }

}
