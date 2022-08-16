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
    static Long[] dp = new Long[11];
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;

        for (int i = 0; i < t; i++) {
            long result = recursion(Integer.parseInt(br.readLine()));
            wr.write(result + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static long recursion(int n) {
        if (dp[n] != null) {
            return dp[n];
        }

        dp[n] = recursion(n - 1) + recursion(n - 2) + recursion(n - 3);
        return dp[n];
    }

}

