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
    static int d;
    static int[] arr;
    static long row, col;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String[] dNum = br.readLine().split(" ");
        long[] xy = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        arr = Arrays.stream(dNum[1].split("")).mapToInt(Integer::parseInt).toArray();
        d = Integer.parseInt(dNum[0]);

        long n = 1L << d;

        findLocate(0, n, 0, 0);

        row -= xy[1];
        col += xy[0];

        if (row >= n || row < 0 || col >= n || col < 0) {
            wr.write(-1 + "");
        } else {
            findNum(n, row, col);
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }

    public static void findNum(long length, long row, long col) {
        if (length <= 1) {
            return;
        }
        long l = length / 2;

        if (row < l && col >= l) { // 1사분면
            sb.append(1);
            findNum(l, row, col - l);
        } else if (row < l && col < l) { // 2
            sb.append(2);
            findNum(l, row, col);
        } else if (row >= l && col < l) { // 3
            sb.append(3);
            findNum(l, row - l, col);
        } else {
            sb.append(4);
            findNum(l, row - l, col - l);
        }
    }

    public static void findLocate(int numIdx, long length, long r, long c) {
        if (numIdx >= d) {
            row = r;
            col = c;
            return;
        }

        int n = arr[numIdx];
        if (n == 1) { // 1사분면
            findLocate(numIdx + 1, length / 2, r, c + length / 2);
        } else if (n == 2) {
            findLocate(numIdx + 1, length / 2, r, c);
        } else if (n == 3) {
            findLocate(numIdx + 1, length / 2, r + length / 2, c);
        } else {
            findLocate(numIdx + 1, length / 2, r + length / 2, c + length / 2);
        }
    }

}

