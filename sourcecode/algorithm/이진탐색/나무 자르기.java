package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.KeyStroke;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] lans;

    public static void main(String[] args) throws IOException {

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        long M = Long.parseLong(NM[1]);

        String[] inputs = br.readLine().split(" ");

        long[] trees = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(inputs[i]);
            if (max < trees[i]) {
                max = trees[i];
            }
        }

        long min = 0;

        min = getResult(M, trees, max, min);

        wr.write(min + "");
        wr.flush();
        wr.close();
        br.close();

    }

    private static long getResult(long M, long[] trees, long max, long min) {
        while (min < max) {
            long mid = (min + max) / 2;

            long cnt = 0;
            for (long tree : trees) {
                long x = tree - mid;
                if (x > 0) {
                    cnt += x;
                }
            }

            if (cnt >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }
        return min - 1;
    }

}

