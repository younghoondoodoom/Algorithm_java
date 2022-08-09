package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        boolean[] plus = new boolean[1000001];
        boolean[] minus = new boolean[1000001];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input < 0) {
                minus[Math.abs(input)] = true;
            } else {
                plus[input] = true;
            }
        }

        for (int i = 1000000; i >= 1; i--) {
            if (minus[i]) {
                wr.write(-i + "\n");
            }
        }

        for (int i = 0; i <= 1000000; i++) {
            if (plus[i]) {
                wr.write(i + "\n");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

