package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long div = 1000000009;
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                wr.write(1 % div + "\n");
                continue;
            } else if (n == 2) {
                wr.write(2 % div + "\n");
                continue;
            } else if (n == 3) {
                wr.write(4 % div + "\n");
                continue;
            }
            long result = getResult(n);
            wr.write((result % div) + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    public static long getResult(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % div;
        }
        return dp[n];
    }

}

