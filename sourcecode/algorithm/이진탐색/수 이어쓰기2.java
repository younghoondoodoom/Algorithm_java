package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int n = sc.nextInt();
        int k = sc.nextInt();

        long numLen = 1;
        long numCnt = 9;

        // 해당 값을 구함.
        long target = 0;

        while (k > numCnt * numLen) {
            k -= numCnt * numLen;

            target += numCnt;

            numLen++;
            numCnt *= 10;
        }

        target = (target + 1) + (k - 1) / numLen;

        if (target > n) {
            System.out.println(-1);
        } else {
            int idx = (int) ((k - 1) % numLen);
            System.out.println(String.valueOf(target).charAt(idx));
        }




    }

}

