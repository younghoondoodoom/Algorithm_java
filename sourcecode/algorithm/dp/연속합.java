package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = Integer.MIN_VALUE;
        dp[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int result = Arrays.stream(dp).max().getAsInt();

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

