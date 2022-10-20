package org.example.test;

public class Test3 {

    public static void main(String[] args) throws Exception {
//        System.out.println(solution(new int[]{1, -1, -20, 4, -7, 5}, 2));
//        System.out.println(solution(new int[]{3, -4, 5, 1, 3, -5, -12, 4, -4,
//                5}, 3));
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, -1000}, 4));
        System.out.println(solution(new int[]{-1, -2, -3, -4, -5}, 2));

    }

    public static int solution(int[] arr, int k) {
        int sum = arr[0];
        int idx = 0;

        while (idx < (arr.length - 1)) {
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            boolean flag = false;
            for (int i = 1; i <= k; i++) {
                if (idx + i <= arr.length - 1) {
                    if (arr[idx + i] >= 0) {
                        sum += arr[idx + i];
                        idx += i;
                        flag = true;
                        break;
                    } else {
                        if (max < arr[idx + i]) {
                            max = arr[idx + i];
                            maxIdx = idx + i;
                        }
                    }
                }
            }
            if (!flag) {
                sum += max;
                idx = maxIdx;
            }
        }

        return sum;
    }

}
