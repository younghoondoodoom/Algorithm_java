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
    static int n;
    static long[][] arr;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new long[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            long[] input = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = input[j];
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] =
                        Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        long result = 0;
        for (long l : dp[n - 1]) {
            if (l > result) {
                result = l;
            }
        }

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

