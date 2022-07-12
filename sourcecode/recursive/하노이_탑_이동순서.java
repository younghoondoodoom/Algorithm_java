package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = (int) (Math.pow(2, n) - 1);
        sb.append(cnt + "\n");

        hanoi(n, 1, 2, 3);

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(n - 1, start, end, mid);

        sb.append(start + " " + end + "\n");

        hanoi(n - 1, mid, start, end);
    }


}

