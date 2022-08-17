package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        Integer[] p = new Integer[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(p);

        int result = 0;
        int curTime = 0;

        for (int i = 0; i < p.length; i++) {
            curTime += p[i];
            result += curTime;
        }

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();
    }


}

