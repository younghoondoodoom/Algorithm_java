package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        int[] Nrc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursion((int) Math.pow(2, Nrc[0]), Nrc[1], Nrc[2]);

        wr.write(cnt + "");
        wr.flush();
        wr.close();
        br.close();
    }

    public static void recursion(int n, int i, int j) {
        if (n == 2) {
            if (i == 0 && j == 1) {
                cnt += 1;
            } else if (i == 1 && j == 0) {
                cnt += 2;
            } else if (i == 1 && j == 1) {
                cnt += 3;
            }
        } else {
            int m = n / 2;

            // 1사분면
            if (i < m && j >= m) {
                cnt += (m * m);
                recursion(m, i, j - m);
            } else if (i >= m && j < m) { // 3사분면
                cnt += 2 * (m * m);
                recursion(m, i - m, j);
            } else if (i >= m && j >= m) { // 4사분면
                cnt += 3 * (m * m);
                recursion(m, i - m, j - m);
            } else {
                recursion(m, i, j);
            }
        }

    }

}

