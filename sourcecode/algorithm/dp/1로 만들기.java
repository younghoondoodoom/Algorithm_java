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
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        int x = Integer.parseInt(br.readLine());

        dp = new Integer[x + 1];
        dp[0] = dp[1] = 0;

        wr.write(recursion(x) + "");

        wr.flush();
        wr.close();
        br.close();

    }

    static int recursion(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(recursion(n - 1), Math.min(recursion(n / 3), recursion(n / 2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recursion(n / 3), recursion(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recursion(n / 2), recursion(n - 1)) + 1;
            } else {
                dp[n] = recursion(n - 1) + 1;
            }
        }
        return dp[n];
    }
}

