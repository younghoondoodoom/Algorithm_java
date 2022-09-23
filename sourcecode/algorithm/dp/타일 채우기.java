package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n % 2 != 0) {
            wr.write(0 + "");
        } else if (n == 2) {
            wr.write(3 + "");
        } else {
            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 2] * 3 + 2;
                for (int j = i - 4; j >= 2; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }

            wr.write(dp[n] + "");
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

