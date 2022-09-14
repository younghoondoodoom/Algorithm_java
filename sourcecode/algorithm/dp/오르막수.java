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
    static final int div = 10007;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                long sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum % div;
            }
        }

        wr.write((Arrays.stream(dp[n]).sum() % div) + "");

        wr.flush();
        wr.close();
        br.close();

    }

}

