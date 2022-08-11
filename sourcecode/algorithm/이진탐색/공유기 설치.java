package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.KeyStroke;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] houses;
    public static void main(String[] args) throws IOException {

        String[] NC = br.readLine().split(" ");

        int N = Integer.parseInt(NC[0]);
        int C = Integer.parseInt(NC[1]);

        houses = new long[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(houses);

        // 두 공유기 사이의 최소 거리를 기준으로 돌림
        long min = 1;
        long max = houses[N - 1] - houses[0] + 1;

        while (min < max) {
            long mid = (min + max) / 2;

            // 공유기의 최대 개수를 구함.
            long cnt = 1;
            long cur = houses[0];
            for (int i = 1; i < N; i++) {
                if (houses[i] - cur >= mid) {
                    cnt++;
                    cur = houses[i];
                }
            }
            if (cnt >= C) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }

        wr.write(min - 1 + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

