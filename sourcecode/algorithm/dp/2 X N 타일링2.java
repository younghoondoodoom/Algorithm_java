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
    static Long[] dp = new Long[1001];
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        dp[1] = 1L;
        dp[2] = 3L;

        wr.write(recursion(n) + "");
        wr.flush();
        wr.close();
        br.close();
    }

    public static long recursion(int n) {
        if (dp[n] != null) {
            return dp[n];
        }

        dp[n] = (recursion(n - 1) + 2 * recursion(n - 2)) % 10007;
        return dp[n];
    }


}

