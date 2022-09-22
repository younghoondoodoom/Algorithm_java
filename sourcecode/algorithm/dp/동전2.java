package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] nk = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int[] arr = new int[nk[0] + 1];
        int[] dp = new int[nk[1] + 1];

        for (int i = 1; i <= nk[0]; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 1; i <= nk[0]; i++) {
            for (int j = arr[i]; j <= nk[1]; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        int result = dp[nk[1]];

        if (result == 10001) {
            wr.write(-1 + "");
        } else {
            wr.write(result + "");
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

