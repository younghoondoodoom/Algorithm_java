package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        wr.write(hanoiCnt(n) + "\n");
        hanoi(n, 1, 2, 3);

        wr.flush();
        wr.close();
        br.close();
    }

    public static void hanoi(int n, int start, int mid, int end) throws IOException {
        if (n == 1) {
            wr.write(start + " " + end + "\n");
            return;
        }

        hanoi(n - 1, start, end, mid);

        wr.write(start + " " + end + "\n");

        hanoi(n - 1, mid, start, end);
    }

    public static int hanoiCnt(int n) {
        if (n == 1) {
            return 1;
        }
        return hanoiCnt(n - 1) * 2 + 1;
    }

}

