package org.example.test;

import java.util.Arrays;

public class Test4 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 9, 3, 6, 2, 4, 3},
                new int[]{9, 18, 27, 9, 15}));
    }

    public static int solution(int[] numsDivide, int[] numsDivided) {
        Arrays.sort(numsDivide);
        int cnt = 0;
        int idx = 0;
        while (idx <= numsDivide.length - 1) {
            boolean flag = true;
            for (int n : numsDivided) {
                if (n % numsDivide[idx] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return cnt;
            } else {
                cnt++;
                idx++;
            }
        }
        return -1;
    }

}
