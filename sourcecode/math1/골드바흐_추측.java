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

        boolean prime[] = new boolean[1000001];
        prime[0] = prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            boolean isProve = false;
            for (int i = 2; i <= n / 2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    wr.write(n + " = " + i + " + " + (n - i) + "\n");
                    isProve = true;
                    break;
                }
            }

            if (!isProve) {
                wr.write("Goldbach's conjecture is wrong.");
            }

            n = Integer.parseInt(br.readLine());
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

