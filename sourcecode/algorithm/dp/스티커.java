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

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            wr.write(solution(Integer.parseInt(br.readLine())) + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    public static int solution(int n) throws IOException {
        int[][] stickers = new int[n + 1][2];

        int[] input1 = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int[] input2 = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            stickers[i + 1][0] = input1[i];
            stickers[i + 1][1] = input2[i];
        }

        int[][] dp = new int[n + 1][3];

        dp[1][1] = stickers[1][0];
        dp[1][2] = stickers[1][1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],
                Math.max(dp[i - 1][1], dp[i - 1][2]));

            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + stickers[i][0];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + stickers[i][1];
        }

        return Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
    }

}

