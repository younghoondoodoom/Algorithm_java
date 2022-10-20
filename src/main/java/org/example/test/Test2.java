package org.example.test;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
//        System.out.println(getBallCnt(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(solution(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(solution(new int[]{1, 2, 4, 9, 99999}, 2));
    }

    public static int solution(int[] buckets, int m) {
        Arrays.sort(buckets);
        int left = 1;
        int right = buckets[buckets.length - 1] - buckets[0] + 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = getBallCnt(buckets, mid);

            if (cnt < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return left - 1;
    }

    public static int getBallCnt(int[] buckets, int minLen) {
        int cnt = 1;
        int prevLocate = buckets[0];
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] - prevLocate >= minLen) {
                cnt++;
                prevLocate = buckets[i];
            }
        }
        return cnt;
    }

}
