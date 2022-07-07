package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int goldCount = getGoldCount(n);
            wr.write(goldCount + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    private static int getGoldCount(int n) {
        boolean[] arr = new boolean[n + 1];
        arr[0] = arr[1] = true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            for (int j = 1; j <= n / i; j++) {
                if (arr[i * j] == true) {
                    continue;
                } else {
                    arr[i * j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n/2; i++) {
            if (!arr[i]) {
                if (!arr[n - i]) {
                    count++;
                }
            }
        }
        return count;
    }

}

