package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    private static final int INF = 1_000 * 1_000;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n + 1][3];
        int result = INF;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    dp[1][j] = arr[1][j];
                } else {
                    dp[1][j] = INF;
                }
            }

            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    result = Math.min(result, dp[n][j]);
                }
            }

        }

        wr.write(result + "");

        wr.flush();
        wr.close();
        br.close();
    }
}

