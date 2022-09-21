package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                }
            }
        }

        dp[n][1] = 1;
        for (int i = n - 1; i >= 1; i--) {
            dp[i][1] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j] && dp[i][1] < dp[j][1] + 1) {
                    dp[i][1] = dp[j][1] + 1;
                }
            }
        }

        int max = 0;
        for (int[] item : dp) {
            if (max < item[0] + item[1] - 1) {
                max = item[0] + item[1] - 1;
            }
        }

        wr.write(max + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

