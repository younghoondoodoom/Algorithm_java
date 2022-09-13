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
    static final int div = 9901;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % div;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % div;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % div;
        }

        long result = (Arrays.stream(dp[n]).sum()) % div;

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

