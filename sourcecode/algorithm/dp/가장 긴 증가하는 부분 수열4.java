package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] dp = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<Integer>();
            dp[i].add(arr[i]);
        }

        for (int i = 1; i <= n; i++) {
            int maxIdx = i;
            for (int j = i - 1; j >= 1; j--) {
                if (arr[i] > arr[j] && dp[maxIdx].size() < dp[j].size() + 1) {
                    maxIdx = j;
                }
            }
            if (i != maxIdx) {
                dp[i].addAll(dp[maxIdx]);
            }
        }

        int maxIdx = 0;
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i].size() > maxSize) {
                maxIdx = i;
                maxSize = dp[i].size();
            }
        }

        wr.write(maxSize + "\n");

        for (int i = dp[maxIdx].size() - 1; i >= 0; i--) {
            wr.write(dp[maxIdx].get(i) + " ");
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

