package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long div = 1000000000;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % div;
            }
            dp[i][0] = dp[i - 1][1] % div;
            dp[i][9] = dp[i - 1][8] % div;
        }

        long sum = 0L;


        for (long i : dp[n]) {
            sum += i;
        }

        wr.write(sum % div + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

