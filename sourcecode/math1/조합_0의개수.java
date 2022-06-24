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

        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);
        long x = n - m;

        long five_result = five_count(n) - (five_count(m) + five_count(x));
        long two_result = two_count(n) - (two_count(m) + two_count(x));

        long result = Math.min(five_result, two_result);

        wr.write(result + "");

        wr.flush();
        wr.close();
        br.close();

    }

    private static long five_count(long n) {
        long n_count = 0;
        while (n >= 5) {
            n_count += n / 5;
            n /= 5;
        }
        return n_count;
    }

    private static long two_count(long n) {
        long n_count = 0;
        while (n >= 2) {
            n_count += n / 2;
            n /= 2;
        }
        return n_count;
    }

}

