package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sqrt = (int)Math.sqrt(N);

        boolean[] isPrime = new boolean[N + 1];
        isPrime[0] = isPrime[1] = true;

        for (int i = 1; i <= sqrt; i++) {
            for (int j = 1; j <= N / i; j++) {
                if (isPrime[i * j]) {
                    continue;
                } else {
                    isPrime[i * j] = true;
                }
            }
        }

        while (N > 1) {
            for (int i = 2; i <= N; i++) {
                if (isPrime[i]) {
                    if (N % i == 0) {
                        wr.write(i + "\n");
                        N /= i;
                        break;
                    }
                }
            }
        }
        wr.flush();
        wr.close();
        br.close();

    }

}

