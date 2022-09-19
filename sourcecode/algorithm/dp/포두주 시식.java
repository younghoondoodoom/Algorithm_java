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

        int n = Integer.parseInt(br.readLine());

        int[] glasses = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            glasses[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = glasses[1];
        if (n > 1) {
            dp[2] = glasses[1] + glasses[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glasses[i],
                dp[i - 3] + glasses[i - 1] + glasses[i]));
        }

        wr.write(dp[n] + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

