package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        boolean[][] arr = new boolean[N][M];

        char[][] c1 = new char[N][M];
        char[][] c2 = new char[N][M];

        for (int i = 0; i < N; i++) {
            c1[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            c2[i] = br.readLine().toCharArray();
        }

        int diff = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (c1[i][j] != c2[i][j]) {
                    arr[i][j] = true;
                    diff++;
                }
            }
        }

        // 예외 처리
        if (diff == 0) {
            wr.write(0 + "");
        } else {
            wr.write(getAnswer(arr) + "");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static int getAnswer(boolean[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        if (n < 3 || m < 3) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (i == n - 3 && !(arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j])) {
                    return -1;
                }
                if (j == m - 3 && !(arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i][j + 2])) {
                    return -1;
                }
                if (arr[i][j]) {
                    reverse(arr, i, j);
                    count++;
                }
            }
        }

        boolean flag = arr[n - 3][m - 3];
        for (int i = n - 1; i > n - 3; i--) {
            for (int j = m - 1; j > m - 3; j--) {
                if (flag != arr[i][j]) {
                    return -1;
                }
            }
        }
        return count;


    }

    private static void reverse(boolean[][] arr, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                arr[i][j] = !arr[i][j];
            }
        }
    }


}

