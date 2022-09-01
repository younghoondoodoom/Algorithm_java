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
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[][] RGB = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            RGB[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2];
        }

        wr.write(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]) + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

